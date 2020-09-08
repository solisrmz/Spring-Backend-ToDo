/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.clases;

/**
 *
 * @author José A Solís
 */
public class TokenUsuario {
    private String token;
    private int id;
    private String username;

    public TokenUsuario(String token, String username) {
        this.token = token;
        this.id = id;
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "TokenUsuario{" + "token=" + token + ", id=" + id + ", username=" + username + '}';
    }
    
    
}
