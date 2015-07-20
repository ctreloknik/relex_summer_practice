package ru.relex.summer_practice.conference.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

/**
 * Created by Sasha on 18.07.2015.
 */

@Named
@SessionScoped
public class UserBean implements Serializable {

    @PostConstruct
    public void init(){
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "success";
    }
}
