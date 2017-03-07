package savio_estadisticas.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Enrolledcourse {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("shortname")
@Expose
private String shortname;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

public String getShortname() {
return shortname;
}

public void setShortname(String shortname) {
this.shortname = shortname;
}

}
