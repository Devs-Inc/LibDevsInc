package com.devsinc.LibDevsInc.DTO;

import com.devsinc.LibDevsInc.entity.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovimientoDineroDTO {
    private int id;
    private long monto;
    private String concepto;
    private Empleado usuario;
}
