/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author ikaraz
 */
public class DBConnection {
    
    private String authUsername;
    private String authPassword;

    public DBConnection() {
    }

    public DBConnection(String authUsername, String authPassword) {
        this.authUsername = authUsername;
        this.authPassword = authPassword;
    }
    
    
    public String request(String url, String methodType, String requestBody){
        String jsonResponse = null;
        try{
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if(authUsername != null && authPassword != null){
                String encoded = Base64.getEncoder().encodeToString((authUsername + ":" + authPassword).getBytes("UTF-8"));
                conn.setRequestProperty("Authorization", "Basic " + encoded);
            }
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod(methodType);
            
            if(methodType.equals("POST") || methodType.equals("PUT")){
                OutputStream os = conn.getOutputStream();
                os.write(requestBody.getBytes("UTF-8"));
                os.close();
            }
            InputStream is = conn.getInputStream();
            jsonResponse = streamReader(is);
            is.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return jsonResponse;        
    }
    
    private String streamReader(InputStream is){
        int bufferSize = 1024;
        char[] buffer = new char[bufferSize];
        StringBuilder sb = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        int charRead;
        try{
            while((charRead = reader.read(buffer, 0, buffer.length)) > 0){
                sb.append(buffer, 0, charRead);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
