package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.DTO.EmpleadoDTO;
import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> todosLosEmpleados(){
        return this.empleadoRepository.findAll();
    }

    public Optional<Empleado> empleadoPorId(Integer id){
        return this.empleadoRepository.findById(id);
    }

    public Empleado saveEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setCorreo(empleadoDTO.getCorreo());
        empleado.setPassword(empleadoDTO.getPassword());
        empleado.setEmpresa(empleadoDTO.getEmpresa());
        empleado.setRol(empleadoDTO.getRol());
        return this.empleadoRepository.save(empleado);
    }

    public Empleado actualizarEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setId(empleadoDTO.getId());
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setCorreo(empleadoDTO.getCorreo());
        empleado.setPassword(empleadoDTO.getPassword());
        empleado.setEmpresa(empleadoDTO.getEmpresa());
        empleado.setRol(empleadoDTO.getRol());
        return this.empleadoRepository.save(empleado);
    }

    public boolean borrarEmpleado(Integer id){
        empleadoRepository.deleteById(id);
        if (empleadoRepository.findById(id)!=null){
            return true;
        }
        return false;
    }

    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return this.empleadoRepository.findByEmpresa(id);
    }
}
