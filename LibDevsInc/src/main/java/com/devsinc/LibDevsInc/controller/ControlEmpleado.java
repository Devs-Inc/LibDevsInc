package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.service.ServiciosEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ControlEmpleado {

    @Autowired
    ServiciosEmpleado serviciosEmpleado;

    @GetMapping("/users")
    public String listaUsers(Model model) {
        model.addAttribute("user", serviciosEmpleado.allEmpleados());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUser(Empleado empleado) {
        return "add-user";
    }

    @PostMapping("/users")
    public String createUser(Empleado empleado) {
        serviciosEmpleado.createEmpleado(empleado);
        return "redirect:/users";
    }

    @GetMapping("/users/borrar/{id}")
    public String eliminarUser(@PathVariable("id") Long id) {
        serviciosEmpleado.deleteEmpleado(id);
        return "redirect/users";
    }

    @GetMapping("/users/editar/{id}")
    public String findUserById(@PathVariable("id") Long id, Model model) {
        Empleado empleado = serviciosEmpleado.findEmpleadoById(id);
        model.addAttribute("user", empleado);
        return "actualizar-user";
    }

    @PostMapping("/users/actualizar/{id}")
    public String actualizarUser(@PathVariable("id") Long id, Empleado empleado) {
        serviciosEmpleado.updateEmpleado(id, empleado);
        return "redirect:/users";
    }

//    ServiciosEmpleado serviciosTra;
//
//    //constructor
//    public ControlEmpleado(ServiciosEmpleado serviciosTra){
//        this.serviciosTra = serviciosTra;
//    }
//
//    // Consultar todas las Empleados disponibles
//
//    @GetMapping("/users")
//    public List<Empleado> allEmpleados(){
//        return this.serviciosTra.getListaEmpleados();
//    }
//
//    //Consultar un empleado  de las disponibles
//    @GetMapping("/user/{id}")
//    public Empleado consultarEmpleado(@PathVariable(value = "id") Long id){
//        return this.serviciosTra.getListaEmpleado(id);
//    }
//
//    // Crear un empleado
//    @PostMapping("/users")
//    public Empleado crearEmpleado(@RequestBody Empleado t){
//        return this.serviciosTra.crearEmpleado(t);
//    }
//
//    //editar un empleado
//    @PatchMapping("/user/{id}")
//    public Empleado patchEmpleado(@PathVariable Long id, @RequestBody Empleado t){
//        return this.serviciosTra.patchTra(id,t);
//    }
//
//    //borrar un empleado
//    @DeleteMapping("/user/{id}")
//    public Empleado deleteEmpleado(@PathVariable(value = "id") Long id){
//        return this.serviciosTra.deleteTra(id);
//    }




}
