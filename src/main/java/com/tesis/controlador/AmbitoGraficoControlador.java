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

import com.tesis.entidad.AmbitoGrafico;
import com.tesis.implement.AmbitoGraficoImplement;

@RestController
@RequestMapping("grafico")
public class AmbitoGraficoControlador {

	@Autowired
	private AmbitoGraficoImplement agi;

	@PostMapping("/guardar")
	public ResponseEntity<AmbitoGrafico> guardarAmbito(@RequestBody AmbitoGrafico grafico) {
		try {
			agi.GuardarAmbitoGrafico(grafico);
			if (agi.ListarAmbitoGraficoPorId(grafico.getId()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<>(null, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List> listarGrafico() {
		try {
			return ResponseEntity.ok(agi.ListarAmbitoGraficos());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list/{id}")
	public ResponseEntity<AmbitoGrafico> listarGraficoPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(agi.ListarAmbitoGraficoPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarGrafico(@PathVariable Long id) {
		try {

			if (agi.ListarAmbitoGraficoPorId(id) == null) {
				return ResponseEntity.ok(false);
			} else {
				agi.EliminarAmbitoGrafico(id);
				return ResponseEntity.ok(true);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
