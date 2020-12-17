package com.tesis.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesis.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	boolean existsByNombreUsuario(String nombreUsuario);
	Usuario findByRut(String rut);
	boolean existsByRut(String rut);
	

	

	
	

}
