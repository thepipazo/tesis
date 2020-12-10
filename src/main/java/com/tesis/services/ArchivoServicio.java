package com.tesis.services;

import java.util.List;

import com.tesis.entidad.Archivo;

public interface ArchivoServicio {

	public Archivo GuardarArchivo(Archivo archivo);
	public List<Archivo>ListarArchivos();
	public Archivo ListarArchivoPorId(Long id);
	public void EliminarArchivo(Long id);
}
