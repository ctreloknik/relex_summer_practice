package ru.relex.summer_practice.web.rest;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.web.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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

}
