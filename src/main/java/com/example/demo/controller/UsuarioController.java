package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.exception.UsuarioNotFound;
import com.example.demo.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    IUsuarioService usuarioService;

    @PostMapping("/ingresar")
    ResponseEntity<?> ingresar(@RequestParam String nombre, @RequestParam String password)
{

        Usuario usuario = usuarioService.encontrarUsuario2(nombre, password);
        if (usuario != null) {
        return new ResponseEntity<>("Autenticación exitosa", HttpStatus.OK);

        } else {
        return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }

        }
        }

           /* return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (UsuarioNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }
}
*/