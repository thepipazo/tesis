package com.tesis.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.entidad.Proceso;
import com.tesis.implement.ProcesoImplement;

@RestController
@RequestMapping("proceso")
public class ProcesoControlador {

	@Autowired
	private ProcesoImplement pi;
	
	
	
	@PostMapping("guardar")
	public ResponseEntity<Proceso> GuardarProceso(@RequestBody Proceso proceso) {
		try {
			pi.GuardarProceso(proceso);
			return new ResponseEntity<Proceso>(HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarProcesos(){
		try {
			return ResponseEntity.ok(pi.ListarProcesos());
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Proceso>listarProcesoPorId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(pi.ListarProcesoPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus eliminarProceso(@PathVariable Long id){
		try {
			pi.EliminarProceso(id);
			if(pi.ListarProcesoPorId(id) == null) {
				return HttpStatus.OK;
			}
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;

	}
}
