package com.tesis.services;

import java.util.List;

import com.tesis.entidad.Formulario;
import com.tesis.entidad.Unidad;
import com.tesis.security.entity.Usuario;

public interface FormularioServicio {

	public Formulario GuardarFormulario(Formulario formulario);
	public List<Formulario>ListarFormularios();
	public Formulario ListarFormularioPorId(Long id);
	public void EliminarFormulario(Long id);
	public Formulario buscarPorCodigo(String codigo);
	public List<Formulario> listarPorUsuario(Usuario usuario);
	public List<Formulario> listarPorUnidad(Unidad unidad);
	public List<Formulario> listarPorEstadoResponsable(String estado);
	public List<Formulario> listarPorEstadoDacAprobado(String estado);

}
