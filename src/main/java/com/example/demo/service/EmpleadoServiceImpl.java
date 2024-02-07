package com.example.demo.service;


import com.example.demo.entity.Empleado;
import com.example.demo.exception.EmpleadoNotFoundException;
import com.example.demo.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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
    public void eliminar(Integer id) {
        Empleado empleado = empleadoRepository.getReferenceById(id);
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
    public Empleado encontrarEmpleado2(Integer id) {
        try {
            Optional<Empleado> entityOptional = empleadoRepository.findById(id);
            return entityOptional.get();
        } catch (EmpleadoNotFoundException e) {
            throw new EmpleadoNotFoundException("El legajo ingresado no correspondo a ningún empleado registrado.");
        }
    }

    @Override
    @Transactional
    public Empleado modificarEmpleado(Integer id, Empleado empleado) {
            Optional<Empleado> optionalEmpleado = empleadoRepository.findById(id);
            if (optionalEmpleado.isPresent()) {
                Empleado empleadoUpdate = optionalEmpleado.get();
                if (empleado.getNombre() != null) {
                    empleadoUpdate.setNombre(empleado.getNombre());
                }
                if (empleado.getApellido() != null) {
                    empleadoUpdate.setApellido(empleado.getApellido());
                }
                if (empleado.getAntiguedad() != null) {
                    empleadoUpdate.setAntiguedad(empleado.getAntiguedad());
                }
                if (empleado.getCargo() != null) {
                    empleadoUpdate.setCargo(empleado.getCargo());
                }
                if (empleado.getSucursal() != null) {
                    empleadoUpdate.setSucursal(empleado.getSucursal());
                }
                return empleadoRepository.save(empleadoUpdate);
            }else {
                throw new EmpleadoNotFoundException("El legajo ingresado no correspondo a ningún empleado registrado.");

        }
    }


}
