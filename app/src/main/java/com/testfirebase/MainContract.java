package com.testfirebase;

public interface MainContract {
    interface View {


    }

    interface Presenter {
        public String[] data();
        public String[] returnString();
    }

    interface Model {
        String[] loadData();
        public String[] getAuthorNews();



    }
}
