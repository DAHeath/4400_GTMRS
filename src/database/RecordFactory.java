package database;

import doctor.Doctor;
import doctor.DoctorAvailability;
import patient.Patient;
import patient.PatientAllergy;
import user.User;

public class RecordFactory {

  public String[] getAttributeNames(String type) {
    String[] attributeNames = null;
    if (type.equals("user"))
      attributeNames = User.attributeNames;
    else if (type.equals("doctor"))
      attributeNames = Doctor.attributeNames;
    else if (type.equals("doctor_availability"))
      attributeNames = DoctorAvailability.attributeNames;
    else if (type.equals("patient"))
      attributeNames = Patient.attributeNames;
    else if (type.equals("patient_allergy"))
      attributeNames = PatientAllergy.attributeNames;
    return attributeNames;
  }

  public ActiveRecord buildRecord(String type, String[] values) {
    ActiveRecord record = null;
    if (type.equals("user"))
      record = new User(values);
    else if (type.equals("doctor"))
      record = new Doctor(values);
    else if (type.equals("doctor_availability"))
      record = new DoctorAvailability(values);
    else if (type.equals("patient"))
      record = new Patient(values);
    else if (type.equals("patient_allergy"))
      record = new PatientAllergy(values);
    return record;
  }
}
