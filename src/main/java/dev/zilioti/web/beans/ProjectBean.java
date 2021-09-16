package dev.zilioti.web.beans;

import dev.zilioti.web.dao.ProjectDAO;
import dev.zilioti.web.model.Project;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Named
@RequestScoped
public class ProjectBean implements Serializable {

    @Inject
    ProjectDAO projectDAO;

    @Inject
    ContentBean contentBean;

    private List<Project> projectList;
    private Project project;
    private MenuModel model;
    private String titleProject;
    private HashMap<String, String> urlToTitle = new HashMap<>();

    public String getTitleProject() {
        return titleProject;
    }

    public void setTitleProject(String titleProject) {
        this.titleProject = titleProject;
        updateProject(urlToTitle.get(titleProject));
    }

    private void initProjectList() {
        if (projectList == null) {
            setProjectList(projectDAO.getAllProjects());
        }
    }

    private void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public void updateProject(String title){
        for(Project project : projectList){
            if(project.getTitle().equals(title)){
                setProject(project);
                break;
            }
        }
    }
    public boolean haveProject(){
        return project != null;
    }

    public boolean haveLink(){
        if(project == null) return false;
        return project.getLink() != null;
    }
    public boolean haveGithub(){
        if(project == null) return false;
        return project.getGithub() != null;
    }
    public boolean haveImg(){
        if(project == null) return false;
        return project.getUrlImage() != null;
    }

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        initProjectList();
        setUrlToTitle();
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label(contentBean.getContent("projects"))
                .build();
        for(Project project : projectList){
            DefaultMenuItem item = DefaultMenuItem.builder()
                    .value(project.getTitle())
                    //.command("#{projectBean.updateProject(\""+project.getTitle()+"\")}")
                    .url("/projects/"+normalizeUrl(project.getTitle()))
                    //.update("content")
                    .build();
            firstSubmenu.getElements().add(item);
        }
        model.getElements().add(firstSubmenu);
    }

    private void setUrlToTitle(){
        for(Project project : projectList){
            urlToTitle.put(normalizeUrl(project.getTitle()), project.getTitle());
        }
    }

    private String normalizeUrl(String title){
        return title.toLowerCase().replace(".", "_").replace(" ", "_");
    }

    public MenuModel getModel() {
        return model;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
