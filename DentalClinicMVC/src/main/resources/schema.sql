DROP TABLE IF EXISTS addresses;
CREATE TABLE addresses
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  street   varchar(100) NOT NULL,
  number   INT          NOT NULL,
  location varchar(100) NOT NULL,
  province varchar(100) NOT NULL
);
DROP TABLE IF EXISTS patients;
CREATE TABLE patients
(
  id            INT AUTO_INCREMENT PRIMARY KEY,
  firstName     varchar(100) NOT NULL,
  lastName      varchar(100) NOT NULL,
  email         varchar(100) NOT NULL,
  cardIdentity  INT          NOT NULL,
  admissionDate DATE         NOT NULL,
  address_id    INT          NOT NULL
);
DROP TABLE IF EXISTS dentists;
CREATE TABLE dentists
(
  id           INT AUTO_INCREMENT PRIMARY KEY,
  firstName    varchar(100) NOT NULL,
  lastName     varchar(100) NOT NULL,
  registration INT          NOT NULL
);
INSERT INTO addresses(street, number, location, province)
VALUES ('Calle A', 101, 'Luján de Cuyo', 'Mendoza');
INSERT INTO patients(firstName, lastName, email, cardIdentity, admissionDate, address_id)
VALUES ('Mik', 'Cudi', 'mikcudip@gmail.com', 72474322, '2023-11-10', 1);
INSERT INTO dentists(firstName, lastName, registration)
VALUES ('Doctor', 'Cudi', 123);
