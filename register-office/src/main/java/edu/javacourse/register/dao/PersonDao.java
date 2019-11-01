package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;

import javax.persistence.*;
import java.util.List;

public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

//    public PersonDao() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
//        entityManager = factory.createEntityManager();
//    }

    public List<Person> findPersons(){
        Query query = entityManager.createNamedQuery("Person.findPersons");
        query.setParameter("personId", 1L);
        return query.getResultList();
    }
}
