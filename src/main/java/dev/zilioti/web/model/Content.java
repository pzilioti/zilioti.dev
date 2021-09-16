package dev.zilioti.web.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getAllContent", query = "select c from Content c")
})
@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcontent;
    private String locale;
    private String key;
    private String value;

    public Long getIdcontent() {
        return idcontent;
    }

    public void setIdcontent(Long idcontent) {
        this.idcontent = idcontent;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
