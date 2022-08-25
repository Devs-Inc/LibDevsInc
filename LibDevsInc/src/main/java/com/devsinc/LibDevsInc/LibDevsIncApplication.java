package com.devsinc.LibDevsInc;

import com.devsinc.LibDevsInc.entity.Empresa;
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
	}

}
