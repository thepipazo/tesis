package com.tesis.controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

import com.tesis.entidad.Formulario;
import com.tesis.entidad.Registro;
import com.tesis.entidad.Unidad;
import com.tesis.security.entity.Usuario;
import com.tesis.services.FormularioServicio;

@RestController
@RequestMapping("formulario")
public class FormularioControlador {

	@Autowired
	private FormularioServicio fs;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarFormulario(@Valid @RequestBody Formulario formulario){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = dateFormat.format(date);
		Formulario form = new Formulario(null,formulario.getCodigo(),formulario.getNplanmejora(),formulario.getDescripcion(),formulario.getResultado(),formulario.getAlmacenamiento(),formulario.getPersonaRelacionada(),
				formulario.getPalabraclave(),formulario.getNombrecorto(),formulario.getEstado(),formulario.getObservaciones_r(),formulario.getObservaciones_d(),formulario.getUsuario(),formulario.getResponsable(),formulario.getDca(),
				formulario.getDebilidad(),formulario.getUnidad(),formulario.getRegistro(),formulario.getAmbito_a(),formulario.getAmbito_g(),formulario.getProceso(),formulario.getCriterio(),
				formulario.getAutoridadesI(),formulario.getAdministrativosI(),formulario.getDocentesI(),formulario.getEstudiantesI(),formulario.getAdministrativosE(),formulario.getDocentesE(),formulario.getAutoridadesE(),
				formulario.getAutoridadesE(),formulario.getEstadoResponsable(),formulario.getEstadoDac(), fecha);
		
		Map<String, Object> response = new HashMap<>();

		try {
			
			fs.GuardarFormulario(form);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("mensaje", "Error al guardar");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);		}	
	}
	
	@GetMapping("/list")
	public ResponseEntity<List> listarFormulario(){
		try {
			return  ResponseEntity.ok(fs.ListarFormularios());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/listPorEstadoDacEspera")
	public ResponseEntity<List> listarFormularioDacEspera(){
		try {
			return  ResponseEntity.ok(fs.listarPorEstadoResponsable("Aprobado"));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listPorEstadoDacAprobado")
	public ResponseEntity<List> listPorEstadoDacAprobado(){
		try {
			return  ResponseEntity.ok(fs.listarPorEstadoDacAprobado("Aprobado"));
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
	
	
	@GetMapping("/listPorUsuario/{usu}")
	public ResponseEntity<List<Formulario>> buscarFormularioPorUsuario(@PathVariable Integer usu){
		Usuario usuario = new Usuario(usu);
		System.out.println(usu);
		try {
			return  ResponseEntity.ok(fs.listarPorUsuario(usuario));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listPorUnidad/{uni}")
	public ResponseEntity<List<Formulario>> buscarFormularioPorEntidad(@PathVariable Long uni){
		System.out.println("esta wea"+uni);
		Unidad unida = new Unidad(uni);
		
		try {
			return  ResponseEntity.ok(fs.listarPorUnidad(unida));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminarFormulario(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		String f = "En Espera";
		Formulario form;
		form = fs.ListarFormularioPorId(id);
		try {

			if (fs.ListarFormularioPorId(id) == null) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {

				if (form.getEstado().equals(f)) {

					fs.EliminarFormulario(id);
					return new ResponseEntity<>(true, HttpStatus.OK);

				} else {
					response.put("mensaje", "La evidencia ya esta en revision");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
	
	@PutMapping("/editar")
	public ResponseEntity<?> editarFormulario(@Valid @RequestBody Formulario formulario,  BindingResult bindingResult ) {
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = dateFormat.format(date);
		Formulario form = new Formulario(formulario.getId(),formulario.getCodigo(),formulario.getNplanmejora(),formulario.getDescripcion(),formulario.getResultado(),formulario.getAlmacenamiento(),formulario.getPersonaRelacionada(),
				formulario.getPalabraclave(),formulario.getNombrecorto(),formulario.getEstado(),formulario.getObservaciones_r(),formulario.getObservaciones_d(),formulario.getUsuario(),formulario.getResponsable(),formulario.getDca(),
				formulario.getDebilidad(),formulario.getUnidad(),formulario.getRegistro(),formulario.getAmbito_a(),formulario.getAmbito_g(),formulario.getProceso(),formulario.getCriterio(),
				formulario.getAutoridadesI(),formulario.getAdministrativosI(),formulario.getDocentesI(),formulario.getEstudiantesI(),formulario.getAdministrativosE(),formulario.getDocentesE(),formulario.getAutoridadesE(),
				formulario.getAutoridadesE(),formulario.getEstadoResponsable(),formulario.getEstadoDac(), fecha);
		
		Map<String, Object> response = new HashMap<>();
		
		
		try {

			if (fs.ListarFormularioPorId(formulario.getId())==null) {
				response.put("mensaje", "El registro  no existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
				fs.GuardarFormulario(form);

					response.put("mensaje", "Unidad actualizado Con Exito");
					response.put("rol", formulario);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
			}
		} catch (Exception e) {		
			response.put("mensaje", "Error al Actualizar");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
