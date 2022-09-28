package com.devsinc.LibDevsInc.controller;

import com.devsinc.LibDevsInc.entity.Usuario;
import com.devsinc.LibDevsInc.service.EmpleadoService;
import com.devsinc.LibDevsInc.service.EmpresaService;
import com.devsinc.LibDevsInc.service.MovimientoDineroService;
import com.devsinc.LibDevsInc.service.UsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontController {
    private EmpresaService empresaService;
    private EmpleadoService empleadoService;
    private MovimientoDineroService movimientoDineroService;
    private UsuarioService usuarioService;

    public FrontController(EmpresaService empresaService, EmpleadoService empleadoService, MovimientoDineroService movimientoDineroService, UsuarioService usuarioService) {
        this.empresaService = empresaService;
        this.empleadoService = empleadoService;
        this.movimientoDineroService = movimientoDineroService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/") //ruta raíz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            //System.out.println(principal.getClaims());
            Usuario usuario = this.usuarioService.getOrCreateUsuario(principal.getClaims());
            model.addAttribute("usuario", usuario);
        }
        return "index";
    }
}
