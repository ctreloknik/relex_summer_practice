package ru.relex.summer_practice.conference.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * Created by Sasha on 21.07.2015.
 */

@Stateful
public class CodeSendService {

    @EJB
    private EmailService emailService;
    private String code;

    public void sendCode(String email, String title){
        Integer rcode = (100000 + (int)(Math.random()*999999));
        this.code = rcode.toString();
        emailService.send(email, title,"Ваш код подтверждения: " + code );
    }

    public Boolean confirmation(String code){

        return this.code.equals(code);
    }

}
