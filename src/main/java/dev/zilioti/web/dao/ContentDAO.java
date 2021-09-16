package dev.zilioti.web.dao;

import dev.zilioti.web.model.Content;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
public class ContentDAO implements Serializable {

    @PersistenceContext(unitName = "paoloweb")
    transient private EntityManager entityManager;

    public Map<String, Map<String, String>> getContents(){
        List<Content> list = entityManager.createNamedQuery("getAllContent").getResultList();

        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> localeMapEn = new HashMap<>();
        Map<String, String> localeMapPt = new HashMap<>();
        for(Content content: list){
            if(content.getLocale().equals("en")){
                localeMapEn.put(content.getKey(), content.getValue());
            }else if (content.getLocale().equals("pt")){
                localeMapPt.put(content.getKey(), content.getValue());
            }
        }
        map.put("en", localeMapEn);
        map.put("pt", localeMapPt);
        return map;
    }


}
