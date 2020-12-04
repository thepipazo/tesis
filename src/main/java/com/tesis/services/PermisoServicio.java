package com.tesis.services;

import java.util.List;
import com.tesis.entidad.Permiso;

public interface PermisoServicio {

	public Permiso GuardarPermiso(Permiso permiso);
	public List<Permiso>ListarPermisos();
	public Permiso ListarPermisoPorId(Long id);
	public void EliminarPermiso(Long id);
}
