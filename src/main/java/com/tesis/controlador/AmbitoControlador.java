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

import com.tesis.entidad.Ambito;
import com.tesis.implement.AmbitoImplement;

@RestController
@RequestMapping("ambito")
public class AmbitoControlador {

	@Autowired
	private AmbitoImplement ai;

	
	
	@PostMapping("/guardar")
	public ResponseEntity<Ambito> guardarUser(@RequestBody Ambito ambito) {
		try {
			ai.GuardarAmbito(ambito);
			return new ResponseEntity<Ambito>(HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/list")
	public ResponseEntity<List> ListarAmbito() {
		try {
			return ResponseEntity.ok(ai.ListarAmbitos());
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	
	@GetMapping("list/{id}")
	public ResponseEntity<Ambito> AmbitoPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(ai.ListarAmbitoPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("delete/{id}")
	private ResponseEntity<Boolean> EliminarCriterio(@PathVariable("id") Long id) {
		try {
			if (ai.ListarAmbitoPorId(id) != null) {
				ai.EliminarAmbito(id);
				return ResponseEntity.ok(true);
			} else {
				return ResponseEntity.ok(false);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// return ResponseEntity.ok(!(ci.ListarCriterioPorId(id)!= null));
	}
}
