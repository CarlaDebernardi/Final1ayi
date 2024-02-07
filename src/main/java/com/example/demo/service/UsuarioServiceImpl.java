package com.example.demo.service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario encontrarUsuario(Usuario usuario) {
        Usuario user = usuarioRepository.findByNombreUsuario(usuario.getNombre());
        return user;

    }
}