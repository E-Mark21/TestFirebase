package com.testfirebase;

public class Data {

    private String name;
    private String description;
    private String url;
    //private String id;

    public String getName() {
        return name;
    }

    public Data() {
    }

    public Data(String name, String description, String url/*, String id*/) {
        this.name = name;
        this.description = description;
        this.url = url;
        //this.id = id;
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

   /* public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/
}
