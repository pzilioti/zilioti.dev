package dev.zilioti.web.model;

import javax.persistence.*;
import java.io.Serializable;


@NamedQueries({
        @NamedQuery(name = "getAllProjects", query = "select p from Project p"),
        @NamedQuery(name = "getProjectById", query = "select p from Project p where p.idproject = :idproject")
})
@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproject;
    @Column(name="url_image")
    private String urlImage;
    private String title;
    private String description;
    private String github;
    private String link;

    public long getIdproject() {
        return idproject;
    }

    public void setIdproject(long idproject) {
        this.idproject = idproject;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
