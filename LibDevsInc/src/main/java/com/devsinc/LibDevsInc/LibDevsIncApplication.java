package com.devsinc.LibDevsInc;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibDevsIncApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LibDevsIncApplication.class, args);

		Empresa libreria = new Empresa("LibDev", "Calle falsa 123", "0000", "123");
		System.out.println(libreria.getNombre());
		libreria.setNombre("Panaderia");
		System.out.println(libreria.getNombre());

		MovimientoDinero salida = new MovimientoDinero(3000, "Apertura de cuenta", "John Doe");
		System.out.println(salida.getConcepto() + " " + salida.getMovimiento());
		salida.setMovimiento(salida.getMovimiento() - 2500);
		salida.setConcepto("Retiro");
		System.out.println(salida.getConcepto() + " " + salida.getMovimiento());
		salida.setMovimiento(-50.83);
		System.out.println(salida.getMovimiento());

	}

}
