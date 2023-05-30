package com.example.Biblioteca.Servicios;

import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Repositorios.RepositorioAutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicioAutor implements ServicioBase<Autor>{


    @Autowired
    protected RepositorioAutor repositorioAutor;

    @Override
    public List<Autor> buscarTodos() throws Exception{
        try{
            List<Autor> autor=repositorioAutor.findAll();
            return autor;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }

    @Override
    public Autor buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Autor registrar(Autor datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Autor actualizar(Integer id, Autor datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }


}
