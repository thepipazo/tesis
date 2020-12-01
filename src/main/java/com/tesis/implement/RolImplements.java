package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.Rol;
import com.tesis.repositorio.RolRepositorio;
import com.tesis.services.RolServicio;

@Service
public class RolImplements implements RolServicio {

	@Autowired
	private RolRepositorio rolrepositorio;
	@Override
	public Rol GuardarRol(Rol rol) {
		return rolrepositorio.save(rol);
	}

	@Override
	public List<Rol> ListarRols() {
		return rolrepositorio.findAll();
	}

	@Override
	public Rol ListarRolPorId(Long id) {
		return rolrepositorio.findById(id).orElse(null);
	}

	@Override
	public void EliminarRol(Long id) {
		rolrepositorio.deleteById(id);
	}

}
