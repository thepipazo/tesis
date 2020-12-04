package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tesis.entidad.Debilidad;
import com.tesis.repositorio.DebilidadRepositorio;
import com.tesis.services.DebilidadServicio;

@Service
public class DebilidadImplement implements DebilidadServicio {
	
	@Autowired
	private DebilidadRepositorio debilidadrepositorio;

	@Override
	public Debilidad GuardarDebilidad(Debilidad debilidad) {
		return debilidadrepositorio.save(debilidad);
	}

	@Override
	public List<Debilidad> ListarDebilidads() {
		return debilidadrepositorio.findAll();
	}
	
	@Override
	public Debilidad ListarDebilidadPorId(Long id) {
		return debilidadrepositorio.findById(id).orElse(null);
	}

	@Override
	public void EliminarDebilidad(Long id) {
		debilidadrepositorio.deleteById(id);
	}

}
