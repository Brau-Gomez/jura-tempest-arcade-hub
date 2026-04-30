package com.juratempest.usuarios.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String username;
    private String passwordHash;
    private String email;
    private String nombreCompleto;
    private boolean userStatus;
    private LocalDate userCreado;
    private RolDTO rol;
}