package com.devsinc.LibDevsInc.entity;

public class Empresa {

    private string nombre;
    private string direccion;
    private string telefono;
    private string NIT;

    public Empresa(string nombre, string direccion, string telefono, string NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public string getNombre() {
        return nombre;
    }

    public void setNombre(string nombre) {
        this.nombre = nombre;
    }

    public string getDireccion() {
        return direccion;
    }

    public void setDireccion(string direccion) {
        this.direccion = direccion;
    }

    public string getTelefono() {
        return telefono;
    }

    public void setTelefono(string telefono) {
        this.telefono = telefono;
    }

    public string getNIT() {
        return NIT;
    }

    public void setNIT(string NIT) {
        this.NIT = NIT;
    }

}
