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

import com.tesis.entidad.Unidad;
import com.tesis.services.UnidadServicio;

@RestController
@RequestMapping("unidad")
public class UnidadControlador {

	
	@Autowired
	private UnidadServicio us;
	
	@PostMapping("/guardar")
	public ResponseEntity<Unidad> guardarUnidad(@RequestBody Unidad rol){
		try {
			us.GuardarUnidad(rol);
			return new ResponseEntity<Unidad>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Unidad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarUnidad(){
		try {
			return  ResponseEntity.ok(us.ListarUnidads());
		} catch (Exception e) {
			return new ResponseEntity<List>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Unidad> BuscarUnidad(@PathVariable Long id){
		try {
			
			return ResponseEntity.ok(us.ListarUnidadPorId(id));
		} catch (Exception e) {
			
			return new ResponseEntity<Unidad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarUnidad(@PathVariable Long id){
		try {
			if(us.ListarUnidadPorId(id) == null) {				
				return new ResponseEntity<Boolean>(false ,HttpStatus.INTERNAL_SERVER_ERROR );				
			}else {
				us.EliminarUnidad(id);
				return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {			
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
