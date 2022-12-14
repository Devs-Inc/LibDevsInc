package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.DTO.EmpleadoDTO;
import com.devsinc.LibDevsInc.DTO.EmpresaDTO;
import com.devsinc.LibDevsInc.DTO.MovimientoDineroDTO;
import com.devsinc.LibDevsInc.entity.Empleado;
import com.devsinc.LibDevsInc.entity.Empresa;
import com.devsinc.LibDevsInc.entity.MovimientoDinero;
import com.devsinc.LibDevsInc.service.EmpleadoService;
import com.devsinc.LibDevsInc.service.EmpresaService;
import com.devsinc.LibDevsInc.service.MovimientoDineroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpresaController {
    private final EmpresaService empresaService;
    private final EmpleadoService empleadoService;
    private final MovimientoDineroService movimientoDineroService;

    public EmpresaController(EmpresaService empresaService, EmpleadoService empleadoService, MovimientoDineroService movimientoDineroService) {
        this.empresaService = empresaService;
        this.empleadoService = empleadoService;
        this.movimientoDineroService = movimientoDineroService;
    }

    //Consultar empresas
    @GetMapping("/enterprises")
    public String verEmpresas(Model model){
        List<Empresa> empresas = this.empresaService.todasLasEmpresas();
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
        this.empresaService.saveEmpresa(empresaDTO);
        return "redirect:/enterprises";
    }

    //Editar empresa por ID
    @GetMapping("/enterprises/{id}")
    public String empresaPorID(@PathVariable("id") Integer id, Model model){
        Empresa empresa = this.empresaService.empresaPorId(id).get();
        EmpresaDTO empresaDTO = new EmpresaDTO(empresa.getId(), empresa.getNombre(), empresa.getDireccion(),
                empresa.getTelefono(), empresa.getNit(), empresa.getEmpleados());
        model.addAttribute("empresa", empresaDTO);
        return "editarEmpresa";
    }

    @PostMapping("/updateEnterprise")
    public String actualizarEmpresa(EmpresaDTO empresaDTO){
        this.empresaService.updateEmpresa(empresaDTO);
        return "redirect:/enterprises";
    }

    @GetMapping ("/deleteEnterprise/{id}")
    public String deleteEmpresa(@PathVariable("id") Integer id){
        this.empresaService.borrarEmpresa(id);
        return "redirect:/enterprises";

    }

    @GetMapping("/enterprise/{id}/movements")
    public String movimientosPorEmpresa(@PathVariable Integer id, Model model){
        List<MovimientoDinero> movimientos= this.movimientoDineroService.movimientosPorEmpresa(id);
        List<MovimientoDineroDTO> movimientoDineroDTOS = new ArrayList<>();
        movimientos.forEach(movimiento -> movimientoDineroDTOS.add(new MovimientoDineroDTO(movimiento.getId(), movimiento.getMonto(),
                movimiento.getConcepto(), movimiento.getUsuario())));
        Long total = this.movimientoDineroService.sumarMovimientos();
        model.addAttribute("movimientos", movimientoDineroDTOS);
        model.addAttribute("total", total);
        return "verMovimientos";
    }

    @GetMapping("/enterprises/{id}/users")
    public String verEmpleadosPorEmpresa(@PathVariable Integer id, Model model){
        List<Empleado> empleados = this.empleadoService.obtenerPorEmpresa(id);
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        empleados.forEach(empleado -> empleadoDTOS.add(new EmpleadoDTO(empleado.getId(),
                empleado.getNombre(), empleado.getCorreo(), empleado.getPassword(), empleado.getEmpresa(),
                empleado.getRol(), empleado.getMovimientos())));
        model.addAttribute("empleados", empleadoDTOS);
        return "verEmpleados";
    }
}
