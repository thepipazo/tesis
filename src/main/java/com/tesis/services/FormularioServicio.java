package com.tesis.services;

import java.util.List;

import com.tesis.entidad.Formulario;

public interface FormularioServicio {

	public Formulario GuardarFormulario(Formulario formulario);
	public List<Formulario>ListarFormularios();
	public Formulario ListarFormularioPorId(Long id);
	public void EliminarFormulario(Long id);
}
