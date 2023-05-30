package com.example.Biblioteca.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.Entidades.Categoria;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Integer> {

}
