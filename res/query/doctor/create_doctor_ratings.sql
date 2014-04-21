create table if not exists DoctorRatings (
  doctor_username varchar (30),
  patient_username varchar (30),
  rating integer (1),
  foreign key (doctor_username) references Doctors(username),
  foreign key (patient_username) references Patients(username),
  primary key (doctor_username)
);