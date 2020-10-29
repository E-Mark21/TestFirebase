package com.testfirebase;

public class MainPresenter implements PresenterInterface {
    ViewInterface view;
    MainModel model;

    public MainPresenter(ViewInterface view) {
        this.view = view;
        model = new MainModel();



    }
}
