package com.example.Biblioteca.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.Entidades.Ubicacion;

@Repository
public interface RepositorioUbicacion extends JpaRepository<Ubicacion, Integer> {

}
