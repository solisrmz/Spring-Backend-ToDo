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
@Table(name="users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "password", nullable = false)
    private String pass;
    
    public Usuario(){
        
    }

    public Usuario(long id, String nombre, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String pass) {
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + pass + '}';
    }
    
    
}
