package ru.relex.summer_practice.conference.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Sasha on 19.07.2015.
 */
@Named
@SessionScoped
public class SignUpBean implements Serializable {

    private int step;

    @PostConstruct
    public void init(){
        step = 0;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void nextStep(){
        this.step++;
    }

    public void previousStep(){
        this.step--;
    }
}
