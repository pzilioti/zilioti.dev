package dev.zilioti.web.model;

import javax.annotation.PostConstruct;

public class Posts {

    private String content;
    private long id;
    private String title;
    private String link;

    @PostConstruct
    public void postConstruct(){
        setContent("<h3> This is a test<br><br>" +
                "<p>This is my first blog post</p><br>");
        setLink("this-is-a-test");
        setTitle("This is a test");
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
