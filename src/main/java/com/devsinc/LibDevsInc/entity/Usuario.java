package com.devsinc.LibDevsInc.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToOne
    //@JoinColumn(name = "idEmpleado")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;
/*
    @Column(name = "rol")
    private String rol;
*/
    @Column(name = "imagen")
    private String imagen;

    @Column(name = "auth0Id", unique = true)
    private String auth0Id;

    public Usuario(String email, String imagen, String auth0Id) {
        this.email = email;
        this.imagen = imagen;
        this.auth0Id = auth0Id;
    }

    /*@OneToOne
    private Empleado idEmpleado;*/

    /*public Usuario() {
    }

    public Usuario(Long id, String email, String imagen, String auth0Id) {
        this.id = id;
        this.email = email;
        this.imagen = imagen;
        this.auth0Id = auth0Id;
    }
    
     */
}
