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

import com.tesis.entidad.PlanAnual;
import com.tesis.implement.PlanAnualImplement;
import com.tesis.services.PlanAnualServicio;

@RestController
@RequestMapping("plan")
public class PlanAnualControlador {

	@Autowired
	private PlanAnualImplement pa;
	
	@PostMapping("/guardar")
	public ResponseEntity<PlanAnual> guardarPlanAnual(@RequestBody PlanAnual permiso){
		try {
			pa.GuardarPlanAnual(permiso);
			return new ResponseEntity<PlanAnual>(HttpStatus.CREATED);			
		} catch (Exception e) {
			return new ResponseEntity<PlanAnual>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("list")
	public ResponseEntity<List> listarPlanAnual(){
		try {
			return  ResponseEntity.ok(pa.ListarPlanAnuals());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<PlanAnual> buscarPlanAnual(@PathVariable Long id){
		try {
			return  ResponseEntity.ok(pa.ListarPlanAnualPorId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> eliminarPlanAnual(@PathVariable Long id){
		try {
			if(pa.ListarPlanAnualPorId(id) == null ) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				pa.EliminarPlanAnual(id);
				return new ResponseEntity<>(true,HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
