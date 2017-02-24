/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryName {

@SerializedName("name")
@Expose
private String name;
@SerializedName("parent")
@Expose
private String parent;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getParent() {
return parent;
}

public void setParent(String parent) {
this.parent = parent;
}

}
