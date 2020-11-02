package com.testfirebase;


import java.util.ArrayList;

public interface MainContract {


    interface View {
    void getData();
        void get();
    }

    interface Presenter {
        void data();
        String getList();
    }

    interface Model {
        void loadData(FirebaseCallback callback);

    }
}
