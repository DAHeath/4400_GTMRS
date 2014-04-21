create table if not exists VisitDiagnoses (
  visit_id int,
  diagnosis varchar (100),
  foreign key (visit_id) references Visits(visit_id),
  primary key (visit_id, diagnosis)
);