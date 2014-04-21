create table if not exists PaymentInformation (
  card_number varchar (16),
  cardholder_name varchar (30),
  cvv integer (4),
  date_of_expiry varchar (10),
  type varchar (10),
  primary key (card_number)
);