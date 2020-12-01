package com.tesis.services;

import java.util.List;

import com.tesis.entidad.Rol;

public interface RolServicio {
	
	public Rol GuardarRol(Rol Rol);
	public List<Rol>ListarRols();
	public Rol ListarRolPorId(Long id);
	public void EliminarRol(Long id);

}
