/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control.CourseContent;

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
public class GetCourseContent {

    private final String URL_Excecute = "http://savio.utbvirtual.edu.co/webservice/rest/server.php";
    private String JSON = null;
    private String JSON2 = null;
    private final String TOKEN = "fcb816dffd9554ba32ca6b620fe3e6f7";
    private Gson gson = new Gson();
    private CourseContent coursecontent = new CourseContent();
    private String Courseid;

    public GetCourseContent(String Courseid) {
        this.Courseid = Courseid;
    }

    public CourseContent getConent() {
        try {
            URL url = new URL(URL_Excecute + "?wsfunction=core_course_get_contents&wstoken=" + TOKEN + "&moodlewsrestformat=json&courseid=" + Courseid);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSON = getStringFromInputStream(in);
            urlConnection.disconnect();
            JSON2 = "{\"content\" :" + JSON + "}";

            coursecontent = gson.fromJson(JSON2, CourseContent.class);

            return coursecontent;
        } catch (Exception e) {
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

    public CourseContent getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(CourseContent coursecontent) {
        this.coursecontent = coursecontent;
    }

    public String getCourseid() {
        return Courseid;
    }

    public void setCourseid(String Courseid) {
        this.Courseid = Courseid;
    }

}
