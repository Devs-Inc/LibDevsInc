package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.DTO.EmpleadoDTO;
import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.repository.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServ {
    private final EmpleadoRepo empleadoRepo;

    public EmpleadoServ(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> todosLosEmpleados(){
        return this.empleadoRepo.findAll();
    }

    public Optional<Empleado> empleadoPorId(Integer id){
        return this.empleadoRepo.findById(id);
    }

    public Empleado saveEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setCorreo(empleadoDTO.getCorreo());
        empleado.setPassword(empleadoDTO.getPassword());
        empleado.setEmpresa(empleadoDTO.getEmpresa());
        empleado.setRol(empleadoDTO.getRol());
        return this.empleadoRepo.save(empleado);
    }

    public Empleado actualizarEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setId(empleadoDTO.getId());
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setCorreo(empleadoDTO.getCorreo());
        empleado.setPassword(empleadoDTO.getPassword());
        empleado.setEmpresa(empleadoDTO.getEmpresa());
        empleado.setRol(empleadoDTO.getRol());
        return this.empleadoRepo.save(empleado);
    }

    public boolean borrarEmpleado(Integer id){
        empleadoRepo.deleteById(id);
        if (empleadoRepo.findById(id)!=null){
            return true;
        }
        return false;
    }

    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return this.empleadoRepo.findByEmpresa(id);
    }
}
