package com.example.Biblioteca.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Biblioteca.Entidades.Editorial;

@Repository
public interface RepositorioEditorial extends JpaRepository<Editorial, Integer>{
}
