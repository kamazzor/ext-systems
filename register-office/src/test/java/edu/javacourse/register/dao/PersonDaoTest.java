package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();
        persons.forEach(person -> {
            System.out.println("Name: " + person.getFirstName());
            System.out.println("Class for sex: " + person.getClass().getName());
            System.out.println("Passports: " + person.getPassports().size());
            System.out.println("Person birth certificate: " + person.getBirthCertificate());
//            if (person instanceof PersonMale) {
//                System.out.println("PersonMale (as Father) linked birth certificates size: " +
//                        ((PersonMale) person).getBirthCertificates().size());
//                System.out.println("PersonMale (as Father) linked marriage certificates size: " +
//                        ((PersonMale) person).getMarriageCertificates().size());
//            } else {
//                System.out.println("PersonFemale (as Mother) linked birth certificates size: " +
//                        ((PersonFemale) person).getBirthCertificates().size());
//                System.out.println("PersonFemale (as Mother) linked marriage certificates size: " +
//                        ((PersonFemale) person).getMarriageCertificates().size());
//            }
        });
    }
}