package ru.relex.summer_practice.web.rest;

import ru.relex.summer_practice.web.service.LectureService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by Nikita on 15.07.2015.
 */

@Path("/lectures")
@Stateless
public class LectureRest {
    @EJB
    LectureService lectureService;


}
