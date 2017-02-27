package savio_estadisticas.clases.Control.CourseContent;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("instance")
@Expose
private Integer instance;
@SerializedName("description")
@Expose
private String description;
@SerializedName("visible")
@Expose
private Integer visible;
@SerializedName("modicon")
@Expose
private String modicon;
@SerializedName("modname")
@Expose
private String modname;
@SerializedName("modplural")
@Expose
private String modplural;
@SerializedName("availability")
@Expose
private Object availability;
@SerializedName("indent")
@Expose
private Integer indent;
@SerializedName("url")
@Expose
private String url;
@SerializedName("contents")
@Expose
private List<Content_> contents = null;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getInstance() {
return instance;
}

public void setInstance(Integer instance) {
this.instance = instance;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getVisible() {
return visible;
}

public void setVisible(Integer visible) {
this.visible = visible;
}

public String getModicon() {
return modicon;
}

public void setModicon(String modicon) {
this.modicon = modicon;
}

public String getModname() {
return modname;
}

public void setModname(String modname) {
this.modname = modname;
}

public String getModplural() {
return modplural;
}

public void setModplural(String modplural) {
this.modplural = modplural;
}

public Object getAvailability() {
return availability;
}

public void setAvailability(Object availability) {
this.availability = availability;
}

public Integer getIndent() {
return indent;
}

public void setIndent(Integer indent) {
this.indent = indent;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public List<Content_> getContents() {
return contents;
}

public void setContents(List<Content_> contents) {
this.contents = contents;
}

}
