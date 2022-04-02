/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import connection.DBConnection;
import java.util.ArrayList;
import java.util.List;
import models.ClientModel;
import models.LinkCheckModel;
import models.MessageModel;
import models.UserModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ikaraz
 */
public class MessageService {
    private static String CONNECTION_URL = "http://localhost:8080";
    
    public static List<MessageModel> findAll(DBConnection conn){
        JSONArray jsonResponse = new JSONArray(conn.request(CONNECTION_URL + "/messages", "GET", ""));
        return parseJson(jsonResponse);        
    }
    
    public static List<MessageModel> findAllByLinkCheckId(LinkCheckModel link, DBConnection conn){
        JSONArray jsonResponse = new JSONArray(conn.request(CONNECTION_URL + "/linkcheck/" + link.getId() + "/messages", "GET", ""));
        return parseJson(jsonResponse);
    }
    
    public static MessageModel saveOne(LinkCheckModel link, MessageModel message, DBConnection conn){
        String requestBody = "{"
                + "\"id\": " + message.getId() + ","
                + "\"poruka\": \"" + message.getPoruka() + "\","
                + "\"status\": \"" + message.getStatus() + "\","
                + "\"vremePoruke\": \"" + message.getVremePoruke() + "\""
                + "}";
        JSONObject jsonResponse = new JSONObject(conn.request(CONNECTION_URL + "/linkcheck/" + link.getId() + "/messages", "POST", requestBody));
        JSONArray array = new JSONArray();
        array.put(jsonResponse);
        return parseJson(array).get(0);
    }
    
    public static void deleteOne(long id, DBConnection conn){
        conn.request(CONNECTION_URL + "/messages/" + id, "DELETE", "");
    }
    
    private static List<MessageModel> parseJson(JSONArray jsonResponse){
        List<MessageModel> list = new ArrayList<>();
        JSONObject klijent;
        JSONObject korisnik;
        JSONObject linkZaProveru;
        for(int i=0;i<jsonResponse.length();i++){
            JSONObject o = jsonResponse.getJSONObject(i);
            linkZaProveru = o.getJSONObject("linkZaProveru");
            klijent = linkZaProveru.getJSONObject("klijent");
            korisnik = linkZaProveru.getJSONObject("korisnik");
            list.add(new MessageModel(o.getLong("id"),
                        o.getString("poruka"),
                        o.getString("status"),
                        o.getString("vremePoruke"),
                        new LinkCheckModel(linkZaProveru.getLong("id"),
                            linkZaProveru.getString("status"),
                            linkZaProveru.getString("url"),
                            linkZaProveru.getString("vremeProvere"),
                            new ClientModel(klijent.getLong("id"),
                                klijent.getString("kontaktOsoba"),
                                klijent.getString("email"),
                                klijent.getString("kontaktOsoba"),
                                klijent.getString("vremeIzmene")),
                            new UserModel(korisnik.getLong("id"),
                                korisnik.getString("status"),
                                korisnik.getString("ime"),
                                korisnik.getString("prezime"),
                                korisnik.getString("username"),
                                korisnik.getString("password"),
                                korisnik.getString("uiTema")))));
        }
        return list;
    }
}
