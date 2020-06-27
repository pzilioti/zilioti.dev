package dev.zilioti.web.beans;

import dev.zilioti.web.dao.PostsDAO;
import dev.zilioti.web.model.Post;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
@RequestScoped
public class PostsBean {

    @Inject
    private PostsDAO dao;

    private Post post;
    private List<Post> allPosts;
    private String link;

    public PostsDAO getDao() {
        return dao;
    }

    public void setDao(PostsDAO dao) {
        this.dao = dao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void validateLink(){
        if(link != null){
            setPost(dao.getPostByLink(link));
        }
        if(post == null){
            setAllPosts(dao.getAllPosts());
        }
    }

    public List<Post> getAllPosts() {
        return allPosts;
    }

    public void setAllPosts(List<Post> allPosts) {
        this.allPosts = allPosts;
    }
}
