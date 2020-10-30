package com.testfirebase;


public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainContract.Model model;
    String[] names;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public String[] data() {
        model.loadData();

    }
    @Override
    public String[] returnString() {
        names = model.getAuthorNews();
        return  names;
    }



}
