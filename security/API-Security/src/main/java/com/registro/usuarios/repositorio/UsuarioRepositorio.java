package com.registro.usuarios.repositorio;

import com.registro.usuarios.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);

	public List<Usuario> findAll();
}
