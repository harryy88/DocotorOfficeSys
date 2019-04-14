package edu.miami.bte324.HarrisonGroll;

import java.util.Date;
import java.util.Objects;

public final class PatientImpl implements Patient, Comparable<Object> {
	
	private String fName, lName, SSN; //****IMPL ID
	public Date dob; 
	private int ID; 
	private static int patientID = 0; 
	
	public PatientImpl(String fullName, String SSN, Date DOB) {
		// TODO Auto-generated constructor stub
		this.SSN = SSN; 
		this.dob = DOB; 
		//this.ID = ID; 
		this.ID = patientID; 
		++patientID; 
		String[] name = fullName.split(" ");
		this.fName = name[0];
		this.lName = name[1];
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.ID;
	}

	@Override
	public String getFName() {
		// TODO Auto-generated method stub
		return this.fName;
	}

	@Override
	public String getLName() {
		// TODO Auto-generated method stub
		return this.lName;
	}

	@Override
	public String getSSN() {
		// TODO Auto-generated method stub
		return this.SSN;
	}

	@Override
	public Date getDOB() {
		// TODO Auto-generated method stub
		return this.dob;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		Date from = new Date(); 
		return (int)((-dob.getTime() + from.getTime()) /86400000 / 365) ; 
	}
	@Override 
	public boolean equals(Object o) {
		// id, lname, fname, SSN, dob
		if (o == this)
			return true; 
		if (!(o instanceof PatientImpl))
			return false; 
		PatientImpl p = (PatientImpl) o;
		return (this.dob.equals(p.dob) && this.lName.equals(p.lName) && this.fName.equals(p.fName) && this.SSN.equals(p.SSN));
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(ID,lName,fName,SSN);
	}
	@Override 
	public String toString() {
		String str = ""; 
		str += this.fName + " " + this.lName + " " + this.SSN + " " + this.ID + this.getAge(); 
		return str; 
	}
	
	@Override
	public int compareTo(Object o) {
		DoctorImpl d = (DoctorImpl) o; 
		return d.getAge() - this.getAge(); 

	}

}
