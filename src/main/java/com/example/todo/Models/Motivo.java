/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Models;

import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author José A Solís
 */
@Entity
@Table(name = "motivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivo.findByNombre", query = "SELECT e FROM Motivo e WHERE e.nombre = :nombre"),
})
public class Motivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_motivo")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_motivo")
    private Collection<Tarea> tarea;

    public Motivo(String nombre) {
        this.nombre = nombre;
    }
    
    public Motivo(){
        
    }
    
    public Motivo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuario(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Motivo{" + "id=" + id + ", usuario=" + nombre + '}';
    }
}
