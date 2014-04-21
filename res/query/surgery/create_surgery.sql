create table if not exists Surgeries (
  cpt_code varchar (10),
  surgery_type varchar (30),
  cost_of_surgery float (10),
  primary key (cpt_code)
);