package ru.relex.summer_practice.web.rest;

import ru.relex.summer_practice.dao.GenericCrudDao;
import ru.relex.summer_practice.dao.Impl.GenericCrudDaoImplImpl;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.web.service.PersonService;
import ru.relex.summer_practice.web.service.TestService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> printMessage() {
        ArrayList<Person> persons = new ArrayList<>();
        for(Person person : personService.ReadAll()){
            Person p = new Person();
            p.setLogin(person.getLogin());
            p.setPassword(person.getPassword());
            p.setFullname(person.getFullname());
            p.setEmail(person.getEmail());
            p.setPhoneNumber(person.getPhoneNumber());
            p.setId(person.getId());
            persons.add(p);
        }
        return persons;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @Path("/update")
    public Person update(Person person) {
        person =  personService.Update(person);
        Person p = new Person();
        p.setLogin(person.getLogin());
        p.setPassword(person.getPassword());
        p.setFullname(person.getFullname());
        p.setEmail(person.getEmail());
        p.setPhoneNumber(person.getPhoneNumber());
        p.setId(person.getId());
        return p;
    }

}
