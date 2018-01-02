package com.nxs.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 57014
 */
@Component
public class BlogProperties {

    @Value("${com.nxs.blog.name}")
    private String name;
    @Value("${com.nxs.blog.title}")
    private String title;

    @Value("${com.nxs.blog.desc}")
    private String desc;

    @Value("${com.nxs.blog.value}")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
