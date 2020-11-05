package com.testfirebase;


import java.util.ArrayList;

public interface MainContract {


    interface View {
        void downloadData();

        void updateAdapter(ArrayList mName, ArrayList mDescription, ArrayList mUrl);
    }

    interface Presenter {
        void getData();

    }

    interface Model {
        void loadData(FirebaseCallback callback);
    }
}
