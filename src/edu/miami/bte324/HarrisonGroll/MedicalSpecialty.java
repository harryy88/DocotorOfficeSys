package edu.miami.bte324.HarrisonGroll;

public enum MedicalSpecialty {
	GENERAL_MEDICINE, PEDIATRICS, ONCOLOGY;
	
	public static MedicalSpecialty getFromString(String s) {
		return MedicalSpecialty.valueOf(s);
	}
}
