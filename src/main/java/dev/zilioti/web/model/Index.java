package dev.zilioti.web.model;

import javax.annotation.PostConstruct;
import java.io.Serializable;

public class Index implements Serializable {
    private String name;
    private String welcomeString;

    @PostConstruct
    public void postConstruct(){
        setName("Paolo Zilioti");
        setWelcomeString("\tThis is my personal page. It's meant to be a portfolio where I demonstrate my projects and blog about what's going on in my mind.\n\tThe main topics I will be discusing are programming, mostly things related to Java and Python, and language learning, where my focus will be in Chinese and Japanese.\n\tI hope you'll like my content, and please reach me in my email if you have anything that you want to discuss with me.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWelcomeString() {
        return welcomeString;
    }

    public void setWelcomeString(String welcomeString) {
        this.welcomeString = welcomeString;
    }
}
