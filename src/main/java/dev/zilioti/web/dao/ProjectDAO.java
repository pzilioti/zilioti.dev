package dev.zilioti.web.dao;

import dev.zilioti.web.model.Post;
import dev.zilioti.web.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public class ProjectDAO implements Serializable {

    @PersistenceContext(unitName = "paoloweb")
    transient private EntityManager entityManager;

    public Project getProjectById(Long idproject){
        return (Project)entityManager.createNamedQuery("getProjectById").setParameter("idproject", idproject).getSingleResult();
    }

    public List<Project> getAllProjects(){
        List<Project> list = entityManager.createNamedQuery("getAllProjects").getResultList();
        return list;
    }

}
