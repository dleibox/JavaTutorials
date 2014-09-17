package com.firststep.hibernate.app;

import com.firststep.hibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by daniel on 9/17/2014.
 */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("jpaData");
            em = emf.createEntityManager();

            Person p = new Person("Jerry", "Mouse");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

            p = new Person("Tom", "Cat");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

            Person peter = new Person("Peter", "Sagan");
            Person nasta = new Person("Nasta", "Kuzminova");

            em.getTransaction().begin();
            em.persist(peter);
            em.persist(nasta);
            em.getTransaction().commit();

            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> persons = query.getResultList();
            persons.forEach(System.out::println);

            query = em.createQuery("from " + Person.class.getName() + " where name=:name", Person.class);
            query.setParameter("name", "Tom");
            System.out.println("Single ==> " + query.getSingleResult());
        } finally {
            if(em != null) em.close();
            if(emf != null) emf.close();
        }
    }
}
