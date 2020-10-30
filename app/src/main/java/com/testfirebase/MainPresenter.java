package com.testfirebase;


import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainContract.Model model;
    public ArrayList<String> mName = new ArrayList<>();


    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void startDB() {
        model.loadData();
    }
    @Override
    public void getData() {
        mName = model.getmList();
    }
}
