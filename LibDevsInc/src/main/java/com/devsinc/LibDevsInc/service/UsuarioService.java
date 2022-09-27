package com.devsinc.LibDevsInc.service;

import com.devsinc.LibDevsInc.entity.Usuario;
import com.devsinc.LibDevsInc.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioService {
    private UsuarioRepository UsuarioRepository;

    public UsuarioService(com.devsinc.LibDevsInc.repository.UsuarioRepository usuarioRepository) {
        UsuarioRepository = usuarioRepository;
    }

    public com.devsinc.LibDevsInc.repository.UsuarioRepository getUsuarioRepository() {
        return UsuarioRepository;
    }

    public void setUsuarioRepository(com.devsinc.LibDevsInc.repository.UsuarioRepository usuarioRepository) {
        UsuarioRepository = usuarioRepository;
    }
    public Usuario buscarPorEmail(String email){
        return this.UsuarioRepository.findByEmail(email);
    }

    //función que guarda a un nuevo usuario
    public Usuario crearUsuario(Usuario nuevoUsuario){
        return this.UsuarioRepository.save(nuevoUsuario);
    }

    public Usuario getOrCreateUsuario(Map<String, Object> DatosUsuario){
        String email = (String) DatosUsuario.get("email");
        Usuario usuario = buscarPorEmail(email);
        //validamos si el usuario exite o no
        if (usuario == null){
            String alias = (String) DatosUsuario.get("nickname");
            String imagen = (String) DatosUsuario.get("picture");
            String auth0Id = (String) DatosUsuario.get("sub");

            //Usuario nuevoUsuario = new Usuario(email=email, imagen=imagen, auth0Id=auth0Id);
            Usuario nuevoUsuario = new Usuario(email=email, imagen=imagen, auth0Id=auth0Id);
            return crearUsuario(nuevoUsuario);
        }
        //System.out.println(usuario.getEmail());
        return usuario;
    }
}
