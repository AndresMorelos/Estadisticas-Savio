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
import savio_estadisticas.clases.Courses;

/**
 *
 * @author amorelos
 */
public class GetAllCourses extends Thread {
    private final String URL_Excecute = "http://savio.utbvirtual.edu.co/webservice/rest/server.php";
    private String JSON = null;
    private String JSON2 = null;
    private final String TOKEN = "9374506f1db6c4e2b4455065cde0b9f5";
    private Gson gson = new Gson();
    private Courses cursos;
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Buscando Cursos");
        try {
                URL url = new URL(URL_Excecute + "?wsfunction=core_course_get_courses&wstoken=" + TOKEN + "&moodlewsrestformat=json");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                JSON = getStringFromInputStream(in);
                urlConnection.disconnect();
                JSON2 = "{\"course\" :" + JSON + "}";
                
                cursos = gson.fromJson(JSON2,Courses.class);
                
                
               }catch (Exception e){
                    System.out.println(e.getMessage());
               } 
        System.out.println("Cursos Encotrados");
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

    public Courses getCursos() {
        return cursos;
    }

    public void setCursos(Courses cursos) {
        this.cursos = cursos;
    }
    
    
  }

