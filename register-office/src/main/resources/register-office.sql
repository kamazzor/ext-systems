DROP TABLE IF EXISTS ro_person;
DROP TABLE IF EXISTS ro_passport;

CREATE TABLE ro_person (
    person_id SERIAL,
    sex smallint NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    patronymic varchar(100),
    date_birth date NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id SERIAL,
    person_id integer NOT NULL,
    seria varchar(10) NOT NULL,
    number varchar(10) NOT NULL,
    date_issue date NOT NULL,
    issue_department varchar(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person (sex, first_name, last_name, patronymic, date_birth)
VALUES (1, 'Елена', 'Васильева', 'Сергеевна', '1998-03-24'),
        (2, 'Олег', 'Васильев', 'Петрович', '1997-10-16');

INSERT INTO ro_passport (person_id, seria, number, date_issue, issue_department)
VALUES (1, '40000', '123456', '2018-04-16', 'Test Department passport');

