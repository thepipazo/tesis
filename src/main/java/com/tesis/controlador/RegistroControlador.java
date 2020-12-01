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

import com.tesis.entidad.Registro;
import com.tesis.implement.RegistroImplement;

@RestController
@RequestMapping("registro")
public class RegistroControlador {

	@Autowired
	private RegistroImplement ri;
	
	@PostMapping("/guardar")
	public ResponseEntity<Registro> guardarRegistro(@RequestBody Registro registro){
		try {
			ri.GuardarRegistro(registro);
			return new ResponseEntity<Registro>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Registro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarRegistro(){
		try {
			return  ResponseEntity.ok(ri.ListarRegistros());
		} catch (Exception e) {
			return new ResponseEntity<List>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Registro> BuscarRegistro(@PathVariable Long id){
		try {
			
			return ResponseEntity.ok(ri.ListarRegistroPorId(id));
		} catch (Exception e) {
			
			return new ResponseEntity<Registro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarRegistro(@PathVariable Long id){
		try {
			if(ri.ListarRegistroPorId(id) == null) {				
				return new ResponseEntity<Boolean>(false ,HttpStatus.INTERNAL_SERVER_ERROR );				
			}else {
				ri.EliminarRegistro(id);
				return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {			
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
