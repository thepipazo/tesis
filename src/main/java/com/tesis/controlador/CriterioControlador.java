package com.tesis.controlador;

import java.util.List;
import java.util.Optional;

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

import com.tesis.entidad.Criterio;
import com.tesis.implement.CriterioImplement;

@RestController
@RequestMapping("criterio")
public class CriterioControlador {
	
	@Autowired
	private CriterioImplement ci;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Criterio> guardarUser(@RequestBody Criterio criterio) {
		try {
			ci.GuardarCriterio(criterio);
			return new ResponseEntity<Criterio>(HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/list")
	 public ResponseEntity<List> ListarCriterios() {
	    try {
	     return  ResponseEntity.ok(ci.ListarCriterios());
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@GetMapping("list/{id}")
    public ResponseEntity<Criterio> CriterioPorId (@PathVariable Long id) {
			try {
				return ResponseEntity.ok(ci.ListarCriterioPorId(id));						
			} catch (Exception e) {				
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}				
		}
	
	@DeleteMapping("delete/{id}")	
		private ResponseEntity<Boolean> EliminarCriterio (@PathVariable ("id") Long id){
			ci.EliminarCriterio(id);
			return ResponseEntity.ok(!(ci.ListarCriterioPorId(id)!= null));		
	}
	
	

}
