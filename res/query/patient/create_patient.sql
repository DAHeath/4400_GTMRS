create table if not exists Patients(
  username varchar (30) NOT NULL,
  name varchar (30),
  date_of_birth varchar (10),
  gender varchar (1),
  address varchar (100),
  work_phone varchar (10),
  home_phone varchar (10),
  emergency_contact_name varchar (30),
  emergency_contact_phone varchar (10),
  weight float (7),
  height float (7),
  annual_income integer (7),
  card_number varchar (16),
  foreign key (username) references Users(username),
  primary key (username)
);