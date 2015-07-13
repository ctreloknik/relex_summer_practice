package ru.relex.summer_practice.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sasha on 13.07.2015.
 */
public class Singleton {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");

    public static EntityManager CreateEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }
}
