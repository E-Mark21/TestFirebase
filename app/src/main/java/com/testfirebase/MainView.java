package com.testfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainView extends AppCompatActivity implements ViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment mainFragment = fragmentManager.findFragmentById(R.id.activity_main);
        if (mainFragment == null) {
            mainFragment = new FragmentMainView();
            fragmentManager.beginTransaction().add(R.id.activity_main, mainFragment).commit();
        }
    }
}