package savio_estadisticas.clases;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participante {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("email")
@Expose
private String email;
@SerializedName("firstaccess")
@Expose
private Integer firstaccess;
@SerializedName("lastaccess")
@Expose
private Integer lastaccess;
@SerializedName("description")
@Expose
private String description;
@SerializedName("descriptionformat")
@Expose
private Integer descriptionformat;
@SerializedName("city")
@Expose
private String city;
@SerializedName("country")
@Expose
private String country;
@SerializedName("profileimageurlsmall")
@Expose
private String profileimageurlsmall;
@SerializedName("profileimageurl")
@Expose
private String profileimageurl;
@SerializedName("customfields")
@Expose
private List<Customfield> customfields = null;
@SerializedName("roles")
@Expose
private List<Role> roles = null;
@SerializedName("enrolledcourses")
@Expose
private List<Enrolledcourse> enrolledcourses = null;
@SerializedName("phone2")
@Expose
private String phone2;
@SerializedName("address")
@Expose
private String address;
@SerializedName("phone1")
@Expose
private String phone1;
@SerializedName("skype")
@Expose
private String skype;
@SerializedName("msn")
@Expose
private String msn;
@SerializedName("url")
@Expose
private String url;

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

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public Integer getFirstaccess() {
return firstaccess;
}

public void setFirstaccess(Integer firstaccess) {
this.firstaccess = firstaccess;
}

public Integer getLastaccess() {
return lastaccess;
}

public void setLastaccess(Integer lastaccess) {
this.lastaccess = lastaccess;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getDescriptionformat() {
return descriptionformat;
}

public void setDescriptionformat(Integer descriptionformat) {
this.descriptionformat = descriptionformat;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getProfileimageurlsmall() {
return profileimageurlsmall;
}

public void setProfileimageurlsmall(String profileimageurlsmall) {
this.profileimageurlsmall = profileimageurlsmall;
}

public String getProfileimageurl() {
return profileimageurl;
}

public void setProfileimageurl(String profileimageurl) {
this.profileimageurl = profileimageurl;
}

public List<Customfield> getCustomfields() {
return customfields;
}

public void setCustomfields(List<Customfield> customfields) {
this.customfields = customfields;
}

public List<Role> getRoles() {
return roles;
}

public void setRoles(List<Role> roles) {
this.roles = roles;
}

public List<Enrolledcourse> getEnrolledcourses() {
return enrolledcourses;
}

public void setEnrolledcourses(List<Enrolledcourse> enrolledcourses) {
this.enrolledcourses = enrolledcourses;
}

public String getPhone2() {
return phone2;
}

public void setPhone2(String phone2) {
this.phone2 = phone2;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getPhone1() {
return phone1;
}

public void setPhone1(String phone1) {
this.phone1 = phone1;
}

public String getSkype() {
return skype;
}

public void setSkype(String skype) {
this.skype = skype;
}

public String getMsn() {
return msn;
}

public void setMsn(String msn) {
this.msn = msn;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

}
