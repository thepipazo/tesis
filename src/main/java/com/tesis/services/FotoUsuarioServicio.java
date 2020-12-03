package com.tesis.services;

import com.tesis.entidad.FotoUsuario;

public interface FotoUsuarioServicio {	
	
	public FotoUsuario guardarFoto(FotoUsuario foto); 
	public FotoUsuario buscarFoto(Long id);
	public void eliminarFoto(Long id);
	
}
