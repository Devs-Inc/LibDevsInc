package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.repository.RepositorioEmpresas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosEmpresa {

    //repEmp es un atributo de Empresa para diferenciarlo de Empleado.
    private RepositorioEmpresas repEmp;

    public ServiciosEmpresa(RepositorioEmpresas repEmp) {
        this.repEmp = repEmp;
    }

    //metodo GET para listar empresas
    public List<Empresa> getListaEmpresas(){
        return this.repEmp.findAll();
    }

    //metodo GET para consultar una empresa.
    public Empresa getListaEmpresa(Long id){
        return this.repEmp.findById(id).orElseThrow();
    }

    // metodo POST para crear empresa.
    public Empresa crearEmpresa(Empresa nuevoEmpresa){
        return this.repEmp.save(nuevoEmpresa);
    }

    //Metodo PATCH para actualizar empresa.
    public Empresa patchEmp(Long id, Empresa e){
        Empresa empresaActual = repEmp.findById(id).orElseThrow();
        empresaActual.setNombre(e.getNombre());
        empresaActual.setDireccion(e.getDireccion());
        empresaActual.setTelefono(e.getTelefono());
        empresaActual.setNIT(e.getNIT());
        return this.repEmp.save(empresaActual);
    }

    //Metodo Delete para eliminar empresa.
    public Empresa deleteEmp(Long id) {
        this.repEmp.deleteById(id);
        // return  String "Registro Eliminado";
        return null;
    }

}