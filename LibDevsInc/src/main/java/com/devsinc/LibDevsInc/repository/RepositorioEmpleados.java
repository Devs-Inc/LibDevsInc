package com.devsinc.LibDevsInc.repository;

import com.devsinc.LibDevsInc.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleados extends JpaRepository<Empleado, Long>{
}