package edu.miami.bte324.HarrisonGroll;

import java.util.Date;
import java.util.Objects;

public final class DoctorImpl implements Doctor, Patient, Comparable<Object>{
	
	private String fName, lName, SSN; 
	private int id; 
	private MedicalSpecialty specialty; 
	private Date dob; 
	private static int doctorID = 0; 
	
	DoctorImpl(String fullName, String SSN, Date dob, String specialty){
		this.SSN = SSN; 
		this.dob = dob; 
		//this.id = ID; 
		this.id = doctorID; 
		++doctorID; 
		this.specialty = MedicalSpecialty.getFromString(specialty);
		String[] name = fullName.split(" ");
		this.fName = name[0];
		this.lName = name[1];
		
	}
	
	@Override 
	public String toString() {
		String str = ""; 
		str += this.fName + " " + this.lName + " " + this.SSN + " " + this.id + " " + this.specialty; 
		return str; 
	}

	public DoctorImpl() {
		// TODO Auto-generated constructor stub
		this.SSN = null; 
		this.dob = null; 
		this.specialty = null;
		this.fName = null;
		this.lName = null;
	}

//	@Override
//	public int getID() {
//		// TODO Auto-generated method stub
//		return this.id;
//	}

	@Override
	public String getLName() {
		// TODO Auto-generated method stub
		return this.lName;
	}

	@Override
	public String getFName() {
		// TODO Auto-generated method stub
		return this.fName;
	}

	@Override
	public MedicalSpecialty getSpecialty() {
		// TODO Auto-generated method stub
		return this.specialty;
	}
	
	@Override 
	public boolean equals(Object o){
		//id, lname, fname, SSN, dob, specialty.
		if (this == o)
			return true; 
		if (!(this instanceof DoctorImpl))
			return false; 
		DoctorImpl d = (DoctorImpl) o; 
		return (this.lName.equals(d.lName) && this.fName.equals(d.fName) && this.SSN.equals(d.SSN) && this.dob.equals(d.dob) && this.specialty.equals(d.specialty) && (this.id == d.id));		
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(lName, fName, SSN, dob, specialty);
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
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
		return (int)((from.getTime() - dob.getTime()) / (100 * 60 * 60 * 24)) ; 
		
	}

	@Override
	public int compareTo(Object o) {
		DoctorImpl d = (DoctorImpl) o; 
		return 0;
	}

}
