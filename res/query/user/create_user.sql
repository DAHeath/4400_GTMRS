create table if not exists Users (
  username varchar (30),
  password char (41) not null,
  primary key (username)
);