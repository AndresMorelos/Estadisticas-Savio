/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control.CourseContent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amorelos
 */
public class NodeContent {
    private String CourseName;
    private List<countcontent> content = new ArrayList<countcontent>();

    public NodeContent(String CourseName) {
        this.CourseName = CourseName;
    }

    public NodeContent() {
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public List<countcontent> getContent() {
        return content;
    }

    public void setContent(List<countcontent> content) {
        this.content = content;
    }
    
    
    
}
