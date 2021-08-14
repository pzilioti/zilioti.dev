package dev.zilioti.web.dao;

import dev.zilioti.web.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public class PostsDAO implements Serializable {

    @PersistenceContext(unitName = "paoloweb")
    transient private EntityManager entityManager;

    public Post getLastPost() {
        Post lastPost = entityManager.find(Post.class, 1);
        return lastPost;
    }

    public void savePost(Post post){
        entityManager.persist(post);
    }

    public Post getPostByLink(String link){
        return (Post)entityManager.createNamedQuery("getPostByLink").setParameter("link", link).getSingleResult();
    }

    public List<Post> getAllPosts(){
        List<Post> list = entityManager.createNamedQuery("getAllPosts").getResultList();
        list.sort((p1, p2) -> p1.compareTo(p2));
        return list;
    }

}
