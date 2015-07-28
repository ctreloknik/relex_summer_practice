package ru.relex.summer_practice.conference.validators;

import ru.relex.summer_practice.service.ConferenceService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Eugene on 27.07.2015.
 */
public class ConferenceValidator implements Validator {

    @EJB
    ConferenceService conferenceService;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (conferenceService.getConferenceByName(o.toString()) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conference already exists",
                    o + " конференция с таким названием уже существут."));
        }
    }
}
