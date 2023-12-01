package com.spring2.practicaSpring2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table(name ="persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersona;
    
    @NotEmpty(message = "El nombre no puede estar en blanco")
    private String nombre;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String apellido;
    
    @NotEmpty(message = "El email no puede estar en blanco")
    @Email
    private String email;
    
    private String telefono;

    @NotNull
    private Double saldo;
   
}
