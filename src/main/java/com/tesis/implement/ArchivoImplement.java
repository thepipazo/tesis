package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.Archivo;
import com.tesis.repositorio.ArchivoRepositorio;
import com.tesis.services.ArchivoServicio;

@Service
public class ArchivoImplement implements ArchivoServicio{

	@Autowired
	private ArchivoRepositorio archivorepositorio;
	
	@Override
	public Archivo GuardarArchivo(Archivo archivo) {
		return archivorepositorio.save(archivo);
	}

	@Override
	public List<Archivo> ListarArchivos() {
		return archivorepositorio.findAll();
	}

	@Override
	public Archivo ListarArchivoPorId(Long id) {
		return archivorepositorio.findById(id).orElse(null);
	}

	@Override
	public void EliminarArchivo(Long id) {
		archivorepositorio.deleteById(id);
	}

}
