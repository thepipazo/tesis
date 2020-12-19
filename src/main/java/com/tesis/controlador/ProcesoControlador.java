package com.tesis.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.entidad.Proceso;
import com.tesis.entidad.Proceso;
import com.tesis.implement.ProcesoImplement;
import com.tesis.services.ProcesoServicio;

@RestController
@RequestMapping("proceso")
public class ProcesoControlador {

	@Autowired
	private ProcesoServicio ps;
	
	
	
	@PostMapping("guardar")
	public ResponseEntity<?> GuardarProceso(@Valid @RequestBody Proceso proceso) {
		Map<String, Object> response = new HashMap<>();

		try {
			if (ps.buscarProcesoPoCodigo(proceso.getCodigo()) == null) {
				
				ps.GuardarProceso(proceso);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			} else {
				response.put("mensaje", "Error: El codigo ya esta en uso");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (DataIntegrityViolationException e) {
			response.put("mensaje", "Error al guardar");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarProcesos(){
		try {
			return ResponseEntity.ok(ps.ListarProcesos());
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Proceso>listarProcesoPorId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(ps.ListarProcesoPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus eliminarProceso(@PathVariable Long id){
		try {
			ps.EliminarProceso(id);
			if(ps.ListarProcesoPorId(id) == null) {
				return HttpStatus.OK;
			}
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;

	}
	
	
	@PutMapping("/editar")
	public ResponseEntity<?> editarProceso(@Valid @RequestBody Proceso proceso,  BindingResult bindingResult ) {
		Map<String, Object> response = new HashMap<>();
		
		Proceso proce = ps.ListarProcesoPorId(proceso.getId());
		
		try {

			if (proce == null) {
				response.put("mensaje", "El proceso  no existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
					ps.GuardarProceso(proceso);

					response.put("mensaje", "Actualizado Con Exito");
					response.put("rol", proceso);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
			}
		} catch (Exception e) {
			if(ps.buscarProcesoPoCodigo(proceso.getCodigo()) != null && ps.buscarProcesoPoCodigo(proceso.getCodigo()).getId() != proceso.getId()) {
				response.put("mensaje", "El codigo ya esta en uso");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}else
			response.put("mensaje", "Error al Actualizar");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
