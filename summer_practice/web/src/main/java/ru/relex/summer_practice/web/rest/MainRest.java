package ru.relex.summer_practice.web.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.InputStream;

/**
 * Created by Sasha on 14.07.2015.
 */
@Path("/")
@Stateless
public class MainRest {
    @GET
    public InputStream mainPage(){
        return MainRest.class.getResourceAsStream("/pages/index.html");
    }
}
