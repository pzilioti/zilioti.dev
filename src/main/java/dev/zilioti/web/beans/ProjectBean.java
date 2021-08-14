package dev.zilioti.web.beans;

import dev.zilioti.web.dao.ProjectDAO;
import dev.zilioti.web.model.Project;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProjectBean implements Serializable {

    @Inject
    ProjectDAO projectDAO;

    private List<Project> projectList;
    private Project project;

    private MenuModel model;

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

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        initProjectList();
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Projects")
                .build();
        for(Project project : projectList){
            DefaultMenuItem item = DefaultMenuItem.builder()
                    .value(project.getTitle())
                    .command("#{projectBean.updateProject(\""+project.getTitle()+"\")}")
                    .update("content")
                    .build();
            firstSubmenu.getElements().add(item);
        }
        model.getElements().add(firstSubmenu);
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
