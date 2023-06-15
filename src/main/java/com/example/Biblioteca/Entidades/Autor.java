package com.example.Biblioteca.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity/*entidades persistentes se identifican mediante la anotación*/
@Table(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*Para generar los valores de una clave primaria, es decir, que los genere JPA automáticamente*/
    private Integer id;
    @Column(name = "Nombre", unique = true)

    private String nombre;

    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Pseudonimo", unique = true)
    private String pseudonimo;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Nacionalidad",nullable = false)
    @JsonBackReference
    private Pais nacionalidad;

    @Column(name = "Email")
    @Email
    private String email;

    @Transient/*se utiliza para indicarle a JPA que un atributo de una Entidad no debe de ser persistente*/
    private String mensajeError;



    public Autor() {
    }

    public Autor(Integer id, String nombre, String apellido, String pseudonimo, Pais nacionalidad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pseudonimo = pseudonimo;
        this.nacionalidad = nacionalidad;
        this.email = email;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
