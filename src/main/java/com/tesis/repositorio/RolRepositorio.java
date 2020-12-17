/*
 * package com.tesis.repositorio;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * import com.tesis.entidad.Role; import com.tesis.entidad.User;
 * 
 * public interface RolRepositorio extends JpaRepository<Role, Long> {
 * 
 * public Role findByNombre(String nombre);
 * 
 * 
 * @Query("select c from City c where c.name like %?1") Rol validarUsuario(Long
 * id,String nombre);
 * 
 * }
 */