package com.devsinc.LibDevsInc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="empresa")
public class Empresa {
    //atributos
    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;*/
    private long NIT;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono")
    private String telefono;

    /*@OneToMany(mappedBy = "empresaEmpleado")
    @JsonIgnoreProperties(value = "empresaEmpleado") // para no ver ese ciclo infinito en Json
    private Set<Empleado> empleado;*/


    //Constructor vacio para convertir en Tabla
    public Empresa(){

    }
/*
    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getNIT() {
        return NIT;
    }

    public void setNIT(long NIT) {
        this.NIT = NIT;
    }

    /*public Set<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Set<Empleado> empleado) {
        this.empleado = empleado;
    }*/
}
