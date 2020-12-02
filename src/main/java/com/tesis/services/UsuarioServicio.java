package com.tesis.services;

import java.util.List;

import com.tesis.entidad.Usuario;

public interface UsuarioServicio {

	public Usuario GuardarUsuario(Usuario usuario);
	public List<Usuario>ListarUsuarios();
	public Usuario ListarUsuarioPorId(Long id);
	public Usuario ListarUsuarioPorRut(String id);
	public void EliminarUsuario(Long id);

}
