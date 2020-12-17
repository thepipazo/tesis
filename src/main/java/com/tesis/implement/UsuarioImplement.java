/*
 * package com.tesis.implement;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.tesis.entidad.User; import
 * com.tesis.repositorio.UsuarioRepositorio; import
 * com.tesis.services.UsuarioServicio;
 * 
 * @Service public class UsuarioImplement implements UsuarioServicio{
 * 
 * @Autowired private UsuarioRepositorio usuariorepositorio;
 * 
 * @Override public User GuardarUsuario(User usuario) { return
 * usuariorepositorio.save(usuario); }
 * 
 * @Override public List<User> ListarUsuarios() { return
 * usuariorepositorio.findAll(); }
 * 
 * @Override public User ListarUsuarioPorId(Long id) { return
 * usuariorepositorio.findById(id).orElse(null); }
 * 
 * @Override public void EliminarUsuario(Long id) {
 * usuariorepositorio.deleteById(id); }
 * 
 * @Override public User ListarUsuarioPorRut(String rut) { return
 * usuariorepositorio.findUsuarioByRut(rut); }
 * 
 * 
 * 
 * }
 */