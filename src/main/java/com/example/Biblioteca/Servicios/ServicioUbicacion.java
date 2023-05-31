package com.example.Biblioteca.Servicios;

import com.example.Biblioteca.Entidades.Ubicacion;
import com.example.Biblioteca.Repositorios.RepositorioUbicacion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicioUbicacion implements ServicioBase<Ubicacion>{

    @Autowired
    protected RepositorioUbicacion repositorioUbicacion;
    @Override
    public List<Ubicacion> buscarTodos() throws Exception {
        try {
            List<Ubicacion> ubicacion = repositorioUbicacion.findAll();
            return ubicacion;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Ubicacion buscarPorId(Integer id) throws Exception {
        try {
            Optional<Ubicacion> autorOpcional = repositorioUbicacion.findById(id);
            if (autorOpcional.isPresent()) {
                return autorOpcional.get();
            } else {
                throw new Exception("Ubicacion no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Ubicacion registrar(Ubicacion datosARegistrar) throws Exception {
        try {

            Ubicacion ubicacionGuardado = repositorioUbicacion.save(datosARegistrar);
            return ubicacionGuardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Ubicacion actualizar(Integer id, Ubicacion datosNuevos) throws Exception {
        try {
            Optional<Ubicacion> autorOptional = repositorioUbicacion.findById(id);
            if (autorOptional.isPresent()) {
                Ubicacion autorExistente = autorOptional.get();
                autorExistente.setEstante(datosNuevos.getEstante());
                autorExistente.setPiso(datosNuevos.getPiso());
                autorExistente.setSalon(datosNuevos.getSalon());

                Ubicacion autorActualizado = repositorioUbicacion.save(autorExistente);
                return autorActualizado;
            } else {
                throw new Exception("Ubicacion no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Ubicacion> ubicacionOptional = repositorioUbicacion.findById(id);
            if (ubicacionOptional.isPresent()) {
                repositorioUbicacion.deleteById(id);
                return true;
            } else {
                throw new Exception("Ubicacion no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
