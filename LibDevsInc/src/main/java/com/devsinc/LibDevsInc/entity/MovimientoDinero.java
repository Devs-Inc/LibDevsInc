package com.devsinc.LibDevsInc.entity;

public class MovimientoDinero {
    private double movimiento;
    private String concepto;
    private String usuarioRegistro;

    //Constructor
    public MovimientoDinero(double movimiento, String concepto, String usuarioRegistro) {
        this.movimiento = movimiento;
        this.concepto = concepto;
        this.usuarioRegistro = usuarioRegistro;
    }

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

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
}
