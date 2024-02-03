package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="empleados")
public class Empleado implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @NotNull
    @PositiveOrZero(message = "Debe ingresar un número positivo entero, a partir de 0")
    @Column(name = "legajo")
    private Integer id;
    @NotEmpty
    @Size (min=2, max=20, message = "Debe contener entre dos y 20 caracteres")
    @Column(name = "nombre_empleado")
    private String nombre;
    @Column(name = "apellido_empleado")
    @NotEmpty
    @Size (min=2, max=20, message = "Debe contener entre dos y 20 caracteres")
    private String apellido;
    @Column(name = "cargo")
    @NotEmpty
    @Size (min=2, max=20, message = "Debe contener entre dos y 20 caracteres")
    private String cargo;
    @Column(name = "sucursal")
    @NotEmpty
    @Size (min=2, max=20, message = "Debe contener entre dos y 20 caracteres")
    private String sucursal;
    @Column(name = "antiguedad_anios")
    @NotNull
    @PositiveOrZero (message = "Debe ingresar un número positivo entero, a partir de 0")
    @Max( value=45)
    private Integer antiguedad;
}
