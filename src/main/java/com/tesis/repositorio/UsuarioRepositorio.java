package com.tesis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesis.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	 

	public Usuario findUsuarioByRut(String rut);

	
}
