package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.DTO.EmpresaDTO;
import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> todasLasEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        this.empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

    public Optional<Empresa> empresaPorId(Integer id){
        return this.empresaRepository.findById(id);
    }

    public Empresa saveEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa.setNombre(empresaDTO.getNombre());
        empresa.setDireccion(empresaDTO.getDireccion());
        empresa.setTelefono(empresaDTO.getTelefono());
        empresa.setNit(empresaDTO.getNit());
        return this.empresaRepository.save(empresa);
    }

    public Empresa updateEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa.setId(empresaDTO.getId());
        empresa.setNombre(empresaDTO.getNombre());
        empresa.setDireccion(empresaDTO.getDireccion());
        empresa.setTelefono(empresaDTO.getTelefono());
        empresa.setNit(empresaDTO.getNit());
        return this.empresaRepository.save(empresa);
    }

    public boolean borrarEmpresa(Integer id){
        this.empresaRepository.deleteById(id);
        if (this.empresaRepository.findById(id)!=null){
            return true;
        }
        return false;
    }
}
