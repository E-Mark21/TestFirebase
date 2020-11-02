package com.testfirebase;

public class MainPresenter implements MainContract.Presenter, FirebaseCallback {

    private MainContract.View view;
    private MainContract.Model model;
    FirebaseCallback mFirebaseCallback;
    String s;


    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
        int i = 0;

    }

    @Override
    public void data() {
        model.loadData(mFirebaseCallback);
    }

    @Override
    public String getList() {
        return s;
    }

    @Override
    public void returnData(String string) {

    }
}
