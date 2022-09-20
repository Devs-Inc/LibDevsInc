package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosMovimientoDinero {
    private RepositorioMovimientosDinero mov;

    public ServiciosMovimientoDinero(RepositorioMovimientosDinero mov) {
        this.mov = mov;
    }

    public List<MovimientoDinero> getListaMovimientos(){
        return this.mov.findAll();
    }

    public MovimientoDinero getMovimiento(Long id){
        return this.mov.findById(id).orElseThrow();
    }

    public MovimientoDinero crearMovimiento(MovimientoDinero nuevoMov){
        return this.mov.save(nuevoMov);
    }

    public MovimientoDinero patchMov(Long id, MovimientoDinero md){
        MovimientoDinero movimiento = mov.findById(id).orElseThrow();
        movimiento.setMovimiento(md.getMovimiento());
        movimiento.setConcepto(md.getConcepto());
        return this.mov.save(movimiento);
    }

    public MovimientoDinero deleteMov(Long id) {
        this.mov.deleteById(id);
        return null;
    }

}
