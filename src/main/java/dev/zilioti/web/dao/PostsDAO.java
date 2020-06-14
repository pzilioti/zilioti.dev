package dev.zilioti.web.dao;

import dev.zilioti.web.model.Post;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class PostsDAO {

    @Inject
    private EntityManager entityManager;

    public Post getLastPost() {
        Post lastPost = entityManager.find(Post.class, 1);
        return lastPost;
    }

    public Post getPostByLink(String link){
        return (Post)entityManager.createNamedQuery("getPostByLink").setParameter("link", link).getSingleResult();
    }

    public List<Post> getAllPosts(){
        return entityManager.createNamedQuery("getAllPosts").getResultList();
    }

}
