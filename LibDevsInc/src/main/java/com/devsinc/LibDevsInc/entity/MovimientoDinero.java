package com.devsinc.LibDevsInc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="MovimientosDinero")

public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name="movimiento")
    private double movimiento;
    @Column(name="concepto")
    private String concepto;
    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(optional = false)
    @JoinColumn(name = "IdEmpleado", nullable = false)
    private Empleado usuarioRegistro;


    public MovimientoDinero() {
    }

    //Constructor
    /*public MovimientoDinero(double movimiento, String concepto, Empleado usuarioRegistro) {
        this.movimiento = movimiento;
        this.concepto = concepto;
        this.usuarioRegistro = usuarioRegistro;
    }*/

    //Getters & Setters
    public double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(double movimiento) {
        this.movimiento = movimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Empleado usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }


}
