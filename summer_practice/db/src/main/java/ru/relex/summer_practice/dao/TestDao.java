package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Person;

import java.util.List;

/**
 * Created by Sasha on 14.07.2015.
 */
public interface TestDao {
    public List<Person> readAll();
}
