/*
 * package com.tesis.implement;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.tesis.entidad.Permiso; import
 * com.tesis.repositorio.PermisoRepositorio; import
 * com.tesis.services.PermisoServicio;
 * 
 * @Service public class PermisoImplement implements PermisoServicio{
 * 
 * @Autowired private PermisoRepositorio permisorepositorio;
 * 
 * @Override public Permiso GuardarPermiso(Permiso permiso) { return
 * permisorepositorio.save(permiso); }
 * 
 * @Override public List<Permiso> ListarPermisos() { return
 * permisorepositorio.findAll(); }
 * 
 * @Override public Permiso ListarPermisoPorId(Long id) { return
 * permisorepositorio.findById(id).orElse(null); }
 * 
 * @Override public void EliminarPermiso(Long id) {
 * permisorepositorio.deleteById(id); }
 * 
 * }
 */