/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import connection.DBConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.UserModel;
import org.json.JSONArray;

/**
 *
 * @author ikaraz
 */
public class UserService {
    
    private static String CONNECTION_URL = "http://localhost:8080";
    
    public void login(UserModel user, DBConnection conn){
        String requestBody = "{ "
                + "\"username\": \"" + user.getUsername() + "\","
                + "\"password\": \"" + user.getPassword() + "\""
                + "}";
        readJson(CONNECTION_URL + "/login", requestBody, "POST", conn);
    }
    
    public String saveNew(UserModel user){
        return "{ "
                + "username: " + user.getUsername() + ","
                + "password: " + user.getPassword() + ","
                + "ime: " + user.getIme() + ","
                + "prezime: " + user.getPrezime() + ","
                + "status: " + user.getStatus() + ","
                + "uiTema: " + user.getUiTema()
                + "}";
    }
    
    public String updateUser(UserModel user){
        return "{ "
                + "id: " + user.getId() + ","
                + "username: " + user.getUsername() + ","
                + "password: " + user.getPassword() + ","
                + "ime: " + user.getIme() + ","
                + "prezime: " + user.getPrezime() + ","
                + "status: " + user.getStatus() + ","
                + "uiTema: " + user.getUiTema()
                + "}";
    }
    
    private void readJson(String url, String requestBody, String methodType, DBConnection conn){
        String jsonResponse = conn.request(url, methodType, requestBody);
        
        System.out.println(jsonResponse);
    }
    
}
