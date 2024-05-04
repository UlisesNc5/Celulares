package com.microservices.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.microservice.commons.users.entity.Usuario;
import com.microservices.oauth.client.UsuarioFeignClient;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsuarioService implements UserDetailsService{
    private Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioFeignClient client;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario user = client.findByUsername(username);

        if(user == null){
            String error = "error en el login el usuario no existe " + username;
            log.error(error);
            throw new UsernameNotFoundException(error);
        }

        List<GrantedAuthority> autorities = user.getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .peek(authority -> log.info("Role: " + authority.getAuthority()))
            .collect(Collectors.toList())
        ;

        log.info("Usuario autenticado " + username);

        return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, autorities);
    }
}
