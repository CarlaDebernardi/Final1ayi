package com.example.demo.service;

import com.example.demo.entity.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    Usuario save(Usuario usuario);

    //Usuario update(Integer id, Usuario usuario);

    Optional findById(Usuario usuario);

    void delete(Usuario usuario);

    Boolean encontrarUsuario (String nombre, String passwordUsuario);
}
