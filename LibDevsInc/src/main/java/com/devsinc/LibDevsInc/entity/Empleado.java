package com.devsinc.LibDevsInc.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_empleado", nullable = false)
    private Long idEmpleado;

    @Column(name="nombre_empleado", nullable = false)
    private String nombreEmpleado;

    @Column(name="correo_empleado", nullable = false)
    private String correoEmpleado;

    @ManyToOne
    private Empresa empresa;

    @Column(name="rol", nullable = false)
    private String rol;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
