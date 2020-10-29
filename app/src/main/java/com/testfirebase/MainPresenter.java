package com.testfirebase;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainContract.Model model;



    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
    }
}
