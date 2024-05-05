package com.microservicios.zuul.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
@SuppressWarnings("deprecation")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/security/oauth/**") .permitAll()
            .antMatchers(HttpMethod.GET, "/api/celulares/list", "/api/store/", "/api/us/usuarios") .permitAll()
            .antMatchers(HttpMethod.GET, "/api/celulares/{id}", "/api/store/celular/{id}/cantidad/{cantidad}", "/api/us/usuarios/{id}}") .hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.POST, "/api/celulares", "/api/us/usuarios") .hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/api/celulares/{id}", "/api/us/usuarios/{id}") .hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/api/celulares{id}", "/api/us/usuarios/{id}") .hasAnyRole("ADMIN")

            .anyRequest().authenticated()
        ;
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwkAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwkAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("llave_belica_4x4");
        return jwtAccessTokenConverter;
    }

}
