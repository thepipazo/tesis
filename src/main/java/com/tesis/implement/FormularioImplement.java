package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.Formulario;
import com.tesis.repositorio.FormularioRepositorio;
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

}
