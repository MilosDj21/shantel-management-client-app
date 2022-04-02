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
public class LinkModel {
    private Long id;
    private Double cena;
    private String url;
    private String vremePlacanja;
    private ClientModel klijent;
    private UserModel korisnik;

    public LinkModel(Long id, Double cena, String url, String vremePlacanja, ClientModel klijent, UserModel korisnik) {
        this.id = id;
        this.cena = cena;
        this.url = url;
        this.vremePlacanja = vremePlacanja;
        this.klijent = klijent;
        this.korisnik = korisnik;
    }

    public LinkModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVremePlacanja() {
        return vremePlacanja;
    }

    public void setVremePlacanja(String vremePlacanja) {
        this.vremePlacanja = vremePlacanja;
    }

    public ClientModel getKlijent() {
        return klijent;
    }

    public void setKlijent(ClientModel klijent) {
        this.klijent = klijent;
    }

    public UserModel getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(UserModel korisnik) {
        this.korisnik = korisnik;
    }
    
    
    
}
