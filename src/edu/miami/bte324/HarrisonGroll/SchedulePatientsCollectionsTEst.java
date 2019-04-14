package edu.miami.bte324.HarrisonGroll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;







public class SchedulePatientsCollectionsTEst {

	String[][] patientArray; 
	public static HashMap<Integer, Patient> pMap = new HashMap<Integer, Patient>(); //here
	public static HashMap<Integer, Doctor> dMap = new HashMap<Integer, Doctor>(); //here
	String[][] doctorArray; 
	public static Date today = new Date(); 
	//used set b/c date will be used to order, only unique visits 
	private static ArrayList<VisitImpl<Patient, Doctor>> visits = new ArrayList<VisitImpl<Patient, Doctor>>(); //here
	private static ArrayList<Patient> pList = new ArrayList<Patient>(); //here
	private static ArrayList<DoctorImpl> dList = new ArrayList<DoctorImpl>(); 
	
	public static ArrayList<VisitImpl<PatientImpl, DoctorImpl>> vList = new ArrayList<VisitImpl<PatientImpl, DoctorImpl>>(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
		
		
	}

	private static void run() {
		// TODO Auto-generated method stub
		System.out.println("*************************************************************");
		makePatients(); 
		makeDoctors();
		makeVisits();
		mapPatients(); 
		mapDoctors(); 
		printVisits();	//Prints Visits in order 1.c
		
		upcomingVisits(); //Print Upcoming Visits 1.d
		
		System.out.println(pMap);
		System.out.println(dMap);
		System.out.println("*************************************************************");
		
		Collections.sort(visits); //Comparable to sort by visit dates

		printVisits();
		
	}
	
	private static void upcomingVisits() {
		// TODO Auto-generated method stub
		System.out.println("*************************************************************");
		for(int i = 0; i < visits.size(); i++){
			if(compareDates(visits.get(i).getDate(), today) > 0){
				System.out.println("Patient Name: \t" + visits.get(i).getV().getFName() + " " + visits.get(i).getV().getLName());
				System.out.println("SSN: \t\t" + visits.get(i).getV().getSSN());
				System.out.println("Age: \t\t" + (compareDates(today, visits.get(i).getV().getDOB()))/366); 
				System.out.println("Upcoming Visit: "); 
				System.out.println("\tVisit Date: \t\t" + visits.get(i).getDate());
				System.out.println("\tDoctor: \t\t Dr. " + visits.get(i).getT().getLName());
				System.out.println("\tSpecialty: \t\t" + visits.get(i).getT().getSpecialty());
			}
		}
		System.out.println("*************************************************************");
	}

	private static void mapPatients() {
		// TODO Auto-generated method stub
	 int size = pList.size();
	 for(int i = 0; i < size; i++) {
		 pMap.put(pList.get(i).getId(), pList.get(i));
	 }
	
	}
	private static void mapDoctors() {
		// TODO Auto-generated method stub
		int size = dList.size();
		for(int i = 0; i < size; i++) {
			dMap.put(dList.get(i).getID(), dList.get(i));
		}
	
	}

	private static void makePatients() {
		for(int i = 0; i < Data.patientNames.length; i++) {
			Date d; 
			if (isValidDate(Data.patientBirthDates[i])) {
				 d  = new Date(Data.patientBirthDates[i]); 
			}
			else {
				d  = new Date("01/01/9999"); 
			}
			
			pList.add(new PatientImpl(Data.patientNames[i], Data.patientSSN[i], d));  //here
		}
	
	}
	
	private static void makeVisits() {
		// TODO Auto-generated method stub 
		for(int i = 0; i < pList.size(); i++) {
			Date d; 
			if (isValidDate(Data.visitDates[i])) {
				 d  = new Date(Data.visitDates[i]); 
			}
			else {
				d  = new Date("01/01/9999"); 
			}
			visits.add(new VisitImpl(pList.get(i), dList.get(i), d));
		}
	}
	
	private static void makeDoctors() {
		for(int i = 0; i < Data.doctorNames.length; i++) {
			Date d; 
			if (isValidDate(Data.doctorBirthDates[i])) {
				 d  = new Date(Data.patientBirthDates[i]); 
			}
			else {
				d  = new Date("01/01/9999"); 
			}
			dList.add(new DoctorImpl(Data.doctorNames[i],Data.doctorSSN[i],d, Data.doctorSpecialties[i]));	
		}
		
	}
	
	public static boolean isValidDate(String date){
		//made a custom date validator 
		try {
			Date d = new Date(date);
			return true; 
		}catch(IllegalArgumentException e) {
			return false; 
		}
		
	}
	private static void printVisits() {
		// TODO Auto-generated method stub
		for(int i = 0; i < visits.size(); i++){
			System.out.println("Visit Date: \t\t" + visits.get(i).getDate());
			System.out.println("Doctor: \t\t" + visits.get(i).getT().getFName());
			System.out.println("Doctor: \t\t" + visits.get(i).getT().getLName());
			System.out.println("Specialty: \t\t" + visits.get(i).getT().getSpecialty());
			System.out.println("Days Until Visit: \t" + compareDates(visits.get(i).getDate(), today));
			System.out.println("Patient:");
			System.out.println("\tLast Name: \t" + visits.get(i).getV().getFName());
			System.out.println("\tLast Name: \t" + visits.get(i).getV().getLName());
			System.out.println("\tSSN: \t\t" + visits.get(i).getV().getSSN());
			System.out.println("\tAge: \t\t" + visits.get(i).getV().getAge());
			
			System.out.println();
			
		}
	}
	private static int compareDates(Date from, Date to) {
		//diff in two times relative to epoch time 
		return (int)((-to.getTime() + from.getTime()) /86400000); 
	}

}
