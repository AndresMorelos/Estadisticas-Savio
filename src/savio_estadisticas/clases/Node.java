/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amorelos
 */
public class Node {
    private String NameCategory;
    private List<Course> CategoryCourses = new ArrayList<Course>();

    public Node(String NameCategory) {
        this.NameCategory = NameCategory;
    }

    public String getNameCategory() {
        return NameCategory;
    }

    public void setNameCategory(String NameCategory) {
        this.NameCategory = NameCategory;
    }

    public List<Course> getCategoryCourses() {
        return CategoryCourses;
    }

    public void setCategoryCourses(List<Course> CategoryCourses) {
        this.CategoryCourses = CategoryCourses;
    }
    
    public void addCourse(Course h){
       this.CategoryCourses.add(h);
    }
    
    
    
}
