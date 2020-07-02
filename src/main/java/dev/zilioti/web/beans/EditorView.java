package dev.zilioti.web.beans;

import dev.zilioti.web.dao.PostsDAO;
import dev.zilioti.web.model.Post;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.logging.Logger;

@Named
@SessionScoped
public class EditorView implements Serializable {

    @Inject
    transient private PostsDAO dao;

    transient private Logger log = Logger.getLogger(getClass().getName());

    @Inject
    private Post newPost;

    Logger logger = Logger.getLogger(getClass().getName());

    public Post getNewPost() {
        return newPost;
    }

    public void setNewPost(Post newPost) {
        this.newPost = newPost;
    }

    public String savePost(){
        logger.info("ENTROU SAVE POST");
        this.newPost.setDate(LocalDateTime.now());
        this.newPost.setLink(linkfyTitle(newPost.getTitle()));
        dao.savePost(this.newPost);
        return "pretty:posts";
    }

    private String linkfyTitle(String title){
        String result = title.replaceAll(" ","-");
        result = result.toLowerCase();
        return result;
    }

}
