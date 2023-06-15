package com.example.Biblioteca.Controladores;

import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Entidades.Pais;

import com.example.Biblioteca.Servicios.ServicioPais;
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
@RequestMapping("api/v1/paises")
@Tag(name="Servicio Paises",description ="CRUD de la entidad Autor")
public class ControladorPais {

    @Autowired(required=true)
    protected ServicioPais servicioPais;

    @PostMapping
    @Operation(summary = "Registra un Pais en la BD")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "201", description = "pais fue creado con exito"),
            @ApiResponse(responseCode = "400", description = "error al crear el pais")
    })
    public ResponseEntity<Pais> registrar(@RequestBody Pais datosAGuardar){
        try {
            Pais paisRegistrado=servicioPais.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(paisRegistrado);
        }catch(Exception error){
            String mensaje="Error al registrar"+error.getMessage();
            Pais paisConError = new Pais();
            paisConError.setMensajeError(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(paisConError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pais>>buscarTodos(){
        try{
            List<Pais> paises = servicioPais.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paises);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais>buscarPorId(@PathVariable Integer id){
        try{
            Pais paisEncontrado=servicioPais.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisEncontrado);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
