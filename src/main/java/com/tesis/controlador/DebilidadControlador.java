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

import com.tesis.entidad.Debilidad;
import com.tesis.implement.DebilidadImplement;

@RestController
@RequestMapping("debilidad")
public class DebilidadControlador {

	@Autowired
	private DebilidadImplement di;

	@PostMapping("/guardar")
	public ResponseEntity<Debilidad> guardarUser(@RequestBody Debilidad criterio) {
		try {
			di.GuardarDebilidad(criterio);
			return new ResponseEntity<Debilidad>(HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/list")
	public ResponseEntity<List> ListarDebilidads() {
		try {
			return ResponseEntity.ok(di.ListarDebilidads());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("list/{id}")
	public ResponseEntity<Debilidad> DebilidadPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(di.ListarDebilidadPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("delete/{id}")
	private ResponseEntity<Boolean> EliminarDebilidad(@PathVariable("id") Long id) {
		try {
			if (di.ListarDebilidadPorId(id) != null) {
				di.EliminarDebilidad(id);
				return ResponseEntity.ok(true);
			} else {
				return ResponseEntity.ok(false);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
