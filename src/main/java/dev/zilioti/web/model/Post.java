package dev.zilioti.web.model;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Post {

    String title;
    ZonedDateTime published;
    String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ZonedDateTime getPublished() {
        return published;
    }

    public String publishedFormatted(){
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.appendPattern("yyyy-MM-dd");
        DateTimeFormatter fmt = builder.toFormatter();
        return published.format(fmt);
    }

    public void setPublished(ZonedDateTime published) {
        this.published = published;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
