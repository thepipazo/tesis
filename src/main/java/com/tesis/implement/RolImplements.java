/*
 * package com.tesis.implement;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.tesis.entidad.Role; import com.tesis.entidad.User; import
 * com.tesis.repositorio.RolRepositorio; import com.tesis.services.RolServicio;
 * 
 * @Service public class RolImplements implements RolServicio {
 * 
 * @Autowired private RolRepositorio rolrepositorio;
 * 
 * @Override public Role GuardarRol(Role rol) { return rolrepositorio.save(rol);
 * }
 * 
 * @Override public List<Role> ListarRols() { return rolrepositorio.findAll(); }
 * 
 * @Override public Role ListarRolPorId(Long id) { return
 * rolrepositorio.findById(id).orElse(null); }
 * 
 * @Override public void EliminarRol(Long id) { rolrepositorio.deleteById(id); }
 * 
 * @Override public Role BuscarPorNombre(String nombre) { return
 * rolrepositorio.findByNombre(nombre); }
 * 
 * }
 */