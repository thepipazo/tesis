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

import com.tesis.entidad.Permiso;
import com.tesis.services.PermisoServicio;

@RestController
@RequestMapping("permiso")
public class PermisoControlador {

	@Autowired
	private PermisoServicio ps;
	
	@PostMapping("/guardar")
	public ResponseEntity<Permiso> guardarPermiso(@RequestBody Permiso permiso){
		try {
			ps.GuardarPermiso(permiso);
			return new ResponseEntity<Permiso>(HttpStatus.CREATED);			
		} catch (Exception e) {
			return new ResponseEntity<Permiso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("list")
	public ResponseEntity<List> listarPermiso(){
		try {
			return  ResponseEntity.ok(ps.ListarPermisos());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Permiso> buscarPermiso(@PathVariable Long id){
		try {
			return  ResponseEntity.ok(ps.ListarPermisoPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarPermiso(@PathVariable Long id){
		try {
			if(ps.ListarPermisoPorId(id) == null ) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				ps.EliminarPermiso(id);
				return new ResponseEntity<>(true,HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
