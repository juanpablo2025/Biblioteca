package com.example.Biblioteca.Controladores;

import com.example.Biblioteca.Entidades.Editorial;
import com.example.Biblioteca.Servicios.ServicioEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/editorial")
public class ControladorEditorial {
    @Autowired
    protected ServicioEditorial servicioEditorial;

    @PostMapping
    public ResponseEntity<Editorial> registrar(@RequestBody Editorial datosARegistrar){
        try{
            Editorial estudianteRegistrado=servicioEditorial.registrar(datosARegistrar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(estudianteRegistrado);

        }catch(Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
    @GetMapping
    public ResponseEntity<List<Editorial>>buscarTodos(){
        try{
            List<Editorial> editoriales = ServicioEditorial.buscarTodos();
        }

    }



}
