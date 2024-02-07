package com.example.demo.service;

import com.example.demo.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;


public interface IUsuarioService {

    @Transactional
    Usuario encontrarUsuario(Usuario usuario);
}
