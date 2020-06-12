package dev.zilioti.web.model;

import javax.annotation.PostConstruct;

public class About {
    private String description;
    private String linkedin;
    private String email;
    private String github;

    @PostConstruct
    public void postConstruct(){
        setDescription("This is my about section. I should talk about me here. I think about two lines should be enough, so I'm need to be creative about it, right?");
        setLinkedin("http://www.linkedin.com/in/pzilioti");
        setEmail("paolo@zilioti.dev");
        setGithub("https://github.com/pzilioti");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
