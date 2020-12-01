package com.tesis.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registros")
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String tipo_registro;
	
	public Registro() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_registro() {
		return tipo_registro;
	}

	public void setTipo_registro(String tipo_registro) {
		this.tipo_registro = tipo_registro;
	}
	
	
}
