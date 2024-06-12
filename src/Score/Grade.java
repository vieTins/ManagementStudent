package Score;

import manage.Student;

public class Grade {
 private int id ; 
 private Student sv ;
 private double java , c , csdl , gt , tanh , gdtc ;
public Grade(int id, Student sv, double java, double c, double csdl, double gt, double tanh, double gdtc) {
	this.id = id;
	this.sv = sv;
	this.java = java;
	this.c = c;
	this.csdl = csdl;
	this.gt = gt;
	this.tanh = tanh;
	this.gdtc = gdtc;
}
public Grade() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Student getSv() {
	return sv;
}
public void setSv(Student sv) {
	this.sv = sv;
}
public double getJava() {
	return java;
}
public void setJava(double java) {
	this.java = java;
}
public double getC() {
	return c;
}
public void setC(double c) {
	this.c = c;
}
public double getCsdl() {
	return csdl;
}
public void setCsdl(double csdl) {
	this.csdl = csdl;
}
public double getGt() {
	return gt;
}
public void setGt(double gt) {
	this.gt = gt;
}
public double getTanh() {
	return tanh;
}
public void setTanh(double tanh) {
	this.tanh = tanh;
}
public double getGdtc() {
	return gdtc;
}
public void setGdtc(double gdtc) {
	this.gdtc = gdtc;
}
public double getTrungBinhCong() {
	return (getCsdl()+ getGdtc()+ getGt()+ getJava()+ getC()+ getTanh())/6;
}
 public String getXepLoai() {
	 String xl = "";
	 double TrungBinhCong = getTrungBinhCong();
	 if (TrungBinhCong >= 9.5) {
		 xl="Xuat Sac" ;
	 }
	 else if (TrungBinhCong >= 8) {
		 xl= "Gioi" ;
	 }else if (TrungBinhCong >= 7) {
		 xl= "Kha" ;
	 }else if (TrungBinhCong >= 5) {
		 xl= "Trung Binh" ;
	 }else {
		 xl="Yeu" ;
	 }
	 return xl ;
 }
}
