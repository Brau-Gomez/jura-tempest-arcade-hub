package com.juratempest.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juratempest.usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Agregar comentarios
    Usuario findByEmail(String email);
    
    boolean existsByUsername(String username);
    
    boolean existByemail(String email);


}
