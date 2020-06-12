package dev.zilioti.web.beans;

import dev.zilioti.web.model.Posts;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PostsBean {

    @Inject
    private Posts post;


    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }
}
