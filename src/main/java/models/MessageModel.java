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
public class MessageModel implements Comparable<MessageModel>{
    private Long id;
    private String poruka;
    private String status;
    private String vremePoruke;
    private LinkCheckModel linkZaProveru;

    public MessageModel(Long id, String poruka, String status, String vremePoruke, LinkCheckModel linkZaProveru) {
        this.id = id;
        this.poruka = poruka;
        this.status = status;
        this.vremePoruke = vremePoruke;
        this.linkZaProveru = linkZaProveru;
    }

    public MessageModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVremePoruke() {
        return vremePoruke;
    }

    public void setVremePoruke(String vremePoruke) {
        this.vremePoruke = vremePoruke;
    }

    public LinkCheckModel getLinkZaProveru() {
        return linkZaProveru;
    }

    public void setLinkZaProveru(LinkCheckModel linkZaProveru) {
        this.linkZaProveru = linkZaProveru;
    }

    @Override
    public int compareTo(MessageModel t) {
        Timestamp thisObj = Timestamp.valueOf(this.getVremePoruke());
        Timestamp other = Timestamp.valueOf(t.getVremePoruke());
        
        if(thisObj.after(other)){
            return 1;
        }else if(thisObj.before(other)){
            return -1;
        }
        return 0;
    }

    
}
