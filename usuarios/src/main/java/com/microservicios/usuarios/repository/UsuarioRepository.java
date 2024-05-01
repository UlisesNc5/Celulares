package com.microservicios.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.microservicios.usuarios.entity.Usuario;

public interface UsuarioRepository  extends PagingAndSortingRepository<Usuario, Long>{
    public Usuario findByUsername(String username);
    public Usuario findByUsernameAndEmail(String username, string email);

}
