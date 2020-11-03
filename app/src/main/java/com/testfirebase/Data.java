package com.testfirebase;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Data {

     String name;
     String description;
     String url;


    public Data() {
    }

    public Data(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
