package com.devsinc.LibDevsInc.servicios;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.entity.Empleado;

public class ServiciosEmpleado {

    //t = trabajador, hace alusion a Empleado
    Empleado t1;
    //Empleado t2;

    ServiciosEmpresa se1 = new ServiciosEmpresa();

    public ServiciosEmpleado (){
        Empresa empresaEmpleado = this.se1.ep1;
        this.t1 = new Empleado("Felipe", "empelado1@empresa1,com", empresaEmpleado,"Admin");
        //this.t2 = new Empleado("Marco", "empleado2@empresa1.com", empresaEmpleado, "Operador");

    }



}
