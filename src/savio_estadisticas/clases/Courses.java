/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Courses {

@SerializedName("course")
@Expose
private List<Course> course = null;

public List<Course> getCourse() {
return course;
}

public void setCourse(List<Course> course) {
this.course = course;
}

}