package com.example.Biblioteca.Controladores;


import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Entidades.Editorial;
import com.example.Biblioteca.Servicios.ServicioEditorial;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/editorial")
@Tag(name="Servicio Editoriales",description = "CRUD Para la entidad editorial")
public class ControladorEditorial {
    @Autowired
    protected ServicioEditorial servicioEditorial;

    @PostMapping
    @Operation(summary = "Registra un Editorial en la BD")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "201", description = "Autor fue creado con exito"),
            @ApiResponse(responseCode = "400", description = "error al crear el autor")
    })
    public ResponseEntity<Editorial> registrar(@RequestBody Editorial datosAGuardar){
        try {
            Editorial editorialRegistrado=servicioEditorial.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(editorialRegistrado);
        }catch(Exception error){
            String mensaje="Error al registrar"+error.getMessage();
            Editorial editorialConError = new Editorial();
            editorialConError.setMensajeError(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(editorialConError);
        }
    }
    @GetMapping
    public ResponseEntity<List<Editorial>>buscarTodos(){
        try{
            List<Editorial> editoriales = servicioEditorial.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editoriales);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial>buscarPorId(@PathVariable Integer id){
        try{
            Editorial editorialEncontrada= servicioEditorial.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editorialEncontrada);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }




}
