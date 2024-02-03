package com.example.demo.repository;

import com.example.demo.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

 //Empleado findByLegajo (Integer legajo);

 List <Empleado> findByNombre (String nombre);

 List<Empleado> findByApellido (String apellido);
}
