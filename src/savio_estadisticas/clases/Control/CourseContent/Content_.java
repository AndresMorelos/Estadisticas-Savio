package savio_estadisticas.clases.Control.CourseContent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content_ {

@SerializedName("type")
@Expose
private String type;
@SerializedName("filename")
@Expose
private String filename;
@SerializedName("filepath")
@Expose
private String filepath;
@SerializedName("filesize")
@Expose
private Integer filesize;
@SerializedName("fileurl")
@Expose
private String fileurl;
@SerializedName("timecreated")
@Expose
private Integer timecreated;
@SerializedName("timemodified")
@Expose
private Integer timemodified;
@SerializedName("sortorder")
@Expose
private Integer sortorder;
@SerializedName("userid")
@Expose
private Integer userid;
@SerializedName("author")
@Expose
private Object author;
@SerializedName("license")
@Expose
private String license;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getFilename() {
return filename;
}

public void setFilename(String filename) {
this.filename = filename;
}

public String getFilepath() {
return filepath;
}

public void setFilepath(String filepath) {
this.filepath = filepath;
}

public Integer getFilesize() {
return filesize;
}

public void setFilesize(Integer filesize) {
this.filesize = filesize;
}

public String getFileurl() {
return fileurl;
}

public void setFileurl(String fileurl) {
this.fileurl = fileurl;
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

public Integer getSortorder() {
return sortorder;
}

public void setSortorder(Integer sortorder) {
this.sortorder = sortorder;
}

public Integer getUserid() {
return userid;
}

public void setUserid(Integer userid) {
this.userid = userid;
}

public Object getAuthor() {
return author;
}

public void setAuthor(Object author) {
this.author = author;
}

public String getLicense() {
return license;
}

public void setLicense(String license) {
this.license = license;
}

}
