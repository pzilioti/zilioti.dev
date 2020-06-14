package dev.zilioti.web.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "getPostByLink", query = "select p from Post p where p.link = :link"),
        @NamedQuery(name = "getAllPosts", query = "select p from Post p")
})
@Entity
@Table(name = "blogPost")
public class Post implements Serializable {

    @Id
    @Column(name = "idblogPost")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String content;
    private String title;
    private String link;
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
