package ru.relex.summer_practice.console;

import ru.relex.summer_practice.dao.Impl.PersonDaoImplImpl;
import ru.relex.summer_practice.dao.Impl.RolesDaoImplImpl;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Roles;

import java.util.ArrayList;

/**
 * Created by Nikita on 13.07.2015.
 */
public class DBModuleTest {
    public static void personTest(){
        PersonDaoImplImpl personDao = new PersonDaoImplImpl();
        Person person = new Person();

        System.out.println("!!!!!!!!! THAT IS WORKING !!!!!!!!!");
        person.setLogin("Nik");
        person.setFullname("Anything FIO");
        person.setPassword("1234");
        person.setEmail("aa@aa.aa");
        person.setPhoneNumber("12345678");
        personDao.Create(person);

        System.out.println("!!!!!!!!!!  ONE PERSON ADDED !!!!!!!!!!!!!!!!");

        person.setLogin("Sasha");
        person.setFullname("Anything FIO 2");
        person.setPassword("43211");
        person.setEmail("aa1@aa.aa");
        person.setPhoneNumber("13245566");
        personDao.Create(person);

        System.out.println("!!!!!!!!!!  TWO PERSON ADDED !!!!!!!!!!!!!!!!");

        ArrayList<Person> persons = (ArrayList<Person>)personDao.ReadAll();
        for (Person out : persons)
        System.out.print(out.toString());
    }

    public static void RolesTest(){
        RolesDaoImplImpl roles = new RolesDaoImplImpl();
        Roles role = new Roles();

        System.out.println("!!!!!!!!! THAT IS WORKING !!!!!!!!!");
        role.setName("Создатель конференции");
        roles.Create(role);

        System.out.println("!!!!!!!!!!  ONE ROLE ADDED !!!!!!!!!!!!!!!!");

        System.out.println("!!!!!!!!! THAT IS WORKING !!!!!!!!!");
        role.setName("Докладчик");
        roles.Create(role);

        System.out.println("!!!!!!!!!!  TWO ROLE ADDED !!!!!!!!!!!!!!!!");

        ArrayList<Roles> getRoles = (ArrayList<Roles>)roles.ReadAll();
        for (Roles out : getRoles)
            System.out.print(out.toString()+ "\n");
    }
}
