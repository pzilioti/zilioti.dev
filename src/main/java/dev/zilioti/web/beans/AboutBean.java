package dev.zilioti.web.beans;

import dev.zilioti.web.model.About;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AboutBean {

    @Inject
    private About info;

    public About getInfo() {
        return info;
    }

    public void setInfo(About info) {
        this.info = info;
    }
}
