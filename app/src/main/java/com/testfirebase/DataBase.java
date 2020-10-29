package com.testfirebase;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;
@IgnoreExtraProperties
public class DataBase {

    List<Object> mNews;

    public List<Object> getNews() {
        return mNews;
    }
    public void setNews(List<Object> news) {
        mNews = news;
    }
}
