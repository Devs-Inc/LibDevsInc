package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.servicios.ServiciosEmpleado;
import com.devsinc.LibDevsInc.servicios.ServiciosEmpresa;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ControlEmpleado {

    ServiciosEmpleado serviciosTra;

    //constructor
    public ControlEmpleado(ServiciosEmpleado serviciosTra){
        this.serviciosTra = serviciosTra;
    }

    // Consultar todas las Empleados disponibles

    @GetMapping("/users")
    public List<Empleado> allEmpleados(){
        return this.serviciosTra.getListaEmpleados();
    }

    //Consultar un empleado  de las disponibles
    @GetMapping("/user/{id}")
    public Empleado consultarEmpleado(@PathVariable(value = "id") Long id){
        return this.serviciosTra.getListaEmpleado(id);
    }

    // Crear un empleado
    @PostMapping("/users")
    public Empleado crearEmpleado(@RequestBody Empleado t){
        return this.serviciosTra.crearEmpleado(t);
    }

    //editar un empleado
    @PatchMapping("/user/{id}")
    public Empleado patchEmpleado(@PathVariable Long id, @RequestBody Empleado t){
        return this.serviciosTra.patchTra(id,t);
    }

    //borrar un empleado
    @DeleteMapping("/user/{id}")
    public Empleado deleteEmpleado(@PathVariable(value = "id") Long id){
        return this.serviciosTra.deleteTra(id);
    }




}
