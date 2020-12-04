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

import com.tesis.entidad.Formulario;
import com.tesis.services.FormularioServicio;

@RestController
@RequestMapping("formulario")
public class FormularioControlador {

	@Autowired
	private FormularioServicio fs;
	
	@PostMapping("/guardar")
	public ResponseEntity<Formulario> guardarFormulario(@RequestBody Formulario permiso){
		try {
			fs.GuardarFormulario(permiso);
			return new ResponseEntity<Formulario>(HttpStatus.CREATED);			
		} catch (Exception e) {
			return new ResponseEntity<Formulario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarFormulario(){
		try {
			return  ResponseEntity.ok(fs.ListarFormularios());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Formulario> buscarFormulario(@PathVariable Long id){
		try {
			return  ResponseEntity.ok(fs.ListarFormularioPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarFormulario(@PathVariable Long id){
		try {
			if(fs.ListarFormularioPorId(id) == null ) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				fs.EliminarFormulario(id);
				return new ResponseEntity<>(true,HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
