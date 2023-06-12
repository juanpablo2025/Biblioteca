package com.example.Biblioteca.Controladores;

import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Entidades.Categoria;
import com.example.Biblioteca.Servicios.ServicioAutor;
import com.example.Biblioteca.Servicios.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/categorias")

public class ControladorCategoria {


        @Autowired
        protected ServicioCategoria servicioCategoria;

        @PostMapping
        public ResponseEntity<Categoria> registrar(@RequestBody Categoria datosAGuardar){
            try {
                Categoria categoriaRegistrado=servicioCategoria.registrar(datosAGuardar);
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(categoriaRegistrado);
            }catch(Exception error){
                String mensaje="Error al registrar"+error.getMessage();
                Categoria categoriaConError = new Categoria();
                categoriaConError.setMensajeError(mensaje);
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(categoriaConError);
            }
        }

        @GetMapping
        public ResponseEntity<List<Categoria>>buscarTodos(){
            try{
                List<Categoria> autores = servicioCategoria.buscarTodos();
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(autores);
            }catch(Exception error){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);

            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<Categoria>buscarPorId(@PathVariable Integer id){
            try{
                Categoria categoriaEncontrada=servicioCategoria.buscarPorId(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(categoriaEncontrada);
            }catch(Exception error){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        }


    }

