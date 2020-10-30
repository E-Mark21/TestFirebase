package com.testfirebase;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainModel implements MainContract.Model {

    public ArrayList<String> name1;
    public ArrayList<String> description;
    public ArrayList<String> url;
    String[] authorNews = new String[100];

    public MainModel() {
    }

    @Override
    public String[] loadData() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("News");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    int count = 0;
                    Data data = ds.getValue(Data.class);
                    authorNews[count] = data.name;
                    count++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return authorNews;
    }

    @Override
    public String[] getAuthorNews() {
        return authorNews;
    }
}