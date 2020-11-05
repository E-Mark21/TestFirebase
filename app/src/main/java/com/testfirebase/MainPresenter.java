package com.testfirebase;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void getData() {
        model.loadData(new FirebaseCallback() {
            @Override
            public void returnData(ArrayList mName, ArrayList mDescription, ArrayList mUrl) {
                updateRV(mName, mDescription, mUrl);
            }
        });
    }

    public void updateRV(ArrayList mName, ArrayList mDescription, ArrayList mUrl) {
        view.updateAdapter(mName, mDescription, mUrl);
    }
}
