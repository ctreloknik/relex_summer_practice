package ru.relex.summer_practice.conference.service;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateful;


/**
 * Created by Sasha on 20.07.2015.
 */

@Stateful
public class SignUpService{

    @EJB
    private PersonService personService;
    @EJB
    CodeSendService codeSendService;

    private Person person = null;


    public void userStep(String login, String password){
        if (person == null){
            person = new Person();
            person.setConfirmed(false);
        }
        person.setLogin(login);
        person.setPassword(password);
        person = personService.Create(person);
    }

    public void personStep(String firstName, String secondName, String email, String phoneNumber){
        person.setFullname(firstName + " " + secondName);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        codeSendService.sendCode(person.getEmail(),"Регистрация на ConferenceManagmentSystem");
    }

    public Boolean confirmationStep(String code){
        return codeSendService.confirmation(code);
    }

    public void sendCode(){
        codeSendService.sendCode(person.getEmail(),"Регистрация на ConferenceManagmentSystem");
    }

    public void completionStep(){
        person.setRole("USER");
        person.setConfirmed(true);
        personService.Update(person);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
