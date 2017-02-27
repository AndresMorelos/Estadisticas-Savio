/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control.CourseContent;

/**
 *
 * @author amorelos
 */
public class countcontent {
    private String ContentName;
    private Long count;

    public countcontent(String ContentName) {
        this.ContentName = ContentName;
    }

    public countcontent() {
    }

    public countcontent(String ContentName, Long count) {
        this.ContentName = ContentName;
        this.count = count;
    }

    public String getContentName() {
        return ContentName;
    }

    public void setContentName(String ContentName) {
        this.ContentName = ContentName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    
    
}
