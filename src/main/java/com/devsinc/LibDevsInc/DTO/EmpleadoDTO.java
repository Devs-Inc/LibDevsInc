package com.devsinc.LibDevsInc.DTO;

import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDTO {
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private Empresa empresa;
    private String rol;
    private List<MovimientoDinero> movimientos;
}
