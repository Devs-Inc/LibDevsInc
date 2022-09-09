package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.repository.RepositorioEmpleados;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiciosEmpleado {
    //repTra es un atributo de empleado para diferenciarlo de empresa.
    private RepositorioEmpleados repTra;

    public ServiciosEmpleado(RepositorioEmpleados repTra) {
        this.repTra = repTra;
    }

    //metodo GET para listar empleados
    public List<Empleado> getListaEmpleados(){
        return this.repTra.findAll();
    }

    //metodo GET para consulta un empleado.
    public Empleado getListaEmpleado(Long id){
        return this.repTra.findById(id).orElseThrow();
    }

    // metodo POST para crear empleado.
    public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.repTra.save(nuevoEmpleado);
    }

    //Metodo PATCH para actualizar empleado.
    public Empleado patchTra(Long id, Empleado t){
        Empleado empleadoActual = repTra.findById(id).orElseThrow();
        empleadoActual.setNombreEmpleado(t.getNombreEmpleado());
        empleadoActual.setCorreoEmpleado(t.getCorreoEmpleado());
        empleadoActual.setEmpresaEmpleado(t.getEmpresaEmpleado());
        empleadoActual.setRol(t.getRol());
        return this.repTra.save(empleadoActual);
    }

    //Metodo Delete para eliminar empleado.
    public Empleado deleteTra(Long id) {
        this.repTra.deleteById(id);
       // return  String "Registro Eliminado";
        return null;
    }
}
