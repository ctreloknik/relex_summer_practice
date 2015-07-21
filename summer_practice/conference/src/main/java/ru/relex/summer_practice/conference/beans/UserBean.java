package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.conference.service.CodeSendService;
import ru.relex.summer_practice.conference.service.PasswordRecoveryService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Sasha on 18.07.2015.
 */

@Named
@SessionScoped
public class UserBean implements Serializable {

    private String email = null;
    private String password1;
    private String password2;
    private String code;

    @EJB
    PasswordRecoveryService passwordRecoveryService;

    @PostConstruct
    public void init(){
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "success";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void sendCode(){
        if (!passwordRecoveryService.sendCode(this.email)){
            email = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User with this email not found", "Contact admin."));
        }
    }

    public String passwordRecovery(){
        if(password1.equals(password2)){
            if (!passwordRecoveryService.recoveryService(code, password1)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Code not equal!", "Contact admin."));
            } else {
                return "success";
            }
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password not equal!", "Contact admin."));
        }
        return null;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
