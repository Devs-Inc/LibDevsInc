package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.DTO.EmpleadoDTO;
import com.devsinc.LibDevsInc.DTO.EmpresaDTO;
import com.devsinc.LibDevsInc.DTO.MovimientoDineroDTO;
import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import com.devsinc.LibDevsInc.service.EmpleadoServ;
import com.devsinc.LibDevsInc.service.EmpresaServ;
import com.devsinc.LibDevsInc.service.MovimientoDineroServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorUsuario {

    private final EmpleadoServ empleadoServ;
    private final EmpresaServ empresaServ;
    private final MovimientoDineroServ movimientoDineroServ;

    public ControladorUsuario(EmpleadoServ empleadoServ, EmpresaServ empresaServ, MovimientoDineroServ movimientoDineroServ) {
        this.empleadoServ = empleadoServ;
        this.empresaServ = empresaServ;
        this.movimientoDineroServ = movimientoDineroServ;
    }

    //consultar lista de empleados
    @GetMapping("/users")
    public String verEmpleados(Model model){
        List<Empleado> empleados = this.empleadoServ.todosLosEmpleados();
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        empleados.forEach(empleado -> empleadoDTOS.add(new EmpleadoDTO(empleado.getId(),
                empleado.getNombre(), empleado.getCorreo(), empleado.getPassword(), empleado.getEmpresa(),
                empleado.getRol(), empleado.getMovimientos())));
        model.addAttribute("empleados", empleadoDTOS);
        return "verEmpleados";
    }

    //Agregar Empleado
    @GetMapping("/adUser")
    public String nuevaEmpleado(Model model){
        EmpleadoDTO empleado = new EmpleadoDTO();
        List<Empresa> empresas = this.empresaServ.todasLasEmpresas();
        List<EmpresaDTO> empresasDTO = new ArrayList<>();
        empresas.forEach(empresa -> empresasDTO.add(new EmpresaDTO(empresa.getId(),
                empresa.getNombre(),empresa.getDireccion(),empresa.getTelefono(),empresa.getNit(),
                empresa.getEmpleados())));
        model.addAttribute("empresas", empresasDTO);
        model.addAttribute("empleado", empleado);
        return "agregarEmpleado";
    }

    //Guardar empleado
    @PostMapping("/users")
    public String agregarEmpleado(EmpleadoDTO empleadoDTO){
        this.empleadoServ.saveEmpleado(empleadoDTO);
        return "redirect:/users";
    }

    //Editar empleado
    @GetMapping("/user/{id}")
    public String empleadoPorId(@PathVariable Integer id, Model model){
        Empleado empleado = this.empleadoServ.empleadoPorId(id).get();
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado.getId(), empleado.getNombre(), empleado.getCorreo(), empleado.getPassword(),
                empleado.getEmpresa(),empleado.getRol(),empleado.getMovimientos());
        List<Empresa> empresas = this.empresaServ.todasLasEmpresas();
        List<EmpresaDTO> empresasDTO = new ArrayList<>();
        empresas.forEach(empresa -> empresasDTO.add(new EmpresaDTO(empresa.getId(),
                empresa.getNombre(),empresa.getDireccion(),empresa.getTelefono(),empresa.getNit(),
                empresa.getEmpleados())));
        model.addAttribute("empresas", empresasDTO);
        model.addAttribute("empleado", empleadoDTO);
        return "editarEmpleado";
    }

    //Actualizar empleado
    @PostMapping("/updateUser")
    public String actualizarEmpleado(EmpleadoDTO empleadoDTO){
        this.empleadoServ.actualizarEmpleado(empleadoDTO);
        return "redirect:/users";
    }

    //Eliminar empleado
    @GetMapping("/deleteUser/{id}")
    public String eliminarEmpleado(@PathVariable Integer id){
        this.empleadoServ.borrarEmpleado(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}/movements")
    public String movimientosPorEmpleado(@PathVariable Integer id, Model model){
        List<MovimientoDinero> movimientos= this.movimientoDineroServ.movimientosPorEmpleado(id);
        List<MovimientoDineroDTO> movimientoDineroDTOS = new ArrayList<>();
        movimientos.forEach(movimiento -> movimientoDineroDTOS.add(new MovimientoDineroDTO(movimiento.getId(), movimiento.getMonto(),
                movimiento.getConcepto(), movimiento.getUsuario())));
        Long total = this.movimientoDineroServ.sumarMovimientos();
        model.addAttribute("movimientos", movimientoDineroDTOS);
        model.addAttribute("total", total);
        return "verMovimientos";
    }
}
