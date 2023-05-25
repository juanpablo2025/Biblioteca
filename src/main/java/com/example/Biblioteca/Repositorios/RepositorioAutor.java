package com.example.Biblioteca.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Biblioteca.Entidades.Autor;

@Repository
public interface RepositorioAutor extends JpaRepository<Autor,Integer> {
}
