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

    /***
     * Find {@link Person} in  register_office DB using Person.findPersons named query.
     * @return
     */
    public List<Person> findPersons(){
        Query query = entityManager.createNamedQuery("Person.findPersons");
        query.setParameter("personId", 1L);
        return query.getResultList();
    }

    public Long addPerson(Person person){

        entityManager.persist(person);
        //force person persist to DB immediately
        entityManager.flush();
//        entityManager.detach(person);
        return person.getPersonId();
    }
}
