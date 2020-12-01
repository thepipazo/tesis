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

import com.tesis.entidad.Rol;
import com.tesis.services.RolServicio;

@RestController
@RequestMapping("rol")
public class RolControlador {

	@Autowired
	private RolServicio rs;
	
	@PostMapping("/guardar")
	public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol){
		try {
			rs.GuardarRol(rol);
			return new ResponseEntity<Rol>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarRol(){
		try {
			return  ResponseEntity.ok(rs.ListarRols());
		} catch (Exception e) {
			return new ResponseEntity<List>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Rol> BuscarRol(@PathVariable Long id){
		try {
			
			return ResponseEntity.ok(rs.ListarRolPorId(id));
		} catch (Exception e) {
			
			return new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarRol(@PathVariable Long id){
		try {
			if(rs.ListarRolPorId(id) == null) {				
				return new ResponseEntity<Boolean>(false ,HttpStatus.INTERNAL_SERVER_ERROR );				
			}else {
				rs.EliminarRol(id);
				return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {			
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
