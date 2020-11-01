package com.testfirebase;


import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainContract.Model model;
    ArrayList<String> mName;



    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel(this);
        MyClass myClass = new MyClass();
        model.registeredCallback(myClass);
        model.loadData();
    }



    class MyClass implements MainModel.Callback {

        @Override
        public void returnData(ArrayList<String> mList) {
            mName = new ArrayList<>(mList);
            int p = 0;
        }
    }
}
