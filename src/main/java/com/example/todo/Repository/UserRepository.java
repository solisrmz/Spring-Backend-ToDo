/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Repository;

import com.example.todo.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author José A Solís
 */
public interface UserRepository extends JpaRepository<Usuario, Long>{
    public Usuario findByNombre(String nombre);
}
