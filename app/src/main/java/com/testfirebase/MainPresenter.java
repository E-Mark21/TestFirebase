package com.testfirebase;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;
    ArrayList<String> mName = new ArrayList<>();

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void data() {
        model.loadData(new FirebaseCallback() {
            @Override
            public void returnData(ArrayList mList) {
                mName = mList;
                updateRV(mList);
            }
        });
    }

    public void updateRV(ArrayList mList) {
        view.updateAdapter(mList);
    }
}
