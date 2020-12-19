package com.tesis.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.tesis.entidad.Unidad;
import com.tesis.repositorio.UnidadRepositorio;
import com.tesis.services.UnidadServicio;

@RestController
@RequestMapping("unidad")
public class UnidadControlador {

	
	@Autowired
	private UnidadServicio us;
	@Autowired
	private UnidadRepositorio ur;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarUnidad(@RequestBody Unidad unidad) {
		Map<String, Object> response = new HashMap<>();
		Unidad uni = null;
		uni =  ur.findByCodigo(unidad.getCodigo());
		
	
		
		try {
			
			if(uni == null) {
				uni = new Unidad(unidad.getId(),unidad.getCodigo(),unidad.getNombre(),unidad.getEstado());
				
				
				us.GuardarUnidad(uni);
				response.put("mensaje", "Creado exitosamente" );
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

			}else {
				response.put("mensaje", "Error: El codigo ya esta en uso");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			
			
			
			
		} catch (Exception e) {
			response.put("mensaje", "Error al ingresa");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
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
	
	@GetMapping("/listUnidadEstado/{estado}")
	public ResponseEntity<List> listarUnidadEstado(@PathVariable Boolean estado){
		try {
			return  ResponseEntity.ok(us.ListarUnidadPorEstado(estado));
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
	
	
	
	@PutMapping("/editar")
	public ResponseEntity<?> editarUnidad(@Valid @RequestBody Unidad unidad,  BindingResult bindingResult ) {
		Map<String, Object> response = new HashMap<>();
		
		Unidad uni = us.ListarUnidadPorId(unidad.getId());
		
		try {

			if (uni == null) {
				response.put("mensaje", "La unidad  no existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
					us.GuardarUnidad(unidad);

					response.put("mensaje", "Actualizado Con Exito");
					response.put("rol", unidad);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
			}
		} catch (Exception e) {
			response.put("mensaje", "Error al Actualizar");
			return new ResponseEntity<>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
