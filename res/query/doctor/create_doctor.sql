create table if not exists Doctors (
  username varchar (30),
  license_number varchar (10),
  first_name varchar (12),
  last_name varchar (18),
  date_of_birth date,
  work_phone varchar (10),
  home_address varchar (100),
  specialty varchar (20),
  room_number varchar (5),
  foreign key (username) references Users(username),
  primary key (username)
);