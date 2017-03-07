package savio_estadisticas.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customfield {

@SerializedName("type")
@Expose
private String type;
@SerializedName("value")
@Expose
private String value;
@SerializedName("name")
@Expose
private String name;
@SerializedName("shortname")
@Expose
private String shortname;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
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

}