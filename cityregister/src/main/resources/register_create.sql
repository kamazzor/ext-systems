DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;

CREATE TABLE cr_district (
    district_code integer NOT NULL,
    district_name varchar(300),
    PRIMARY KEY (district_code)

);


CREATE TABLE cr_street
(
    street_code integer NOT NULL,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);

create table cr_address (
    address_id SERIAL,
    district_code integer NOT NULL,
    street_code integer NOT NULL,
    building varchar(10),
    extension varchar(10),
    apartment varchar(10),
    PRIMARY KEY (address_id),
    FOREIGN KEY (street_code) REFERENCES cr_street(street_code) ON DELETE RESTRICT,
    FOREIGN KEY (district_code) REFERENCES cr_district(district_code)  ON DELETE RESTRICT
);

CREATE TABLE cr_person (
    person_id SERIAL,
    sur_name varchar(100) NOT NULL,
    given_name varchar(100) NOT NULL,
    patronymic varchar(100) NOT NULL,
    date_of_birth date NOT NULL,
    passport_seria varchar(10),
    passport_number varchar(10),
    passport_date date NOT NULL,
    certificate_number varchar(10)NULL,
    certificate_date date NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE cr_address_person (
    person_address_id SERIAL,
    address_id integer NOT NULL,
    person_id integer NOT NULL,
    start_date date NOT NULL,
    end_date date,
    PRIMARY KEY (person_address_id),
    FOREIGN KEY (address_id) REFERENCES cr_address(address_id) ON DELETE RESTRICT,
    FOREIGN KEY (person_id) REFERENCES cr_person(person_id)  ON DELETE RESTRICT
);