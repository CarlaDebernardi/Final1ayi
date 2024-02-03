package com.example.demo.service;

import com.example.demo.entity.Usuario;
import com.example.demo.exception.EmpleadoNotFoundException;
import com.example.demo.exception.UsuarioNotFound;
import com.example.demo.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Usuario save(Usuario usuario) {

        return (Usuario) usuarioRepository.save(usuario);
    }

    /*    @Override
        @Transactional
        public Usuario update(Integer id, Usuario usuario) {
            Optional<Usuario> usuarioOptional = Optional(usuarioRepository.findById(id));
            Usuario user = usuarioOptional.get();
            user.setNombre(usuario.getNombre());
            user.setPasswordUsuario(usuario.getPasswordUsuario());
            return (Usuario) usuarioRepository.save(user);

        }
    */
    @Override
    @Transactional
    public Optional findById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId());
    }

    //public List<Usuario> findAll= usuarioRepository.findAll();

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

  /*  public Boolean encontrarUsuario (String nombre, String password){
        Usuario user = usuarioRepository.findByNombre(nombre);
        if (user != null && user.getPassword().equals(password)){
            return true;
        }  else{ return false;}
}
*/ @Override
  @Transactional
    public Usuario encontrarUsuario2(String nombre, String password) {
        Usuario user = usuarioRepository.findByNombreUsuario(nombre);
        return user;
    }

}
