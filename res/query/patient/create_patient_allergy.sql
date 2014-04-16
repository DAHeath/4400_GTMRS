create table if not exists PatientAllergies (
  username varchar (30) not null,
  allergy varchar (30) not null,
  foreign key (username) references Patients(username),
  primary key (username, allergy)
);