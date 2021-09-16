package dev.zilioti.web.beans;

import dev.zilioti.web.dao.ContentDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Map;

@SessionScoped
@Named
public class ContentBean implements Serializable {

    @Inject
    ContentDAO contentDAO;

    Map<String, Map<String, String>> map;
    String locale = "en";

    public Map<String, Map<String, String>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, String>> map) {
        this.map = map;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getContent(String key){
        return map.get(locale).get(key);
    }

    @PostConstruct
    public void init(){
        setMap(contentDAO.getContents());
    }

}
