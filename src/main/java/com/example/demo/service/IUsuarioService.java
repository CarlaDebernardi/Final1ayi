package com.example.demo.service;

import com.example.demo.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUsuarioService {
    Usuario save(Usuario usuario);

    //Usuario update(Integer id, Usuario usuario);

    Optional findById(Usuario usuario);

    void delete(Usuario usuario);

    //Boolean encontrarUsuario (String nombre, String passwordUsuario);
    public Usuario encontrarUsuario2(String nombre, String password);

    ResponseEntity autenticarUsuario(String nombre, String password);

    @Transactional
    Usuario encontrarUsuario3(String nombre, String password);
}
