package com.example.Biblioteca.Controladores;


import com.example.Biblioteca.Entidades.Autor;
import com.example.Biblioteca.Servicios.ServicioAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/autores")
public class ControladorAutor {
    @Autowired
    protected ServicioAutor servicioAutor;

    @PostMapping
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
            List<Autor> autores = ServicioAutor.buscarTodos();
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
            Autor autorEncontrado=ServicioAutor.buscarPorId(id);
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
