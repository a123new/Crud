package com.hiber.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Data")
public class Student
{
	@Id 
	@Column(name = "Std_Id")
	private int stdid;
	
	@Column(name = "First_Name")
	private String stdname;
	
	@Column(name = "Surname")
	private String stdsurname;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "Gender")
	private String stdgender;
	
	@Column(name = "Email_Id")
	private String stdemail;
	
	@Column(name = "Phone_No", length = 11, nullable = false, unique = true)
	private long stdphone;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int stdid, String stdname, String stdsurname, String dob, String stdgender, String stdemail,
			long stdphone) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stdsurname = stdsurname;
		this.dob = dob;
		this.stdgender = stdgender;
		this.stdemail = stdemail;
		this.stdphone = stdphone;
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public String getStdsurname() {
		return stdsurname;
	}

	public void setStdsurname(String stdsurname) {
		this.stdsurname = stdsurname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStdgender() {
		return stdgender;
	}

	public void setStdgender(String stdgender) {
		this.stdgender = stdgender;
	}

	public String getStdemail() {
		return stdemail;
	}

	public void setStdemail(String stdemail) {
		this.stdemail = stdemail;
	}

	public long getStdphone() {
		return stdphone;
	}

	public void setStdphone(long stdphone) {
		this.stdphone = stdphone;
	}

	
}
	
