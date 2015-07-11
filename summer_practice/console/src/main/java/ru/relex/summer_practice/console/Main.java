package ru.relex.summer_practice.console;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ru.relex.summer_practice.db.Person;


public class Main {
	public static void main( String[] args )
    {
		EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();
		em.getTransaction().begin();
        Person t = new Person();
        t.setFullname("name");
        em.merge(t);
        em.getTransaction().commit();
        System.out.println("проверочка");
    }
}
