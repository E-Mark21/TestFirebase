package com.testfirebase;


import java.util.ArrayList;

public interface MainContract {


    interface View {
        void downloadData();

        void updateAdapter(ArrayList mList);
    }

    interface Presenter {
        void data();

    }

    interface Model {
        void loadData(FirebaseCallback callback);

    }
}
