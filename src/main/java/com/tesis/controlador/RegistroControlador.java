package com.tesis.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.tesis.entidad.Registro;
import com.tesis.entidad.Unidad;
import com.tesis.implement.RegistroImplement;
import com.tesis.services.RegistroServicio;

@RestController
@RequestMapping("registro")
public class RegistroControlador {

	@Autowired
	private RegistroServicio rs;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarRegistro(@RequestBody Registro registro) {
		Map<String, Object> response = new HashMap<>();

		try {
			if (rs.buscarRegistroPorNombre(registro.getTipo_registro()) == null) {
				rs.GuardarRegistro(registro);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			} else {
				response.put("mensaje", "El registro ya existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			response.put("mensaje", "Error al guardar");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Registro>> listarRegistro(){
		try {
			return new  ResponseEntity<List<Registro>>(rs.ListarRegistros(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Registro>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Registro> BuscarRegistro(@PathVariable Long id){
		try {
			
			return ResponseEntity.ok(rs.ListarRegistroPorId(id));
		} catch (Exception e) {
			
			return new ResponseEntity<Registro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarRegistro(@PathVariable Long id){
		try {
			if(rs.ListarRegistroPorId(id) == null) {				
				return new ResponseEntity<Boolean>(false ,HttpStatus.INTERNAL_SERVER_ERROR );				
			}else {
				rs.EliminarRegistro(id);
				return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {			
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PutMapping("/editar")
	public ResponseEntity<?> editarRegistro(@Valid @RequestBody Registro registro,  BindingResult bindingResult ) {
		Map<String, Object> response = new HashMap<>();
		
		
		try {

			if (rs.ListarRegistroPorId(registro.getId())==null) {
				response.put("mensaje", "El registro  no existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
				rs.GuardarRegistro(registro);

					response.put("mensaje", "Unidad actualizado Con Exito");
					response.put("rol", registro);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
			}
		} catch (Exception e) {
			if(rs.buscarRegistroPorNombre(registro.getTipo_registro()) != null && rs.buscarRegistroPorNombre(registro.getTipo_registro()).getId() != registro.getId()) {
				response.put("mensaje", "El codigo ya esta en uso");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}else
			response.put("mensaje", "Error al Actualizar");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
