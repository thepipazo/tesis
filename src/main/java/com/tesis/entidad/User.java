/*
 * package com.tesis.entidad;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.Table;
 * 
 * 
 * @Entity
 * 
 * @Table(name = "usuarios") public class User {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
 * 
 * @Column(name = "rut",nullable = false, unique = true) private String rut;
 * private String nombre; private String apellido; private String email; private
 * String password;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name="id_rol") private Role rol;
 * 
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name="id_unidad") private Unidad unidad;
 * 
 * public User() { }
 * 
 * 
 * 
 * public Long getId() { return id; }
 * 
 * 
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * 
 * 
 * public String getRut() { return rut; }
 * 
 * public void setRut(String rut) { this.rut = rut; }
 * 
 * public String getNombre() { return nombre; }
 * 
 * public void setNombre(String nombre) { this.nombre = nombre; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public Role getRol() { return rol; }
 * 
 * public void setRol(Role rol) { this.rol = rol; }
 * 
 * 
 * public Unidad getUnidad() { return unidad; }
 * 
 * public void setUnidad(Unidad unidad) { this.unidad = unidad; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */