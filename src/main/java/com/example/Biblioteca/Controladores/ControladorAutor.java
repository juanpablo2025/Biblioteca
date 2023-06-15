package com.example.Biblioteca.Controladores;


import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Servicios.ServicioAutor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController/*es un tipo de controller que reciben peticiones con un formato de específico que cumple con formatos de solicitud RESTful habitualmente y mayormente en JSON , aunque a veces se usan otros como HTML, XML, o simplemente texto.*/
@RequestMapping("api/v1/autores")/*se utiliza para asignar solicitudes web a clases de controlador específicas y/o métodos de controlador.*/
@Tag(name="Servicio Autores",description ="CRUD de la entidad Autor")
public class ControladorAutor {
   @Autowired/*nos proporciona control a la hora de querer inyectar nuestras dependencias o instancias que se almacenan en el contexto de Spring.*/
    protected ServicioAutor servicioAutor;

    @PostMapping/*es una anotación compuesta que actúa como un acceso directo para @RequestMapping*/
    @Operation(summary = "Registra un Autor en la BD")
    @ApiResponses(value= {/*anotaciones swagger*/
            @ApiResponse(responseCode = "201", description = "Autor fue creado con exito"),
            @ApiResponse(responseCode = "400", description = "error al crear el autor")
    })
    public ResponseEntity<Autor> registrar(@RequestBody Autor datosAGuardar){
    try {
        Autor autorRegistrado=servicioAutor.registrar(datosAGuardar);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(autorRegistrado);
    }catch(Exception error){
        String mensaje="Error al registrar"+error.getMessage();
        Autor autorConError = new Autor();
        autorConError.setMensajeError(mensaje);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(autorConError);
    }
    }

    @GetMapping
    public ResponseEntity<List<Autor>>buscarTodos(){
        try{
            List<Autor> autores = servicioAutor.buscarTodos();
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
    public ResponseEntity<Autor>buscarPorId(@PathVariable Integer id){
        try{
            Autor autorEncontrado=servicioAutor.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorEncontrado);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }



}
