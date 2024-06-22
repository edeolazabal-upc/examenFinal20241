package com.upc.examenfinal20241.repository;

import com.upc.examenfinal20241.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
