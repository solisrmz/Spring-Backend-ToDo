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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @JoinColumn(name = "id_motivo", referencedColumnName = "id_motivo")
    @ManyToOne(optional = false)
    private Motivo id_motivo;
 
    public Tarea() {
  
    }
 
    public Tarea(String nombre, String descripcion) {
         this.nombre = nombre;
         this.descripcion = descripcion;
    }
 
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    
    public String getName() {
        return nombre;
    }
    public void setName(String nombre) {
        this.nombre = nombre;
    }
 
    public String getDescription() {
        return descripcion;
    }
    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public void setId_motivo(Motivo id_motivo) {
        this.id_motivo = id_motivo;
    }

    public Motivo getId_motivo() {
        return id_motivo;
    }
 
    @Override
    public String toString() {
        return "Tarea [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion 
        + "]";
    }

}