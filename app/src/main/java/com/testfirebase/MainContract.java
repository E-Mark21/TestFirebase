package com.testfirebase;


import java.util.ArrayList;

public interface MainContract {


    interface View {
        void getData();

        void updateAdapter(ArrayList mList);
    }

    interface Presenter {
        ArrayList data();

    }

    interface Model {
        void loadData(FirebaseCallback callback);

    }
}
