package dev.zilioti.web.model;

import javax.annotation.PostConstruct;
import java.io.Serializable;

public class About implements Serializable {
    private String description;
    private String linkedin;
    private String email;
    private String github;

    @PostConstruct
    public void postConstruct(){
        setDescription("Hi everyone! My name is Paolo, and I'm from Brazil. While my professional title is developer, I have a wider range of hobbies that go beyond technology. Originally I graduated in International Relations and then moved to the programming field, when I studied Information Systems. Nowadays my main interests are literature, language learning, techonology, video games and some other nerd stuff. I'm always motivated to learn new things, and I consider myself a self-learner for life. Thanks for reading, and feel free to reach out me by email or LinkedIn. ");
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
