package com.devsinc.LibDevsInc.servicios;

import com.devsinc.LibDevsInc.entity.Empresa;

public class ServiciosEmpresa {

    Empresa ep1;


    public ServiciosEmpresa(){
        this.ep1 = new Empresa("Libreria Devinc" , "Calle falsa 123" , "018000203040" , "830629402-0");
    }

    public Empresa getEmpresas() {
        return this.ep1;
    }
}
