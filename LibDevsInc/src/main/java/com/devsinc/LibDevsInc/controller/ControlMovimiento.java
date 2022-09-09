package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import com.devsinc.LibDevsInc.service.ServiciosMovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlMovimiento {
    ServiciosMovimientoDinero serviciosMovimientoDinero;

    public ControlMovimiento(ServiciosMovimientoDinero serviciosMovimientoDinero){
        this.serviciosMovimientoDinero = serviciosMovimientoDinero;
    }

    @GetMapping("/movimientos/{id}")
    public MovimientoDinero consultarMovimiento(@PathVariable(value = "id") Long id){
        return this.serviciosMovimientoDinero.getMovimiento(id);
    }

    @GetMapping("/movimientos")
    public List<MovimientoDinero> allMovimientos(){
        return this.serviciosMovimientoDinero.getListaMovimientos();
    }

    @PostMapping("/movimientos")
    public MovimientoDinero crearMovimiento(@RequestBody MovimientoDinero md){
        return this.serviciosMovimientoDinero.crearMovimiento(md);
    }

    @DeleteMapping("/movimientos/{id}")
    public MovimientoDinero deleteMovimiento(@PathVariable(value = "id") Long id){
        return this.serviciosMovimientoDinero.deleteMov(id);
    }

    @PatchMapping("/movimientos/{id}")
    public MovimientoDinero patchMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero md){
        return this.serviciosMovimientoDinero.patchMov(id, md);
    }
}
