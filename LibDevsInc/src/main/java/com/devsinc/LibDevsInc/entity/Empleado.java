package com.devsinc.LibDevsInc.entity;

public class Empleado {

    private Strindg nombreEmpleado;
    private String correoEmpleado;
    private Empresa empresaEmpleado;
    private String rol;

    public Empleado(Strindg nombreEmpleado, String correoEmpleado, Empresa empresaEmpleado, String rol) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.rol = rol;
    }

    public Strindg getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(Strindg nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
