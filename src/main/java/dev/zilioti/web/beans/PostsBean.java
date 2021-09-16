package dev.zilioti.web.beans;

import dev.zilioti.web.dao.PostsDAO;
import dev.zilioti.web.model.Post;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

@Named
@RequestScoped
public class PostsBean {

    @Inject
    private PostsDAO dao;

    private Post latestPost;

    public Post getLatestPost() {
        return latestPost;
    }

    public void setLatestPost(Post latestPost) {
        this.latestPost = latestPost;
    }

    @PostConstruct
    public void init() {
        if(latestPost == null){
            latestPost = dao.getLastestPost();
        }
    }
}
