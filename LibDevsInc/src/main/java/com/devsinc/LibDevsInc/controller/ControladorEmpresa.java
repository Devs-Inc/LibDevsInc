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
public class ControladorEmpresa {
    private final EmpresaServ empresaServ;
    private final EmpleadoServ empleadoServ;
    private final MovimientoDineroServ movimientoDineroServ;

    public ControladorEmpresa(EmpresaServ empresaServ, EmpleadoServ empleadoServ, MovimientoDineroServ movimientoDineroServ) {
        this.empresaServ = empresaServ;
        this.empleadoServ = empleadoServ;
        this.movimientoDineroServ = movimientoDineroServ;
    }

    //Consultar empresas
    @GetMapping("/enterprises")
    public String verEmpresas(Model model){
        List<Empresa> empresas = this.empresaServ.todasLasEmpresas();
        List<EmpresaDTO> empresasDTO = new ArrayList<>();
        empresas.forEach(empresa -> empresasDTO.add(new EmpresaDTO(empresa.getId(),
                empresa.getNombre(),empresa.getDireccion(),empresa.getTelefono(),empresa.getNit(),
                empresa.getEmpleados())));
        model.addAttribute("empresas", empresasDTO);
        return "verEmpresas";
    }

    //Agregar empresa
    @GetMapping("/adEnterprise")
    public String nuevaEmpresa(Model model){
        EmpresaDTO empresa = new EmpresaDTO();
        model.addAttribute("empresa", empresa);
        return "agregarEmpresa";
    }

    //Guardar empresa
    @PostMapping("/enterprises")
    public String guardarEmpresa(EmpresaDTO empresaDTO){
        this.empresaServ.saveEmpresa(empresaDTO);
        return "redirect:/enterprises";
    }

    //Editar empresa por ID
    @GetMapping("/enterprises/{id}")
    public String empresaPorID(@PathVariable("id") Integer id, Model model){
        Empresa empresa = this.empresaServ.empresaPorId(id).get();
        EmpresaDTO empresaDTO = new EmpresaDTO(empresa.getId(), empresa.getNombre(), empresa.getDireccion(),
                empresa.getTelefono(), empresa.getNit(), empresa.getEmpleados());
        model.addAttribute("empresa", empresaDTO);
        return "editarEmpresa";
    }

    @PostMapping("/updateEnterprise")
    public String actualizarEmpresa(EmpresaDTO empresaDTO){
        this.empresaServ.updateEmpresa(empresaDTO);
        return "redirect:/enterprises";
    }

    @GetMapping ("/deleteEnterprise/{id}")
    public String deleteEmpresa(@PathVariable("id") Integer id){
        this.empresaServ.borrarEmpresa(id);
        return "redirect:/enterprises";

    }

    @GetMapping("/enterprise/{id}/movements")
    public String movimientosPorEmpresa(@PathVariable Integer id, Model model){
        List<MovimientoDinero> movimientos= this.movimientoDineroServ.movimientosPorEmpresa(id);
        List<MovimientoDineroDTO> movimientoDineroDTOS = new ArrayList<>();
        movimientos.forEach(movimiento -> movimientoDineroDTOS.add(new MovimientoDineroDTO(movimiento.getId(), movimiento.getMonto(),
                movimiento.getConcepto(), movimiento.getUsuario())));
        Long total = this.movimientoDineroServ.sumarMovimientos();
        model.addAttribute("movimientos", movimientoDineroDTOS);
        model.addAttribute("total", total);
        return "verMovimientos";
    }

    @GetMapping("/enterprises/{id}/users")
    public String verEmpleadosPorEmpresa(@PathVariable Integer id, Model model){
        List<Empleado> empleados = this.empleadoServ.obtenerPorEmpresa(id);
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        empleados.forEach(empleado -> empleadoDTOS.add(new EmpleadoDTO(empleado.getId(),
                empleado.getNombre(), empleado.getCorreo(), empleado.getPassword(), empleado.getEmpresa(),
                empleado.getRol(), empleado.getMovimientos())));
        model.addAttribute("empleados", empleadoDTOS);
        return "verEmpleados";
    }
}
