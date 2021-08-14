package dev.zilioti.web.beans;

import dev.zilioti.web.model.About;
import dev.zilioti.web.model.Index;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexBean implements Serializable {

    private String currentPage;

    private Integer indexPage;

    @Inject
    private Index index;

    @Inject
    private About about;

    public void toIndex(){
        currentPage = "index";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/paolo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void currentContext(String URI){
        if(URI.contains("index")){
            setCurrentPage("home");
            setIndexPage(0);
        }else if(URI.contains("projects")){
            setCurrentPage("projects");
            setIndexPage(1);
        }
    }

    public boolean verifyPage(String page){
        return currentPage.equals(page);
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

    public Integer getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(Integer indexPage) {
        this.indexPage = indexPage;
    }
}
