package com.example.Biblioteca.Servicios;



import com.example.Biblioteca.Entidades.Pais;
import com.example.Biblioteca.Entidades.Ubicacion;
import com.example.Biblioteca.Repositorios.RepositorioPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServicioPais implements ServicioBase<Pais>{

   @Autowired
    protected RepositorioPais repositorioPais;

    @Override
    public List<Pais> buscarTodos() throws Exception {
        try {
            List<Pais> pais = repositorioPais.findAll();
            return pais;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Pais buscarPorId(Integer id) throws Exception {
        try {
            Optional<Pais> paisOpcional = repositorioPais.findById(id);
            if (paisOpcional.isPresent()) {
                return paisOpcional.get();
            } else {
                throw new Exception("Ubicacion no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Pais registrar(Pais datosARegistrar) throws Exception {
        try {

            Pais paisGuardado = repositorioPais.save(datosARegistrar);
            return paisGuardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Pais actualizar(Integer id, Pais datosNuevos) throws Exception {
        try {
            Optional<Pais> paisOptional = repositorioPais.findById(id);
            if (paisOptional.isPresent()) {
                Pais paisExistente = paisOptional.get();
                paisExistente.setNombre(datosNuevos.getNombre());



                Pais paisActualizado = repositorioPais.save(paisExistente);
                return paisActualizado;
            } else {
                throw new Exception("pais no encontrad");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
