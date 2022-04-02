/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author ikaraz
 */
public class LinkCheckModel {
    private Long id;
    private String status;
    private String url;
    private String vremeProvere;
    private ClientModel klijent;
    private UserModel korisnik;

    public LinkCheckModel(Long id, String status, String url, String vremeProvere, ClientModel klijent, UserModel korisnik) {
        this.id = id;
        this.status = status;
        this.url = url;
        this.vremeProvere = vremeProvere;
        this.klijent = klijent;
        this.korisnik = korisnik;
        
    }

    public LinkCheckModel() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVremeProvere() {
        return vremeProvere;
    }

    public void setVremeProvere(String vremeProvere) {
        this.vremeProvere = vremeProvere;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final LinkCheckModel other = (LinkCheckModel) obj;
        return Objects.equals(this.id, other.id);
    }
 
    
    
}
