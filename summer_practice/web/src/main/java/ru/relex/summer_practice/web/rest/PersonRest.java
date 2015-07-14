package ru.relex.summer_practice.web.rest;

import ru.relex.summer_practice.dao.GenericCrudDao;
import ru.relex.summer_practice.dao.Impl.GenericCrudDaoImplImpl;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.web.service.PersonService;
import ru.relex.summer_practice.web.service.TestService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Sasha on 14.07.2015.
 */
@Path("/allperson")
@Stateless
public class PersonRest{

    @EJB
    PersonService personService;

    @GET
    public Response printMessage() {
        String result = "All person:\n";
        for (Person person : personService.ReadAll()){
           result+=person.getLogin() + "\n";
        }
        return Response.status(200).entity(result).build();
    }
/*
    @Override
    public Person Create(Person person) {
        return null;
    }

    @Override
    public Person Read(Long id) {
        return null;
    }

    @Override
    public Person Update(Person person) {
        return null;
    }

    @Override
    public void Delete(Long id) {

    }

    @Override
    public List<Person> ReadAll() {
        return null;
    }*/
}
