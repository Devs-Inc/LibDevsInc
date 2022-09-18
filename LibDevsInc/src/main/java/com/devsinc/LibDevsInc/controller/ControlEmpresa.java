package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.service.ServiciosEmpresa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlEmpresa{

    ServiciosEmpresa serviciosEmp;

    //constructor
    public ControlEmpresa(ServiciosEmpresa serviciosEmp){
        this.serviciosEmp = serviciosEmp;
    }

    // Consultar todas las empresas disponibles

    @GetMapping("/enterprises")
    public List<Empresa> allEmpresas(){
        return this.serviciosEmp.allEmpresas();
    }

    //Consultar una empresa  de las disponibles
    @GetMapping("/enterprises/{id}")
    public Empresa consultarEmpresa(@PathVariable(value = "id") Long id){
        return this.serviciosEmp.findEmpresaById(id);
    }

    // Crear una empresa
    @PostMapping("/enterprises")
    public Empresa crearEmpresa(@RequestBody Empresa e){
        return this.serviciosEmp.createEmpresa(e);
    }

    //editar una registro
//    @PatchMapping("/enterprises/{id}")
//    public Empresa patchEmpresa(@PathVariable Long id, @RequestBody Empresa e){
//        return this.serviciosEmp.updateEmpresa(id,e);
//    }

    //borrar una registro
    @DeleteMapping("/enterprises/{id}")
    public String deleteEmpresa(@PathVariable(value = "id") Long id){
        return this.serviciosEmp.deleteEmpresa(id);
    }


}
