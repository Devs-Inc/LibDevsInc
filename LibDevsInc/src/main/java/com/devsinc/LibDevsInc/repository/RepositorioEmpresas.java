package com.devsinc.LibDevsInc.repository;

import com.devsinc.LibDevsInc.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresas extends JpaRepository<Empresa, Long> {
}
