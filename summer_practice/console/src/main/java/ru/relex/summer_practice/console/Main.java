package ru.relex.summer_practice.console;


import ru.relex.summer_practice.dao.Impl.PersonDaoImpl;

public class Main {
	public static void main( String[] args )
    {
		PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.Create("Александр Сергеевич Мартынов","1111","1111",null,null);
        System.out.println("проверочка");
    }
}
