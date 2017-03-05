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
import savio_estadisticas.clases.CategoryName;

/**
 *
 * @author amorelos
 */
public class getCatergories{
    private final String URI = "http://savio.utbvirtual.edu.co/course/category/";
    private Gson gson = new Gson();
    
    
    
    
    public CategoryName GetCategories(String Categoryid){
        CategoryName categoryname = new CategoryName();
        categoryname.setParent(Categoryid);
        CategoryName aux = new CategoryName();
        while(!categoryname.getParent().equals("0")){
                try{
                    String JSON = null;
                    URL url = new URL(URI + "?categoryid=" + categoryname.getParent());
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    JSON = getStringFromInputStream(in);
                    urlConnection.disconnect();
                    categoryname = gson.fromJson(JSON,CategoryName.class); 
                    if (categoryname.getName().equals("201220")|| categoryname.getName().equals("201215")
                        || categoryname.getName().equals("201210") || categoryname.getName().equals("201225") || categoryname.getName().equals("201310")
                        || categoryname.getName().equals("201315") || categoryname.getName().equals("201320") || categoryname.getName().equals("201325")
                        || categoryname.getName().equals("201410") || categoryname.getName().equals("201415") || categoryname.getName().equals("201420")
                        || categoryname.getName().equals("201515") || categoryname.getName().equals("201510") || categoryname.getName().equals("201520") 
                        || categoryname.getName().equals("201610") || categoryname.getName().equals("201615") || categoryname.getName().equals("201526")
                        || categoryname.getName().equals("201616") || categoryname.getName().equals("201620")) {
                          return categoryname;
                    }else{ 
                        //continue
                        
                    }
                }catch(Exception e){
                    System.err.println("Ha saltado una excepcion");
                        
                }
             
         
        }
        return categoryname;
        
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
