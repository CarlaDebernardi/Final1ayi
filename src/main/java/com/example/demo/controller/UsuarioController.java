package com.example.demo.controller;

import com.example.demo.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("get-user")
    ResponseEntity<?> getUser(@RequestParam String nombre, @RequestParam String passwordUsuario){
       try{
           return ResponseEntity.status(HttpStatus.OK).body(usuarioService.encontrarUsuario(nombre,passwordUsuario));
       }
       catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

}
