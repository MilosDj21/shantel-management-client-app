/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Objects;

/**
 *
 * @author ikaraz
 */
public class UserModel {
    public static UserModel CURRENT_USER = null;
    
    private Long id;
    private String status;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String uiTema;

    public UserModel(){
        
    }
    
    public UserModel(Long id, String status, String ime, String prezime, String username, String password, String uiTema) {
        this.id = id;
        this.status = status;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.uiTema = uiTema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUiTema() {
        return uiTema;
    }

    public void setUiTema(String uiTema) {
        this.uiTema = uiTema;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserModel other = (UserModel) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
}
