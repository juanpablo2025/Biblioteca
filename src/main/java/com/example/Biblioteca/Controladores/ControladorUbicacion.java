package com.example.Biblioteca.Controladores;


import com.example.Biblioteca.Entidades.Ubicacion;
import com.example.Biblioteca.Servicios.ServicioUbicacion;
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
@RequestMapping("api/v1/Ubicaciones")
@Tag(name="Servicio Ubicaciones",description = "CRUD para la entidad Ubicacion")
public class ControladorUbicacion {
    @Autowired(required=true)
    protected ServicioUbicacion servicioUbicacion;

    @PostMapping
    @Operation(summary = "Registra un estudiante en la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Estudiante fue creado con exito"),
            @ApiResponse(responseCode = "400", description = "Fallamos en el registro, revise su peticion")
    })
    public ResponseEntity<Ubicacion> registrar(@RequestBody Ubicacion datosAGuardar){
        try {
            Ubicacion ubicacionRegistrado=servicioUbicacion.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ubicacionRegistrado);
        }catch(Exception error){
            String mensaje="Error al registrar"+error.getMessage();
            Ubicacion ubicacionConError = new Ubicacion();
            ubicacionConError.setMensajeError(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ubicacionConError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ubicacion>>buscarTodos(){
        try{
            List<Ubicacion> ubicaciones = servicioUbicacion.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicaciones);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion>buscarPorId(@PathVariable Integer id){
        try{
            Ubicacion ubicacionEncontrado=servicioUbicacion.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicacionEncontrado);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
