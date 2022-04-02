/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author ikaraz
 */
public class ClientModel {
    private Long id;
    private String email;
    private String kontaktOsoba;
    private String napomena;
    private String vremeIzmene;

    public ClientModel(Long id, String email, String kontaktOsoba, String napomena, String vremeIzmene) {
        this.id = id;
        this.email = email;
        this.kontaktOsoba = kontaktOsoba;
        this.napomena = napomena;
        this.vremeIzmene = vremeIzmene;
    }

    public ClientModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getVremeIzmene() {
        return vremeIzmene;
    }

    public void setVremeIzmene(String vremeIzmene) {
        this.vremeIzmene = vremeIzmene;
    }
    
    
    
    
}
