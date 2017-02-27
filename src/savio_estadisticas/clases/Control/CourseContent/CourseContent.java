package savio_estadisticas.clases.Control.CourseContent;

import savio_estadisticas.clases.Control.CourseContent.Content;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseContent {

@SerializedName("content")
@Expose
private List<Content> content = null;

public List<Content> getContent() {
return content;
}

public void setContent(List<Content> content) {
this.content = content;
}

}
