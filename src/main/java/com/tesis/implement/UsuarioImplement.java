package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.Usuario;
import com.tesis.repositorio.UsuarioRepositorio;
import com.tesis.services.UsuarioServicio;

@Service
public class UsuarioImplement implements UsuarioServicio{

	@Autowired
	private UsuarioRepositorio usuariorepositorio;
	
	@Override
	public Usuario GuardarUsuario(Usuario usuario) {
		return usuariorepositorio.save(usuario);
	}

	@Override
	public List<Usuario> ListarUsuarios() {
		return usuariorepositorio.findAll();
	}

	@Override
	public Usuario ListarUsuarioPorId(Long id) {
		return usuariorepositorio.findById(id).orElse(null);
	}

	@Override
	public void EliminarUsuario(Long id) {
		usuariorepositorio.deleteById(id);
	}

	@Override
	public Usuario ListarUsuarioPorRut(String rut) {
		return usuariorepositorio.findUsuarioByRut(rut);
	}



}
