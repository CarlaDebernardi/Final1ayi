package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="empleados")
public class Empleado {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "legajo")
    private Integer legajo;
    @Column(name = "nombre_empleado")
    private String nombre;
    @Column(name = "apellido_empleado")
    private String apellido;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "sucursal")
    private String sucursal;
    @Column(name = "antiguedad_anios")
    private Integer antiguedad;
}
