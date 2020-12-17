/*
 * package com.tesis.controlador;
 * 
 * import java.util.HashMap; import java.util.List; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.dao.DataAccessException; import
 * org.springframework.dao.DataIntegrityViolationException; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.access.prepost.PreAuthorize; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.tesis.entidad.Role; import com.tesis.entidad.User; import
 * com.tesis.repositorio.UsuarioRepositorio; import
 * com.tesis.services.RolServicio;
 * 
 * @RestController
 * 
 * @RequestMapping("rol") public class RolControlador {
 * 
 * @Autowired private RolServicio rs;
 * 
 * @Autowired private UsuarioRepositorio ur;
 * 
 * @PreAuthorize("hasRole('ADMIN')")
 * 
 * @PostMapping("/guardar") public ResponseEntity<?> guardarRol(@RequestBody
 * Role rol) { Map<String, Object> response = new HashMap<>();
 * 
 * try {
 * 
 * if (rs.BuscarPorNombre(rol.getNombre()) == null) { rs.GuardarRol(rol); } else
 * { response.put("mensaje", "Error : El rol " + "'" + rol.getNombre() + "'" +
 * " ya existe " + " "); return new ResponseEntity<Map<String,
 * Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
 * 
 * }
 * 
 * } catch (DataAccessException a) { response.put("mensaje",
 * "Error al insertar"); return new ResponseEntity<Map<String,
 * Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * response.put("mensaje", "Ingresado Con Exito"); response.put("rol", rol);
 * 
 * return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
 * }
 * 
 * @PreAuthorize("hasRole('ADMIN')")
 * 
 * @PutMapping("/editar") public ResponseEntity<?> EditarRol(@RequestBody Role
 * rol){ Map<String, Object> response = new HashMap<>();
 * 
 * Role rol2 = rs.ListarRolPorId(rol.getId()); Role rolname =
 * rs.BuscarPorNombre(rol.getNombre());
 * 
 * try { if(rol2 == null) { response.put("mensaje", "El rol no existe"); return
 * new
 * ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR)
 * ; }else {
 * 
 * if(rolname != null && rolname.getId() == rol.getId() || rol2 != null &&
 * rolname == null) {//en este if se pregunta si el que esta actualizando es el
 * dueño del el nombre ya que este es unico y no se puede actualizar a otro rol
 * 
 * rs.GuardarRol(rol); response.put("mensaje", "Actualizado Con Exito");
 * response.put("rol", rol); return new
 * ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED); }else {
 * response.put("mensaje", "Error : El rol "+"'"+ rol.getNombre()
 * +"'"+" ya existe "+" "); return new
 * ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR)
 * ;
 * 
 * } } } catch (Exception e) { response.put("mensaje", "Error al Actualizar");
 * return new
 * ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR)
 * ; } }
 * 
 * @GetMapping("/list") public ResponseEntity<List> listarRol() { try { return
 * ResponseEntity.ok(rs.ListarRols()); } catch (Exception e) { return new
 * ResponseEntity<List>(HttpStatus.INTERNAL_SERVER_ERROR); } }
 * 
 * @GetMapping("/list/{id}") public ResponseEntity<Role> BuscarRol(@PathVariable
 * Long id) { try {
 * 
 * return ResponseEntity.ok(rs.ListarRolPorId(id)); } catch (Exception e) {
 * 
 * return new ResponseEntity<Role>(HttpStatus.INTERNAL_SERVER_ERROR); } }
 * 
 * @PreAuthorize("hasRole('ADMIN')")
 * 
 * @DeleteMapping("/delete/{id}") public ResponseEntity<?>
 * eliminarRol(@PathVariable Long id) {
 * 
 * Map<String, Object> response = new HashMap<>();
 * 
 * Role rolTodo = rs.ListarRolPorId(id); User rolRelacion =
 * ur.findUsuarioByRol(rolTodo);
 * 
 * try { if (rolTodo == null) { response.put("mensaje", "El rol no existe");
 * return new ResponseEntity<Map<String, Object>>(response,
 * HttpStatus.INTERNAL_SERVER_ERROR);
 * 
 * } else { if (rolRelacion == null) {
 * 
 * rs.EliminarRol(id); response.put("mensaje", "El rol :" + rolTodo.getNombre()
 * + "fue eliminado con exito"); return new ResponseEntity<Map<String,
 * Object>>(response, HttpStatus.ACCEPTED); } else {
 * 
 * response.put("mensaje", "El rol esta relacionado con el usuario :" +
 * rolRelacion.getRut()); return new ResponseEntity<Map<String,
 * Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); } } } catch (Exception
 * e) { response.put("mensaje", "Error al Eliminar"); return new
 * ResponseEntity<Map<String, Object>>(response,
 * HttpStatus.INTERNAL_SERVER_ERROR); } } }
 */