package com.microservices.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.microservice.commons.users.entity.Usuario;
import com.microservices.oauth.service.UsuarioService;

@SuppressWarnings("deprecation")
@Component
public class InfoAdicional implements TokenEnhancer{
    @Autowired
    private UsuarioService service;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();

        Usuario usuario = service.findByUsername(authentication.getName());
        info.put("nombre", usuario.getNombre());
        info.put("appellido", usuario.getApellido());
        info.put("correo", usuario.getEmail());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }


}
