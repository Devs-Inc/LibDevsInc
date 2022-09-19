package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.service.ServiciosEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlEmpresa {

    @Autowired
    ServiciosEmpresa serviciosEmp;

    //Consultar todas las empresas disponibles
    @GetMapping("/enterprises")
    public List<Empresa> allEmpresas(){
        return serviciosEmp.allEmpresas();
    }

    //Consultar una empresa  de las disponibles
    @GetMapping("/enterprises/{id}")
    public Empresa consultarEmpresa(@PathVariable(value = "id") Long id){
        return serviciosEmp.findEmpresaById(id);
    }

    // Crear una empresa
    @PostMapping("/enterprises")
    public Empresa crearEmpresa(@RequestBody Empresa e){
        return serviciosEmp.createEmpresa(e);
    }

    //editar una empresa
    @PatchMapping("/enterprises/{id}")
    public Empresa patchEmpresa(@PathVariable Long id, @RequestBody Empresa e){
        return serviciosEmp.updateEmpresa(id,e);
    }

    //borrar una empresa
    @DeleteMapping("/enterprises/{id}")
    public String deleteEmpresa(@PathVariable(value = "id") Long id){
        return serviciosEmp.deleteEmpresa(id);
    }


}
