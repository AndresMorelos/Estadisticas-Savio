/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control;

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import savio_estadisticas.clases.Participante;
import savio_estadisticas.clases.Participants;
import savio_estadisticas.clases.Role;

/**
 *
 * @author amorelos
 */
public class GetParticipants{
    private String URL_Excecute = "http://savio.utbvirtual.edu.co/webservice/rest/server.php";
    private String JSON = null;
    private  String JSON2 = null;
    private final String TOKEN = "118f6404c5140d59bab4cbd8fce04a02";
    private String ID;
    private List<String> Professor = new ArrayList<String>();
    private Gson gson = new Gson();
    private Participants participantes = new Participants();

    public GetParticipants(String ID) {
        this.ID = ID;
    }
    
  
     public List<String> getParticipants(){
          try {
            URL url = new URL(URL_Excecute + "?wsfunction=core_enrol_get_enrolled_users&wstoken="+ TOKEN +"&moodlewsrestformat=json&courseid=" + ID);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSON = getStringFromInputStream(in);
            urlConnection.disconnect();
            JSON2 = "{ \"participantes\":" + JSON + "}";
            participantes = gson.fromJson(JSON2,Participants.class);
            
            for(Participante c: participantes.getParticipantes()) {
                List<Role> g = c.getRoles();
                for (Role j : g) {
                    if (j.getRoleid() == 3) {
                        getProfessor().add(c.getFullname());
                    }
                }
            }
            return getProfessor();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
          return null;
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

    /**
     * @return the Professor
     */
    public List<String> getProfessor() {
        return Professor;
    }

    /**
     * @param Professor the Professor to set
     */
    public void setProfessor(List<String> Professor) {
        this.Professor = Professor;
    }
    
    
}
