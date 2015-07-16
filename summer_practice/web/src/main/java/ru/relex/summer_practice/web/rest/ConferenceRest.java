package ru.relex.summer_practice.web.rest;

import ru.relex.summer_practice.service.ConferenceService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by Nikita on 15.07.2015.
 */
@Path("/conferences")
@Stateless
public class ConferenceRest {
    @EJB
    ConferenceService conferenceService;


}
