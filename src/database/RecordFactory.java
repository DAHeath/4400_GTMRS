package database;

import doctor.Doctor;
import doctor.DoctorAvailability;
import doctor.DoctorRating;
import patient.Patient;
import patient.PatientAllergy;
import payment.PaymentInformation;
import surgery.PreoperativeMedication;
import surgery.Surgery;
import user.User;
import visit.Visit;
import visit.VisitDiagnosis;

public class RecordFactory {

  public String[] getAttributeNames(String type) {
    String[] attributeNames = null;
    if (type.equals("user"))
      attributeNames = User.attributeNames;
    else if (type.equals("doctor"))
      attributeNames = Doctor.attributeNames;
    else if (type.equals("doctor_availability"))
      attributeNames = DoctorAvailability.attributeNames;
    else if (type.equals("doctor_rating"))
      attributeNames = DoctorRating.attributeNames;
    else if (type.equals("patient"))
      attributeNames = Patient.attributeNames;
    else if (type.equals("patient_allergy"))
      attributeNames = PatientAllergy.attributeNames;
    else if (type.equals("payment_information"))
      attributeNames = PaymentInformation.attributeNames;
    else if (type.equals("surgery"))
      attributeNames = Surgery.attributeNames;
    else if (type.equals("preoperative_medication"))
      attributeNames = PreoperativeMedication.attributeNames;
    else if (type.equals("visit"))
      attributeNames = Visit.attributeNames;
    else if (type.equals("visit_diagnosis"))
      attributeNames = VisitDiagnosis.attributeNames;
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
    else if (type.equals("doctor_rating"))
      record = new DoctorRating(values);
    else if (type.equals("patient"))
      record = new Patient(values);
    else if (type.equals("patient_allergy"))
      record = new PatientAllergy(values);
    else if (type.equals("payment_information"))
      record = new PaymentInformation(values);
    else if (type.equals("surgery"))
      record = new Surgery(values);
    else if (type.equals("preoperative_medication"))
      record = new PreoperativeMedication(values);
    else if (type.equals("visit"))
      record = new Visit(values);
    else if (type.equals("visit_diagnosis"))
      record = new VisitDiagnosis(values);
    return record;
  }
}
