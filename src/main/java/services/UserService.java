/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import connection.DBConnection;
import models.UserModel;
import org.json.JSONObject;

/**
 *
 * @author ikaraz
 */
public class UserService {
    
    private static String CONNECTION_URL = "http://localhost:8080";
    
    public static UserModel login(UserModel user, DBConnection conn){
        String requestBody = "{ "
                + "\"username\": \"" + user.getUsername() + "\","
                + "\"password\": \"" + user.getPassword() + "\""
                + "}";
        String response = conn.request(CONNECTION_URL + "/login", "POST", requestBody);
        if(response.isEmpty()){
            return null;
        }
        JSONObject jsonResponse = new JSONObject(response);
        return parseJson(jsonResponse);        
    }
    
    public static UserModel saveOne(UserModel user, DBConnection conn){
        String requestBody = "{"
                + "\"id\": " + user.getId() + ","
                + "\"username\": \"" + user.getUsername() + "\","
                + "\"password\": \"" + user.getPassword() + "\","
                + "\"ime\": \"" + user.getIme() + "\","
                + "\"prezime\": \"" + user.getPrezime() + "\","
                + "\"status\": \"" + user.getStatus() + "\","
                + "\"uiTema\": \"" + user.getUiTema() + "\""
                + "}";
        JSONObject jsonResponse = new JSONObject(conn.request(CONNECTION_URL + "/users", "POST", requestBody));
        return parseJson(jsonResponse);
        
    }

    public static void deleteOne(long id, DBConnection conn){
        conn.request(CONNECTION_URL + "/users/" + id, "DELETE", "");
    }
    
    private static UserModel parseJson(JSONObject jsonResponse){
        UserModel user = new UserModel();
        user.setId(jsonResponse.getLong("id"));  
        user.setUsername(jsonResponse.getString("username"));
        user.setPassword(jsonResponse.getString("password"));
        user.setIme(jsonResponse.getString("ime"));
        user.setPrezime(jsonResponse.getString("prezime"));
        user.setStatus(jsonResponse.getString("status"));
        user.setUiTema(jsonResponse.getString("uiTema")); 
        return user;
    }
}
