package com.tesis.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fotos_usuarios")
public class FotoUsuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Usuario usuario;	
	private String nombre_foto;
	
	
	
	public FotoUsuario() {
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre_foto() {
		return nombre_foto;
	}

	public void setNombre_foto(String nombre_foto) {
		this.nombre_foto = nombre_foto;
	}
	
}
