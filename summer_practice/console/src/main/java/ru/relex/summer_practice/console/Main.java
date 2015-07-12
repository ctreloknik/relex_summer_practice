package ru.relex.summer_practice.console;


import ru.relex.summer_practice.dao.Impl.PersonDaoImpl;
import ru.relex.summer_practice.db.Person;

public class Main {
	public static void main( String[] args )
    {
		PersonDaoImpl personDao = new PersonDaoImpl();
        System.out.print(personDao.ReadAll());
    }
}
