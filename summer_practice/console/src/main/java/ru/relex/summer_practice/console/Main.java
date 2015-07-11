package ru.relex.summer_practice.console;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
	public static void main( String[] args )
    {
		EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();
		em.getTransaction().begin();
        test t = new test();
        t.setName("проверка");
        em.merge(t);
        em.getTransaction().commit();
        System.out.println("проверочка");
    }
}
