package ru.relex.summer_practice.web.rest;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

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
        return personService.ReadAll();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @Path("/update")
    public Person update(Person person) {
        return personService.Update(person);
    }

}
