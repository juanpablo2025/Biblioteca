package com.example.Biblioteca.Servicios;

import com.example.Biblioteca.Entidades.Categoria;
import com.example.Biblioteca.Repositorios.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicioCategoria implements ServicioBase<Categoria>{

    @Autowired
    protected RepositorioCategoria repositorioCategoria;
    @Override
    public List<Categoria> buscarTodos() throws Exception {
        try {
            List<Categoria> categoria = repositorioCategoria.findAll();
            return categoria;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria buscarPorId(Integer id) throws Exception {
        try {
            Optional<Categoria> categoriaOpcional = repositorioCategoria.findById(id);
            if (categoriaOpcional.isPresent()) {
                return categoriaOpcional.get();
            } else {
                throw new Exception("Categoria no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria registrar(Categoria datosARegistrar) throws Exception {
        try {

            Categoria categoriaGuardado = repositorioCategoria.save(datosARegistrar);
            return categoriaGuardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria actualizar(Integer id, Categoria datosNuevos) throws Exception {
        try {
            Optional<Categoria> autorOptional = repositorioCategoria.findById(id);
            if (autorOptional.isPresent()) {
                Categoria categoriaExistente = autorOptional.get();
               categoriaExistente.setNombre(datosNuevos.getNombre());
                categoriaExistente.setDescripcion(datosNuevos.getDescripcion());

                Categoria categoriaActualizado = repositorioCategoria.save(categoriaExistente);
                return categoriaActualizado;
            } else {
                throw new Exception("Categoria no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Categoria> categoriaOptional = repositorioCategoria.findById(id);
            if (categoriaOptional.isPresent()) {
                repositorioCategoria.deleteById(id);
                return true;
            } else {
                throw new Exception("Categoria no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    }

