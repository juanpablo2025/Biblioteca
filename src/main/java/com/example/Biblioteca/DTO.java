package com.example.Biblioteca;

public class DTO /*EL DTO contiene las propiedades del objeto. Datos que pueden tener su origen en una o más entidades de información. Estos datos son incorporados a una instancia de un JavaBean.*/{

    private String Nombre;
    private String Apellido;
    private String Pseudonimo;

    private String email;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getPseudonimo() {
        return Pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        Pseudonimo = pseudonimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
