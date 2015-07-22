package ru.relex.summer_practice.conference.validators;

import org.primefaces.validate.ClientValidator;
import ru.relex.summer_practice.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Map;

/**
 * Created by Sasha on 20.07.2015.
 */

@Named
@RequestScoped
public class LoginValidator implements Validator {

    @EJB
    PersonService personService;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (personService.getUserByNickname(o.toString()) != null){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login already exists",
                    o + " пользователь с таким логином уже существут."));
        }
    }

}
