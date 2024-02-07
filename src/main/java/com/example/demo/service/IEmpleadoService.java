package com.example.demo.service;

import com.example.demo.entity.Empleado;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmpleadoService {
    @Transactional(readOnly = true)
    List<Empleado> listarEmpleado();

    @Transactional
    void eliminar(Integer id);

    @Transactional
    Empleado crearEmpleado(Empleado empleado);


    @Transactional
    Empleado encontrarEmpleado2(Integer id);

    @Transactional
    Empleado modificarEmpleado(Integer id, Empleado empleado);

}
