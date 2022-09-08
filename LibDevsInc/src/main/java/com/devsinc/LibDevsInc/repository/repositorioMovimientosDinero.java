package com.devsinc.LibDevsInc.repository;

import com.devsinc.LibDevsInc.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioMovimientosDinero extends JpaRepository<MovimientoDinero, Long>{
    MovimientoDinero findByMovimientoId(Long movimientoId);
}
