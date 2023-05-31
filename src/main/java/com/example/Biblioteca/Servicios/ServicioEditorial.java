package com.example.Biblioteca.Servicios;

import com.example.Biblioteca.Entidades.Editorial;
import com.example.Biblioteca.Repositorios.RepositorioEditorial;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicioEditorial implements ServicioBase<Editorial> {

    @Autowired
    protected RepositorioEditorial repositorioEditorial;

    @Override
    public List<Editorial> buscarTodos() throws Exception {
        try {
            List<Editorial> editorial = repositorioEditorial.findAll();
            return editorial;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Editorial buscarPorId(Integer id) throws Exception {
        try {
            Optional<Editorial> editorialOpcional = repositorioEditorial.findById(id);
            if (editorialOpcional.isPresent()) {
                return editorialOpcional.get();
            } else {
                throw new Exception("Editorial no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Editorial registrar(Editorial datosARegistrar) throws Exception {
        try {

            Editorial editorialGuardado = repositorioEditorial.save(datosARegistrar);
            return editorialGuardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Editorial actualizar(Integer id, Editorial datosNuevos) throws Exception {
        try {
            Optional<Editorial> autorOptional = repositorioEditorial.findById(id);
            if (autorOptional.isPresent()) {
                Editorial editorialExistente = autorOptional.get();
                editorialExistente.setNombre(datosNuevos.getNombre());
                editorialExistente.setDescription(datosNuevos.getDescription());

                Editorial editorialActualizado = repositorioEditorial.save(editorialExistente);
                return editorialActualizado;
            } else {
                throw new Exception("Editorial no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Editorial> autorOptional = repositorioEditorial.findById(id);
            if (autorOptional.isPresent()) {
                repositorioEditorial.deleteById(id);
                return true;
            } else {
                throw new Exception("Editorial no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


}
