package com.juratempest.usuarios.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.juratempest.usuarios.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByName(String name);

    boolean existsByName(String name);
}
