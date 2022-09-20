package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosEmpresa {
    @Autowired
    private RepositorioEmpresas repositorioEmpresas;

    //Servicio Crear Empresa
    public Empresa createEmpresa(Empresa empresa) {
        return repositorioEmpresas.save(empresa);
    }

    //Servicio Obtener Todas las Empresas
    public List<Empresa> allEmpresas() {
        return repositorioEmpresas.findAll();
    }

    //Servicio Obtener una Empresa por su ID
    public Empresa findEmpresaById(Long id) {
        return repositorioEmpresas.findById(id).get();
    }

    //Servicio Actualizar Empresa
    public Empresa updateEmpresa(Long id, Empresa empresa) {
        Empresa empresaActual = repositorioEmpresas.findById(id).get();
        empresaActual.setNombre(empresa.getNombre());
        empresaActual.setDireccion(empresa.getDireccion());
        empresaActual.setTelefono(empresa.getTelefono());
        return repositorioEmpresas.save(empresaActual);
    }

    //Servicio Eliminar Empresa
    public String deleteEmpresa(Long id) {
        repositorioEmpresas.deleteById(id);
        return "la empresa con ID " + id + " fue eliminada exitosamente";
    }
}
