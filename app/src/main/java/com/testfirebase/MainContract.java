package com.testfirebase;


public interface MainContract {


    interface View {

    }

    interface Presenter {

    }

    interface Model {
         void loadData();
        void registeredCallback(MainModel.Callback callback);

    }
}
