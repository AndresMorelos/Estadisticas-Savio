/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import savio_estadisticas.clases.Control.CourseContent.countcontent;

public class Course {
    
@SerializedName("id")
@Expose
private Integer id;
@SerializedName("shortname")
@Expose
private String shortname;
@SerializedName("categoryid")
@Expose
private Integer categoryid;
@SerializedName("categorysortorder")
@Expose
private Integer categorysortorder;
@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("displayname")
@Expose
private String displayname;
@SerializedName("idnumber")
@Expose
private String idnumber;
@SerializedName("summary")
@Expose
private String summary;
@SerializedName("summaryformat")
@Expose
private Integer summaryformat;
@SerializedName("format")
@Expose
private String format;
@SerializedName("showgrades")
@Expose
private Integer showgrades;
@SerializedName("newsitems")
@Expose
private Integer newsitems;
@SerializedName("startdate")
@Expose
private Integer startdate;
@SerializedName("numsections")
@Expose
private Integer numsections;
@SerializedName("maxbytes")
@Expose
private Integer maxbytes;
@SerializedName("showreports")
@Expose
private Integer showreports;
@SerializedName("visible")
@Expose
private Integer visible;
@SerializedName("groupmode")
@Expose
private Integer groupmode;
@SerializedName("groupmodeforce")
@Expose
private Integer groupmodeforce;
@SerializedName("defaultgroupingid")
@Expose
private Integer defaultgroupingid;
@SerializedName("timecreated")
@Expose
private Integer timecreated;
@SerializedName("timemodified")
@Expose
private Integer timemodified;
@SerializedName("enablecompletion")
@Expose
private Integer enablecompletion;
@SerializedName("completionnotify")
@Expose
private Integer completionnotify;
@SerializedName("lang")
@Expose
private String lang;
@SerializedName("forcetheme")
@Expose
private String forcetheme;
@SerializedName("courseformatoptions")
@Expose
private List<Courseformatoption> courseformatoptions = null;
@SerializedName("hiddensections")
@Expose
private Integer hiddensections;
private countcontent CountContent = new countcontent();
public String getCategoryid;
private String CategoryName;
private List<String> Professor = new ArrayList<String>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getShortname() {
return shortname;
}

public void setShortname(String shortname) {
this.shortname = shortname;
}

public Integer getCategoryid() {
return categoryid;
}

public void setCategoryid(Integer categoryid) {
this.categoryid = categoryid;
}

public Integer getCategorysortorder() {
return categorysortorder;
}

public void setCategorysortorder(Integer categorysortorder) {
this.categorysortorder = categorysortorder;
}

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

public String getDisplayname() {
return displayname;
}

public void setDisplayname(String displayname) {
this.displayname = displayname;
}

public String getIdnumber() {
return idnumber;
}

public void setIdnumber(String idnumber) {
this.idnumber = idnumber;
}

public String getSummary() {
return summary;
}

public void setSummary(String summary) {
this.summary = summary;
}

public Integer getSummaryformat() {
return summaryformat;
}

public void setSummaryformat(Integer summaryformat) {
this.summaryformat = summaryformat;
}

public String getFormat() {
return format;
}

public void setFormat(String format) {
this.format = format;
}

public Integer getShowgrades() {
return showgrades;
}

public void setShowgrades(Integer showgrades) {
this.showgrades = showgrades;
}

public Integer getNewsitems() {
return newsitems;
}

public void setNewsitems(Integer newsitems) {
this.newsitems = newsitems;
}

public Integer getStartdate() {
return startdate;
}

public void setStartdate(Integer startdate) {
this.startdate = startdate;
}

public Integer getNumsections() {
return numsections;
}

public void setNumsections(Integer numsections) {
this.numsections = numsections;
}

public Integer getMaxbytes() {
return maxbytes;
}

public void setMaxbytes(Integer maxbytes) {
this.maxbytes = maxbytes;
}

public Integer getShowreports() {
return showreports;
}

public void setShowreports(Integer showreports) {
this.showreports = showreports;
}

public Integer getVisible() {
return visible;
}

public void setVisible(Integer visible) {
this.visible = visible;
}

public Integer getGroupmode() {
return groupmode;
}

public void setGroupmode(Integer groupmode) {
this.groupmode = groupmode;
}

public Integer getGroupmodeforce() {
return groupmodeforce;
}

public void setGroupmodeforce(Integer groupmodeforce) {
this.groupmodeforce = groupmodeforce;
}

public Integer getDefaultgroupingid() {
return defaultgroupingid;
}

public void setDefaultgroupingid(Integer defaultgroupingid) {
this.defaultgroupingid = defaultgroupingid;
}

public Integer getTimecreated() {
return timecreated;
}

public void setTimecreated(Integer timecreated) {
this.timecreated = timecreated;
}

public Integer getTimemodified() {
return timemodified;
}

public void setTimemodified(Integer timemodified) {
this.timemodified = timemodified;
}

public Integer getEnablecompletion() {
return enablecompletion;
}

public void setEnablecompletion(Integer enablecompletion) {
this.enablecompletion = enablecompletion;
}

public Integer getCompletionnotify() {
return completionnotify;
}

public void setCompletionnotify(Integer completionnotify) {
this.completionnotify = completionnotify;
}

public String getLang() {
return lang;
}

public void setLang(String lang) {
this.lang = lang;
}

public String getForcetheme() {
return forcetheme;
}

public void setForcetheme(String forcetheme) {
this.forcetheme = forcetheme;
}

public List<Courseformatoption> getCourseformatoptions() {
return courseformatoptions;
}

public void setCourseformatoptions(List<Courseformatoption> courseformatoptions) {
this.courseformatoptions = courseformatoptions;
}

public Integer getHiddensections() {
return hiddensections;
}

public void setHiddensections(Integer hiddensections) {
this.hiddensections = hiddensections;
}

    /**
     * @return the CountContent
     */
    public countcontent getCountContent() {
        return CountContent;
    }

    /**
     * @param CountContent the CountContent to set
     */
    public void setCountContent(countcontent CountContent) {
        this.CountContent = CountContent;
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

    /**
     * @return the CategoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     * @param CategoryName the CategoryName to set
     */
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

}
