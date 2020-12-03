package com.tesis.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.entidad.FotoUsuario;
import com.tesis.services.FotoUsuarioServicio;

@RestController
@RequestMapping(name = "foto")
public class FotoUsuarioControlador {
	
	@Autowired
	private FotoUsuarioServicio fs;
	
	
	@PostMapping("guardar")
	public ResponseEntity<FotoUsuario> guardarFoto(@RequestBody FotoUsuario foto){
		try {
			fs.guardarFoto(foto);
			return new ResponseEntity<FotoUsuario>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<FotoUsuario>(HttpStatus.INTERNAL_SERVER_ERROR);
 		}
	}
	

}
