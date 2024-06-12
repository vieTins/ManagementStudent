package manage;

import java.sql.Date;
import java.text.SimpleDateFormat;
public class Student {
  int id ;
  String mahs , fullname ,dateofbirth , gender , ethnicgroup , religion , phonenumber , email , anh, diaChi ;
  Date date ;
  boolean isPresent ;
public Student() {	
}	
// thêm 
public Student(String mahs, Date date, boolean isPresent) {
	super();
	this.mahs = mahs;
	this.date = date;
	this.isPresent = isPresent;
}
public Student(int id ,String mahs,String fullname, String dateofbirth, String gender, String ethnicgroup, String religion,
		String phonenumber, String email ,String anh , String diaChi ) {
	this.id = id;
	this.mahs = mahs ;
	this.fullname = fullname;
	this.dateofbirth = dateofbirth;
	this.gender = gender;
	this.ethnicgroup = ethnicgroup;
	this.religion = religion;
	this.phonenumber = phonenumber;
	this.email = email;
	this.anh = anh;
	this.diaChi = diaChi ;
}

public Student(String mahs, String fullname) {
	this.mahs = mahs;
	this.fullname = fullname;
}

public Student( String mahs , String fullname, String dateofbirth, String gender, String ethnicgroup, String religion,
		String phonenumber, String email , String anhh , String diaChi) {
	this.mahs = mahs;
	this.fullname = fullname;
	this.dateofbirth = dateofbirth;
	this.gender = gender;
	this.ethnicgroup = ethnicgroup;
	this.religion = religion;
	this.phonenumber = phonenumber;
	this.email = email;
	this.anh = anh ;
	this.diaChi = diaChi ;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEthnicgroup() {
	return ethnicgroup;
}
public void setEthnicgroup(String ethnicgroup) {
	this.ethnicgroup = ethnicgroup;
}
public String getReligion() {
	return religion;
}
public void setReligion(String religion) {
	this.religion = religion;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public String getMahs() {
	return mahs;
}
public void setMahs(String mahs) {
	this.mahs = mahs;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
// thêm 
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public boolean isPresent() {
	return isPresent;
}
public void setPresent(boolean isPresent) {
	this.isPresent = isPresent;
}
}
