package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.conference.service.SignUpService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by Sasha on 19.07.2015.
 */
@Named
@SessionScoped
public class SignUpBean implements Serializable {

    @EJB
    private SignUpService signUpService;

    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String phoneNumber;
    private String email;
    private String code;
    private int step;

    @PostConstruct
    public void init() {
        if(signUpService.getPerson()!=null){
            login = signUpService.getPerson().getLogin();
            email = signUpService.getPerson().getEmail();
            phoneNumber = signUpService.getPerson().getPhoneNumber();
            try {
                String[] fullname = signUpService.getPerson().getFullname().split(" ");
                firstname = fullname [0];
                lastname = fullname [1];
            } catch (Exception e){}
        }
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + firstname + " " + lastname));
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void nextStep(){
        switch (step){
            case 0: signUpService.userStep(login,password); break;
            case 1: signUpService.personStep(firstname,lastname,email,phoneNumber);break;
            case 2: if (!signUpService.confirmationStep(code)){
                step--;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Code not equal!", "Contact admin."));
            } break;
        }
        if(step<=3){
            step++;
        }
    }

    public String complite(){
        signUpService.completionStep();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(login, password);
        } catch (ServletException e) {
            return "error";
        }
        return "success";
    }

    public void getNewCode(){
        signUpService.sendCode();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
