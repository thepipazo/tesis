package com.tesis.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "ambitos_graficos")
public class AmbitoGrafico {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nombre_ambito;
	
	
	public AmbitoGrafico() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre_ambito() {
		return nombre_ambito;
	}


	public void setNombre_ambito(String nombre_ambito) {
		this.nombre_ambito = nombre_ambito;
	}

	
	

}
