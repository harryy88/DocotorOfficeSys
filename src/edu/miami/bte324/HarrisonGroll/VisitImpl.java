package edu.miami.bte324.HarrisonGroll;

import java.util.Date;
import java.util.Objects;

public class VisitImpl<V, T> implements Visit<V, T>, Comparable {
	
	private V visit; 
	private T host; 
	private Date d; 
	public VisitImpl(V visit, T host, Date d) {
		// TODO Auto-generated constructor stub
		this.host = host;
		this.visit = visit; 
		this.d = d; 
	}
	
	@Override 
	public String toString() {
		String str = "Patient: "; 
		str += ((PatientImpl) this.visit).getFName() + " with doctor: " + ((DoctorImpl) this.host).getFName(); 
		return str; 
	}

	@Override
	public V getV() {
		// TODO Auto-generated method stub
		return visit; 
	}

	@Override
	public T getT() {
		// TODO Auto-generated method stub
		return host; 
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return d; 
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true; 
		if (!(o instanceof VisitImpl))
			return false; 
		VisitImpl<PatientImpl, DoctorImpl> v = (VisitImpl<PatientImpl, DoctorImpl>) o; 
		return (this.visit.equals(v.visit) && this.host.equals(v.host) && this.d.equals(v.d));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(visit, host, d);
		
	}

	@Override
	public int compareTo(Object o) {
		@SuppressWarnings("unchecked")
		VisitImpl<Patient, Doctor> v = (VisitImpl<Patient, Doctor>) o; 
		
		return (int) (-v.getDate().getTime() + this.getDate().getTime());
	}

}
