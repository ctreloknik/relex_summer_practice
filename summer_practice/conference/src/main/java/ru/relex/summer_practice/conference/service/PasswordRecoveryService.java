package ru.relex.summer_practice.conference.service;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * Created by Sasha on 21.07.2015.
 */
@Stateful
public class PasswordRecoveryService {

    @EJB
    CodeSendService codeSendService;
    @EJB
    PersonService personService;

    private Person person = null;

    public Boolean sendCode(String email){
        person = personService.getUserByEmail(email);
        if(person == null){
            return false;
        }
        codeSendService.sendCode(email,"Восстановление пароля");
        return true;
    }

    public Boolean recoveryService(String code, String password){
        if (!codeSendService.confirmation(code)){
            return false;
        }
        person.setPassword(password);
        personService.Update(person);
        return true;
    }
}
