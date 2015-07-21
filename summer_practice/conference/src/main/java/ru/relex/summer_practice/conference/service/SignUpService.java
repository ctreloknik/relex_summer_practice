package ru.relex.summer_practice.conference.service;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sasha on 20.07.2015.
 */

@Stateful
public class SignUpService{

    @EJB
    private PersonService personService;
    @EJB
    private EmailService emailService;

    private Person person = null;
    private String code;


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
        sendCode();
    }

    public void sendCode(){
        Integer rcode = (100000 + (int)(Math.random()*999999));
        this.code = rcode.toString();
        emailService.send(person.getEmail(), "Регистрация на Conference Managment System","Ваш код подтверждения: " + code );
    }

    public Boolean confirmationStep(String code){

        return this.code.equals(code);
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
