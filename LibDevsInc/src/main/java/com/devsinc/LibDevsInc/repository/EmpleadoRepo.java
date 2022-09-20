package com.devsinc.LibDevsInc.repository;

import com.devsinc.LibDevsInc.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Integer> {
    @Query(value = "select * from empleado where empresa_id=?1", nativeQuery = true)
    ArrayList<Empleado> findByEmpresa(Integer id);
}
