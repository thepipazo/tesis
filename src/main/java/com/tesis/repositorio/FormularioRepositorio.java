package com.tesis.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.entidad.Formulario;
import com.tesis.entidad.Unidad;
import com.tesis.security.entity.Usuario;

public interface FormularioRepositorio extends JpaRepository<Formulario, Long> {
	Formulario findByCodigo(String codigo);
	
	//List<Formulario> findByUsuario(Integer usuario);
	
	List<Formulario> findByUsuario(Usuario id);
	List<Formulario> findByUsuarioOrderByEstadoAsc(Usuario usuario);
	List<Formulario> findByUnidadOrderByEstadoResponsableAsc(Unidad unidad);
	List<Formulario> findByEstadoResponsableOrderByEstadoDacAsc(String estadoResponsable);
	List<Formulario> findByEstadoDac(String estadoDac);
	

	

	
	

}
