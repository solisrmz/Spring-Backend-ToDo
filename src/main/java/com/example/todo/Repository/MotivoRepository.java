/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Repository;

import com.example.todo.Models.Motivo;
import com.example.todo.Models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author José A Solís
 */
public interface MotivoRepository extends JpaRepository<Motivo, String>{
    public Motivo findByNombre(String nombre);
}
