package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiciosEmpleado {
    @Autowired
    RepositorioEmpleados repositorioEmpleados;

    //Servicio Crear Empleado
    public Empleado createEmpleado(Empleado empleado) {
        return repositorioEmpleados.save(empleado);
    }

    //Servicio Obtener Todos los Empleados
    public List<Empleado> allEmpleados() {
        return repositorioEmpleados.findAll();
    }

    //Servicio Obtener un Empleado por su ID
    public Empleado findEmpleadoById(Long id) {
        return repositorioEmpleados.findById(id).get();
    }

    //Servicio Actualizar Empleado
    public Empleado updateEmpleado(Long id, Empleado empleado) {
        Empleado empleadoActual = repositorioEmpleados.findById(id).get();
        empleadoActual.setNombreEmpleado(empleado.getNombreEmpleado());
        empleadoActual.setCorreoEmpleado(empleado.getCorreoEmpleado());
        empleadoActual.setEmpresa(empleado.getEmpresa());
        empleadoActual.setRol(empleado.getRol());
        return repositorioEmpleados.save(empleadoActual);
    }

    //Servicio Eliminar Empleado
    public String deleteEmpleado(Long id) {
        repositorioEmpleados.deleteById(id);
        return "El empleado con ID " + id + " fue eliminado exitosamente";
    }

}
