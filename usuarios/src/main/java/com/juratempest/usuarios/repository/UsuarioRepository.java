package com.juratempest.usuarios.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juratempest.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    public Usuario findByEmail(String email);
    
    boolean existsByUsername(String username);

    Optional<Usuario> findByUsernameAndActiveTrue(UUID id);
}
