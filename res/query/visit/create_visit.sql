create table if not exists Visits (
  visit_id integer,
  doctor_username varchar (30),
  patient_username varchar (30),
  date_of_visit date,
  diastolic_pressure int,
  systolic_pressure int,
  billing_amount float,
  foreign key (doctor_username) references Doctors(username),
  foreign key (patient_username) references Patients(username),
  primary key (visit_id)
);