package com.tesis.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formularios")
public class Formulario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nplanmejora;
	private String descripcion;
	private String resultado;
	private String almacenamiento;
	private String palabraclave;
	private String resume;
	private String codigo;
	private String estado;
	private String observaciones_r;
	private String observaciones_d;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Usuario responsable;

	@ManyToOne
	private Usuario autoridad_interno;

	
	@ManyToOne
	private Usuario admin_interno;

	@ManyToOne
	private Usuario docente_interno;

	@ManyToOne
	private Usuario estudiante_interno;
	
	@ManyToOne
	private Usuario autoridad_externo;
	
	@ManyToOne
	private Usuario admin_externo;
	
	@ManyToOne
	private Usuario docente_externo;

	@ManyToOne
	private Usuario estudiante_externo;
	
	@ManyToOne
	private Debilidad debilidad;
	
	@ManyToOne
	private Unidad unidad;
	
	@ManyToOne
	private Registro registro;
	
	@ManyToOne
	private Ambito ambito_a;
	
	@ManyToOne
	private AmbitoGrafico ambito_g;
	
	@ManyToOne
	private Proceso proceso;

	
	
	public Formulario() {
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNplanmejora() {
		return nplanmejora;
	}



	public void setNplanmejora(String nplanmejora) {
		this.nplanmejora = nplanmejora;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getResultado() {
		return resultado;
	}



	public void setResultado(String resultado) {
		this.resultado = resultado;
	}



	public String getAlmacenamiento() {
		return almacenamiento;
	}



	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}



	public String getPalabraclave() {
		return palabraclave;
	}



	public void setPalabraclave(String palabraclave) {
		this.palabraclave = palabraclave;
	}



	public String getResume() {
		return resume;
	}



	public void setResume(String resume) {
		this.resume = resume;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getObservaciones_r() {
		return observaciones_r;
	}



	public void setObservaciones_r(String observaciones_r) {
		this.observaciones_r = observaciones_r;
	}



	public String getObservaciones_d() {
		return observaciones_d;
	}



	public void setObservaciones_d(String observaciones_d) {
		this.observaciones_d = observaciones_d;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Usuario getResponsable() {
		return responsable;
	}



	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}



	public Usuario getAutoridad_interno() {
		return autoridad_interno;
	}



	public void setAutoridad_interno(Usuario autoridad_interno) {
		this.autoridad_interno = autoridad_interno;
	}



	public Usuario getAdmin_interno() {
		return admin_interno;
	}



	public void setAdmin_interno(Usuario admin_interno) {
		this.admin_interno = admin_interno;
	}



	public Usuario getDocente_interno() {
		return docente_interno;
	}



	public void setDocente_interno(Usuario docente_interno) {
		this.docente_interno = docente_interno;
	}



	public Usuario getEstudiante_interno() {
		return estudiante_interno;
	}



	public void setEstudiante_interno(Usuario estudiante_interno) {
		this.estudiante_interno = estudiante_interno;
	}



	public Usuario getAutoridad_externo() {
		return autoridad_externo;
	}



	public void setAutoridad_externo(Usuario autoridad_externo) {
		this.autoridad_externo = autoridad_externo;
	}



	public Usuario getAdmin_externo() {
		return admin_externo;
	}



	public void setAdmin_externo(Usuario admin_externo) {
		this.admin_externo = admin_externo;
	}



	public Usuario getDocente_externo() {
		return docente_externo;
	}



	public void setDocente_externo(Usuario docente_externo) {
		this.docente_externo = docente_externo;
	}



	public Usuario getEstudiante_externo() {
		return estudiante_externo;
	}



	public void setEstudiante_externo(Usuario estudiante_externo) {
		this.estudiante_externo = estudiante_externo;
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



	public Registro getRegistro() {
		return registro;
	}



	public void setRegistro(Registro registro) {
		this.registro = registro;
	}



	public Ambito getAmbito_a() {
		return ambito_a;
	}



	public void setAmbito_a(Ambito ambito_a) {
		this.ambito_a = ambito_a;
	}



	public AmbitoGrafico getAmbito_g() {
		return ambito_g;
	}



	public void setAmbito_g(AmbitoGrafico ambito_g) {
		this.ambito_g = ambito_g;
	}



	public Proceso getProceso() {
		return proceso;
	}



	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
	
	
	
	
	
	
	
	
	
	
	
}
