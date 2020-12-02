package com.tesis.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.entidad.Usuario;
import com.tesis.services.UsuarioServicio;

@RestController
@RequestMapping("usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio us;
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		try {
			us.GuardarUsuario(usuario);
			return new ResponseEntity<Usuario>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarUsuario(){
		try {
			return  ResponseEntity.ok(us.ListarUsuarios());
		} catch (Exception e) {
			return new ResponseEntity<List>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{rut}")
	public ResponseEntity<Usuario> BuscarUsuario(@PathVariable String rut){
		try {			
			return ResponseEntity.ok(us.ListarUsuarioPorRut(rut));
		} catch (Exception e) {
			
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarUsuario(@PathVariable Long id){
		try {
			if(us.ListarUsuarioPorId(id) == null) {				
				return new ResponseEntity<Boolean>(false ,HttpStatus.INTERNAL_SERVER_ERROR );				
			}else {
				us.EliminarUsuario(id);
				return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {			
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
