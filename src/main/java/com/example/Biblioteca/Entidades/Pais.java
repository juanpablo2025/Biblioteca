package com.example.Biblioteca.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name ="nombre",unique = true)
    private String nombre;

    @OneToMany(mappedBy = "nacionalidad")
    private List<Autor> autor;

    public Pais() {
    }

    public Pais(Integer id, String nombre, List<Autor> autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
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

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }
}
