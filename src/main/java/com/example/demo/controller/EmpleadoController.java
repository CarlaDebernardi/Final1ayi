package com.example.demo.controller;

import com.example.demo.entity.Empleado;
import com.example.demo.exception.EmpleadoException;
import com.example.demo.service.IEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    public IEmpleadoService empleadoService;

@GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAll() {
        List<Empleado> empleados = empleadoService.listarEmpleado();
        try {
            if (empleados.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(empleados);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/get-name")
    public ResponseEntity<?> encontrarPorNombre(@RequestParam String nombre) {
       List <Empleado> empleado = empleadoService.encontrarPorNombre(nombre);
        try {
            if (empleado == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(empleado);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> encontrarPorLegajo(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.encontrarEmpleado2(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get-lastName")
    public ResponseEntity<?> encontrarPorApellido(@RequestParam String apellido) {
        List<Empleado> empleados = empleadoService.encontrarPorApellido(apellido);
        try {
            if (empleados == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(empleados);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Empleado empleado) {

        try {
            return new ResponseEntity(empleadoService.crearEmpleado(empleado), HttpStatus.CREATED);
        } catch (EmpleadoException empleadoException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Empleado empleado) {
        try {
            return new ResponseEntity(empleadoService.modificarEmpleado(id, empleado), HttpStatus.OK);
        } catch (EmpleadoException  empleadoException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El n° de legajo ingresado no corresponde a un empleado");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id) {
        try {

            if (id == null || id.describeConstable().isEmpty()) {
                throw new IllegalArgumentException("El número de legajo no puede estar vacío.");
            }

            empleadoService.eliminar(id);
            return ResponseEntity.noContent().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
