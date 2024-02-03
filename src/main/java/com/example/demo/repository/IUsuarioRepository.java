package com.example.demo.repository;

import com.example.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Integer>{

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    Usuario findByNombreUsuario (@Param("nombre") String nombre);

}
