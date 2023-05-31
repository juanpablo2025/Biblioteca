package com.example.Biblioteca.Servicios;

import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Repositorios.RepositorioAutor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ServicioAutor implements ServicioBase<Autor> {

    @Autowired
    protected RepositorioAutor repositorioAutor;

    @Override
    public List<Autor> buscarTodos() throws Exception {
        try {
            List<Autor> autor = repositorioAutor.findAll();
            return autor;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    @Override
    public Autor buscarPorId(Integer id) throws Exception {
        try {
            Optional<Autor> autorOpcional = repositorioAutor.findById(id);
            if (autorOpcional.isPresent()) {
                return autorOpcional.get();
            } else {
                throw new Exception("Autor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor registrar(Autor datosARegistrar) throws Exception {
        try {

            Autor autorGuardado = repositorioAutor.save(datosARegistrar);
            return autorGuardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor actualizar(Integer id, Autor datosNuevos) throws Exception {
        try {
            Optional<Autor> autorOptional = repositorioAutor.findById(id);
            if (autorOptional.isPresent()) {
                Autor autorExistente = autorOptional.get();
                autorExistente.setNombre(datosNuevos.getNombre());
                autorExistente.setApellido(datosNuevos.getApellido());
                autorExistente.setPseudonimo(datosNuevos.getPseudonimo());
                autorExistente.setEmail(datosNuevos.getEmail());
                autorExistente.setNacionalidad(datosNuevos.getNacionalidad());
                Autor autorActualizado = repositorioAutor.save(autorExistente);
                return autorActualizado;
            } else {
                throw new Exception("Autor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Autor> autorOptional = repositorioAutor.findById(id);
            if (autorOptional.isPresent()) {
                repositorioAutor.deleteById(id);
                return true;
            } else {
                throw new Exception("Autor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
