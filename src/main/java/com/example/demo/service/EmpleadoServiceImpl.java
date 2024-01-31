package com.example.demo.service;


import com.example.demo.entity.Empleado;
import com.example.demo.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }


    @Override
    @Transactional
    public void eliminar(Integer legajo) {
        Empleado empleado = empleadoRepository.findByLegajo(legajo);
        empleadoRepository.delete(empleado);
    }

    @Override
    @Transactional
    public  Empleado crearEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        return empleado;
    }

    @Override
    @Transactional
    public Empleado encontrarProveedor(Integer legajo) {
       Empleado empleado = empleadoRepository.findByLegajo(legajo);
        return empleado;
    }


}
