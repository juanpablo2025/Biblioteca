package com.example.Biblioteca.Validaciones;

public class ValidacionesAutor {

    public static boolean NombreOPseudonimo(String nombre,String apellido,String pseudonimo){
        return(pseudonimo == null &&(nombre == null||apellido==null));
    }

}
