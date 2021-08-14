package dev.zilioti.web.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ThemeBean implements Serializable {
    private String theme = "saga";
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTheme() {
        return theme;
        //return checked ? "vela" : "saga";
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void updateTheme(){
        if (checked) {
            setTheme("vela");
        } else {
            setTheme("saga");
        }
    }
}
