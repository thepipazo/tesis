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

import com.tesis.entidad.Archivo;
import com.tesis.services.ArchivoServicio;

@RestController
@RequestMapping("archivo")
public class ArchivoControlador {

	@Autowired
	private ArchivoServicio as;

	@PostMapping("/guardar")
	public ResponseEntity<Archivo> guardarUser(@RequestBody Archivo criterio) {
		try {
			as.GuardarArchivo(criterio);
			return new ResponseEntity<Archivo>(HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/list")
	public ResponseEntity<List> ListarArchivos() {
		try {
			return ResponseEntity.ok(as.ListarArchivos());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("list/{id}")
	public ResponseEntity<Archivo> ArchivoPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(as.ListarArchivoPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("delete/{id}")
	private ResponseEntity<Boolean> EliminarArchivo(@PathVariable("id") Long id) {
		try {
			if (as.ListarArchivoPorId(id) != null) {
				as.EliminarArchivo(id);
				return ResponseEntity.ok(true);
			} else {
				return ResponseEntity.ok(false);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// return ResponseEntity.ok(!(as.ListarArchivoPorId(id)!= null));
	}
}
