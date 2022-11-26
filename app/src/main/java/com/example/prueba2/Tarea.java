package com.example.prueba2;

import java.io.Serializable;

// Genera Class Tarea,       // Serializable para facil compatido datos
public class Tarea implements Serializable {
    // valiable
    private String titulo;
    private String descripcion;

    // modificar Forma de String, ejemplo: Item1  Sub item1
    public String toString() {
        return titulo + "\n" + descripcion;
    }

    //Obtener titulo
    public String getTitulo() {
        return titulo;
    }

    // Modificar Titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Obtener Descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Modificar Descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}

