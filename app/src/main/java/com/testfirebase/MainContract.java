package com.testfirebase;

import java.util.ArrayList;

public interface MainContract {


    interface View {

    }

    interface Presenter {
         void startDB();
        public void getData();
    }

    interface Model {
        public ArrayList<String> getmList();
        void loadData();
    }
}
