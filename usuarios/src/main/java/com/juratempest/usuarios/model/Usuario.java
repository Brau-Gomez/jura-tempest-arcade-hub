package com.juratempest.usuarios.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {


    @Id // Indica que el "LONG id" es la clave primaria de la clase.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // Indica que el campo "username" no puede ser nulo y debe ser único en la base de datos.
    private String username;
    @Column(nullable = false) // Indica que el campo "passwordHash" no puede ser nulo en la base de datos.
    private String passwordHash;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nombreCompleto;
    @Column(nullable = false)
    private boolean userStatus;
    @Column(nullable = false)
    private LocalDate userCreado;

    //Relacion de tablas
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;
}
