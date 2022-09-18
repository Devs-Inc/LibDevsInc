package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.repository.RepositorioEmpresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosEmpresa {
    @Autowired
    private RepositorioEmpresas repositorioEmpresas;

    public Empresa createEmpresa(Empresa empresa) {
        return repositorioEmpresas.save(empresa);
    }

    public List<Empresa> allEmpresas() {
        return repositorioEmpresas.findAll();
    }

    public Empresa findEmpresaById(Long id) {
        return repositorioEmpresas.findById(id).get();
    }

    public Empresa updateEmpresa(Empresa empresa) {
        return repositorioEmpresas.save(empresa);
    }

    public String deleteEmpresa(Long id) {
        repositorioEmpresas.deleteById(id);
        return "la empresa con ID " + id + " fue eliminada exitosamente";
    }
}
