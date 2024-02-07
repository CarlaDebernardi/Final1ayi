package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.exception.UsuarioNotFound;
import com.example.demo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;


    @PostMapping("/ingresar")
    ResponseEntity <?> ingresar (@RequestBody Usuario usuario){
        Usuario user = usuarioService.encontrarUsuario(usuario);
        if (user != null && user.getPassword().equals(usuario.getPassword())) {
            return new ResponseEntity<>("Autenticación exitosa", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Los datos ingresados no corresponden a un usuario registrado.", HttpStatus.NOT_FOUND);
        }

    }
}

