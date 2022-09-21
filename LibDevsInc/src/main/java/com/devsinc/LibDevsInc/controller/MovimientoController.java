package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.DTO.EmpleadoDTO;
import com.devsinc.LibDevsInc.DTO.MovimientoDineroDTO;
import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import com.devsinc.LibDevsInc.service.EmpleadoService;
import com.devsinc.LibDevsInc.service.MovimientoDineroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovimientoController {

    private final MovimientoDineroService movimientoDineroService;
    private final EmpleadoService empleadoService;

    public MovimientoController(MovimientoDineroService movimientoDineroService, EmpleadoService empleadoService) {
        this.movimientoDineroService = movimientoDineroService;
        this.empleadoService = empleadoService;
    }

    //Consultar movimientos
    @GetMapping("/movements")
    public String verMovimientos(Model model){
        List<MovimientoDinero> movimientos= this.movimientoDineroService.getAllMovimientos();
        List<MovimientoDineroDTO> movimientoDineroDTOS = new ArrayList<>();
        movimientos.forEach(movimiento -> movimientoDineroDTOS.add(new MovimientoDineroDTO(movimiento.getId(), movimiento.getMonto(),
                movimiento.getConcepto(), movimiento.getUsuario())));
        Long total = this.movimientoDineroService.sumarMovimientos();
        model.addAttribute("movimientos", movimientoDineroDTOS);
        model.addAttribute("total", total);
        return "verMovimientos";
    }

    //Agregar Movimiento
    @GetMapping("/adMovement")
    public String agregarMovimiento(Model model){
        MovimientoDineroDTO movimientoDineroDTO = new MovimientoDineroDTO();
        List<Empleado> empleados = this.empleadoService.todosLosEmpleados();
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        empleados.forEach(empleado -> empleadoDTOS.add(new EmpleadoDTO(empleado.getId(),
                empleado.getNombre(), empleado.getCorreo(), empleado.getPassword(), empleado.getEmpresa(),
                empleado.getRol(), empleado.getMovimientos())));
        model.addAttribute("movimiento", movimientoDineroDTO);
        model.addAttribute("usuarios", empleadoDTOS);
        return "agregarMovimiento";
    }

    //Guardar Movimiento
    @PostMapping("/movements")
    public String agregarMovimiento(MovimientoDineroDTO movimientoDineroDTO){
        this.movimientoDineroService.saveMovimiento(movimientoDineroDTO);
        return "redirect:/movements";
    }

    //Editar movimiento
    @GetMapping("/movement/{id}")
    public String movimientoPorId(@PathVariable Integer id, Model model){
        MovimientoDinero movimientoDinero = this.movimientoDineroService.getMovimientoById(id).get();
        MovimientoDineroDTO movimientoDineroDTO = new MovimientoDineroDTO(movimientoDinero.getId(),
                movimientoDinero.getMonto(), movimientoDinero.getConcepto(), movimientoDinero.getUsuario());
        List<Empleado> usuarios = this.empleadoService.todosLosEmpleados();
        List<EmpleadoDTO> usuariosDTO = new ArrayList<>();
        usuarios.forEach(usuario -> usuariosDTO.add(new EmpleadoDTO(usuario.getId(), usuario.getNombre(),
                usuario.getCorreo(), usuario.getPassword(), usuario.getEmpresa(), usuario.getRol(),
                usuario.getMovimientos())));
        model.addAttribute("movimiento", movimientoDineroDTO);
        model.addAttribute("usuarios", usuariosDTO);
        return "editarMovimiento";
    }

    //Actualizar movimiento
    @PostMapping("/updateMovement")
    public String actualizarMovimiento(MovimientoDineroDTO movimientoDineroDTO){
        this.movimientoDineroService.updateMovimiento(movimientoDineroDTO);
        return "redirect:/movements";
    }

    //Eliminar movimiento
    @GetMapping("/deleteMovement/{id}")
    public String eliminarMovimiento(@PathVariable Integer id){
        this.movimientoDineroService.deleteMovimiento(id);
        return "redirect:/movements";
    }
}
