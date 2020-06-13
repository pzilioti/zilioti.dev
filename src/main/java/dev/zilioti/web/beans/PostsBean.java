package dev.zilioti.web.beans;

import dev.zilioti.web.model.Post;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PostsBean {

    @Inject
    private Post post;


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
