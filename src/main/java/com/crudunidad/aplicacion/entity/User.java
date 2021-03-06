package com.crudunidad.aplicacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

		private static final long serialVersionUID = -5700891922787154209L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 50)
	private Long id;
	
	@Column(length = 50)
	private String nombre;

	@Column(length = 50)
	private String clave;

	@Column(length = 50)
	private String email;

	@Column(length = 50)
	private Boolean estado;

	public User() {
		super();
	}

	public User(String nombre, String clave, String email, Boolean estado) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.email = email;
		this.estado = estado;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "mail", nullable=false, length = 50, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
