package com.example.Biblioteca.Entidades;

import jakarta.persistence.*;

@Entity

@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nombre", unique = true)
	private String nombre;

	@Column(name = "Description",length = 100)
	private String descripcion;

	@Transient
	private String mensajeError;

	public Categoria(Integer id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

    public Categoria() {

    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
