package com.devsinc.LibDevsInc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="empresas")
public class Empresa {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_empresa", nullable = false)
    private Long idEmpresa;

    @Column(name="nit", nullable = false, unique = true)
    private long NIT;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name="telefono", nullable = false)
    private String telefono;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
