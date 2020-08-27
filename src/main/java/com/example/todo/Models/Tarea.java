/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Models;

import javax.persistence.*;

/**
 *
 * @author José A Solís
 */
@Entity
@Table(name = "tareas")
public class Tarea {

    private long id;
    private String nombre;
    private String descripcion;
 
    public Tarea() {
  
    }
 
    public Tarea(String nombre, String descripcion) {
         this.nombre = nombre;
         this.descripcion = descripcion;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "nombre", nullable = false)
    public String getName() {
        return nombre;
    }
    public void setName(String nombre) {
        this.nombre = nombre;
    }
 
    @Column(name = "descripcion", nullable = false)
    public String getDescription() {
        return descripcion;
    }
    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }
 
    @Override
    public String toString() {
        return "Tarea [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion 
        + "]";
    }
 
}