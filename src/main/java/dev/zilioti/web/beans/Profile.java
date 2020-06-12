package dev.zilioti.web.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Profile {

    private String name = "Paolo";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Bean executado");
        setName("Paolo");
    }
}
