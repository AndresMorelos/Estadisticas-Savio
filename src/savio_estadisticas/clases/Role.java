package savio_estadisticas.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Role {

@SerializedName("roleid")
@Expose
private Integer roleid;
@SerializedName("name")
@Expose
private String name;
@SerializedName("shortname")
@Expose
private String shortname;
@SerializedName("sortorder")
@Expose
private Integer sortorder;

public Integer getRoleid() {
return roleid;
}

public void setRoleid(Integer roleid) {
this.roleid = roleid;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getShortname() {
return shortname;
}

public void setShortname(String shortname) {
this.shortname = shortname;
}

public Integer getSortorder() {
return sortorder;
}

public void setSortorder(Integer sortorder) {
this.sortorder = sortorder;
}

}
