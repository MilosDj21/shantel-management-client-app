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
public class RequestModel {
    private long id;
    private String napomena;
    private boolean novaProvera;
    private String status;
    private Timestamp vremeKreiranja;
    private UserModel korisnik;

    public RequestModel(long id, String napomena, boolean novaProvera, String status, Timestamp vremeKreiranja, UserModel korisnik) {
        this.id = id;
        this.napomena = napomena;
        this.novaProvera = novaProvera;
        this.status = status;
        this.vremeKreiranja = vremeKreiranja;
        this.korisnik = korisnik;
    }

    public RequestModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public boolean isNovaProvera() {
        return novaProvera;
    }

    public void setNovaProvera(boolean novaProvera) {
        this.novaProvera = novaProvera;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(Timestamp vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    public UserModel getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(UserModel korisnik) {
        this.korisnik = korisnik;
    }
    
    
}
