package com.devsinc.LibDevsInc.repository;
import com.devsinc.LibDevsInc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long > {
    Usuario findByEmail(String email);
}
