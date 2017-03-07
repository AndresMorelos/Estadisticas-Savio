/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author amorelos
 */
public class GetParticipants extends Thread{
    private String URL_Excecute = "http://savio.utbvirtual.edu.co/webservice/rest/server.php";
    private String JSON = null;
    private  String JSON2 = null;
    private final String TOKEN = "118f6404c5140d59bab4cbd8fce04a02";
    private String ID;

    public GetParticipants(String ID) {
        this.ID = ID;
    }
    
    

    @Override
    public void run() {
        try {
            URL url = new URL(URL_Excecute + "?wsfunction=core_enrol_get_enrolled_users&wstoken="+ TOKEN +"&moodlewsrestformat=json&courseid=" + ID);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSON = getStringFromInputStream(in);
            urlConnection.disconnect();
            JSON2 = "{ \"participantes\":" + JSON + "}";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
    
    
}
