package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.Formulario;
import com.tesis.entidad.Unidad;
import com.tesis.repositorio.FormularioRepositorio;
import com.tesis.security.entity.Usuario;
import com.tesis.services.FormularioServicio;

@Service
public class FormularioImplement implements FormularioServicio {
	
	@Autowired
	private FormularioRepositorio formulariorepositorio;

	@Override
	public Formulario GuardarFormulario(Formulario formulario) {
		return formulariorepositorio.save(formulario);
	}

	@Override
	public List<Formulario> ListarFormularios() {
		return formulariorepositorio.findAll();
	}

	@Override
	public Formulario ListarFormularioPorId(Long id) {
		return formulariorepositorio.findById(id).orElse(null);
	}

	@Override
	public void EliminarFormulario(Long id) {
		formulariorepositorio.deleteById(id);
	}

	@Override
	public Formulario buscarPorCodigo(String codigo) {
		return formulariorepositorio.findByCodigo(codigo);
	}

	@Override
	public List<Formulario> listarPorUsuario(Usuario usuario) {
		return formulariorepositorio.findByUsuarioOrderByEstadoAsc(usuario);
	}

	@Override
	public List<Formulario> listarPorUnidad(Unidad unidad) {
		return formulariorepositorio.findByUnidadOrderByEstadoResponsableAsc(unidad);
	}

	@Override
	public List<Formulario> listarPorEstadoResponsable(String estado) {		
		return formulariorepositorio.findByEstadoResponsableOrderByEstadoDacAsc(estado);
	}

	@Override
	public List<Formulario> listarPorEstadoDacAprobado(String estado) {
		return formulariorepositorio.findByEstadoDac(estado);
	}

}
