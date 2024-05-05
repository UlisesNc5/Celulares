package com.microservices.oauth.service;

import com.microservice.commons.users.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);

}
