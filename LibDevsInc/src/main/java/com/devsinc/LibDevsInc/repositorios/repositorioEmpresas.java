package com.devsinc.LibDevsInc.repositorios;

import com.devsinc.LibDevsInc.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioEmpresas extends JpaRepository<Empresa, Long> {
}
