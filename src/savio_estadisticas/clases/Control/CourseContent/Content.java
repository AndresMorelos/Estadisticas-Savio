
package savio_estadisticas.clases.Control.CourseContent;

import savio_estadisticas.clases.Control.CourseContent.Module;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("visible")
@Expose
private Integer visible;
@SerializedName("summary")
@Expose
private String summary;
@SerializedName("summaryformat")
@Expose
private Integer summaryformat;
@SerializedName("modules")
@Expose
private List<Module> modules = null;

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

public Integer getVisible() {
return visible;
}

public void setVisible(Integer visible) {
this.visible = visible;
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

public List<Module> getModules() {
return modules;
}

public void setModules(List<Module> modules) {
this.modules = modules;
}

}
