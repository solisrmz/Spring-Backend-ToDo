/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.clases;

import com.example.todo.Models.Tarea;

public class TareaMotivo {
    private Tarea tarea;
    private String nombreMotivo;

    public TareaMotivo(Tarea tarea, String nombreMotivo) {
        this.tarea = tarea;
        this.nombreMotivo = nombreMotivo;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public void setNombreMotivo(String nombreMotivo) {
        this.nombreMotivo = nombreMotivo;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public String getNombreMotivo() {
        return nombreMotivo;
    }
}
