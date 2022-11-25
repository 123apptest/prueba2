package com.example.prueba2;

import java.io.Serializable;

public class Tarea implements Serializable {
    private String titulo;
    private String descripcion;


    public String toString() {
        return titulo + "\n" + descripcion;
    }
    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
