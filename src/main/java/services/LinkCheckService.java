/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import connection.DBConnection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ClientModel;
import models.LinkCheckModel;
import models.UserModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ikaraz
 */
public class LinkCheckService {
    private static String CONNECTION_URL = "http://localhost:8080";
    
    public static List<LinkCheckModel> findAllByUserId(UserModel user, DBConnection conn){        
        JSONArray jsonResponse = new JSONArray(conn.request(CONNECTION_URL + "/users/" + user.getId() + "/linkcheck", "GET", ""));
        return parseJson(jsonResponse);        
    }
    
    public static List<LinkCheckModel> findAllByClientId(ClientModel client, DBConnection conn){
        JSONArray jsonResponse = new JSONArray(conn.request(CONNECTION_URL + "/clients/" + client.getId() + "/linkcheck", "GET", ""));
        return parseJson(jsonResponse);
    }
    
    public static List<LinkCheckModel> findAll(DBConnection conn){
        JSONArray jsonResponse = new JSONArray(conn.request(CONNECTION_URL + "/linkcheck", "GET", ""));
        return parseJson(jsonResponse);
    }
    
    public static LinkCheckModel saveOne(UserModel user, ClientModel client, LinkCheckModel link, DBConnection conn){
        String requestBody = "{"
                + "\"id\": " + link.getId() + ","
                + "\"url\": \"" + link.getUrl() + "\","
                + "\"status\": \"" + link.getStatus() + "\","
                + "\"vremeProvere\": \"" + link.getVremeProvere() + "\""
                + "}";
        JSONObject jsonResponse = new JSONObject(conn.request(CONNECTION_URL + "/users/" + user.getId() + "/clients/" + client.getId() + "/linkcheck", "POST", requestBody));
        JSONArray a = new JSONArray();
        a.put(jsonResponse);
        List<LinkCheckModel> list = parseJson(a);
        return list.get(0);        
    }
    
    public static void deleteById(long id, DBConnection conn){
        conn.request(CONNECTION_URL + "/linkcheck/" + id, "DELETE", "");
    }
    
    private static List<LinkCheckModel> parseJson(JSONArray jsonResponse){
        List<LinkCheckModel> list = new ArrayList<>();
        JSONObject klijent;
        JSONObject korisnik;
        for(int i=0;i<jsonResponse.length();i++){
            JSONObject o = jsonResponse.getJSONObject(i);
            klijent = o.getJSONObject("klijent");
            korisnik = o.getJSONObject("korisnik");
            list.add(new LinkCheckModel(o.getLong("id"),
                    o.getString("status"),
                    o.getString("url"),
                    o.getString("vremeProvere"),
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
                            korisnik.getString("uiTema"))));

        }
        return list;
    }
}
