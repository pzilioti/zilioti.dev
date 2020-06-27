package dev.zilioti.web.beans;

import dev.zilioti.web.dao.PostsDAO;
import dev.zilioti.web.model.Post;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;

@Named
@RequestScoped
public class EditorView {

    @Inject
    private PostsDAO dao;

    @Inject
    private Post newPost;


    public Post getNewPost() {
        return newPost;
    }

    public void setNewPost(Post newPost) {
        this.newPost = newPost;
    }

    public void savePost(){
        this.newPost.setDate(LocalDateTime.now());
        this.newPost.setLink(linkfyTitle(newPost.getTitle()));
        dao.savePost(this.newPost);
    }

    private String linkfyTitle(String title){
        String result = title.replaceAll(" ","-");
        result = result.toLowerCase();
        return result;
    }

}
