create table if not exists PreoperativeMedications (
  cpt_code varchar (10),
  preoperative_medication varchar (50),
  foreign key (cpt_code) references Surgeries(cpt_code),
  primary key (cpt_code, preoperative_medication)
);