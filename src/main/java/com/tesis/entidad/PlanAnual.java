package com.tesis.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name  = "planes_anuales")
public class PlanAnual {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private String comentario;
	private Date fecha;
	private String responsables;
	
	@ManyToOne
	private Debilidad debilidad;
	
	@ManyToOne
	private Unidad unidad;
	
	@ManyToOne
	private Criterio criterio;

	public PlanAnual() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResponsables() {
		return responsables;
	}

	public void setResponsables(String responsables) {
		this.responsables = responsables;
	}

	public Debilidad getDebilidad() {
		return debilidad;
	}

	public void setDebilidad(Debilidad debilidad) {
		this.debilidad = debilidad;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}
	
	
	
	
}
