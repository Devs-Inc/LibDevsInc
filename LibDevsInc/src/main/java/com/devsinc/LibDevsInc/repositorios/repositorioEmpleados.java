package com.devsinc.LibDevsInc.repositorios;

import com.devsinc.LibDevsInc.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioEmpleados extends JpaRepository<Empleado, Long>{
}
