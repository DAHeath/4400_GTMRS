create table if not exists DoctorAvailabilities (
  doctor_username varchar (30),
  start_time varchar (10),
  end_time varchar (10),
  day varchar (10),
  foreign key (doctor_username) references Doctors(username),
  primary key (doctor_username, start_time, end_time, day)
);