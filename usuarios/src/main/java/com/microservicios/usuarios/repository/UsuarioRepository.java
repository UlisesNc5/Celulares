package com.microservicios.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservice.commons.users.entity.*;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository  extends PagingAndSortingRepository<Usuario, Long>{

    @RestResource(path = "buscar-username")
    public Usuario findByUsername(@Param("nombre") String username);
    public Usuario findByUsernameAndEmail(String username, String email);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username = :username")
    public Usuario obtenerPorUsername(@Param("username") String username);


    @Query(value = "SELECT u FROM Usuario u WHERE u.username = :username AND u.email = :email")
    public Usuario ObtenerPorUsernameYEmail(@Param("username") String username, @Param("email") String email);
}
