package com.tesis.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.FotoUsuario;
import com.tesis.repositorio.FotoUsusarioRepositorio;
import com.tesis.services.FotoUsuarioServicio;

@Service
public class FotoUsuarioImplement implements FotoUsuarioServicio {

	@Autowired
	private FotoUsusarioRepositorio fr;
	
	
	@Override	
	public FotoUsuario buscarFoto(Long id) {
		return fr.findById(id).orElse(null);
	}

	@Override
	public void eliminarFoto(Long id) {
		fr.deleteById(id);
	}

	@Override
	public FotoUsuario guardarFoto(FotoUsuario foto) {
		return fr.save(foto);
	}


}
