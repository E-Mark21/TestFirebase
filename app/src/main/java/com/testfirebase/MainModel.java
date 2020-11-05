package com.testfirebase;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainModel implements MainContract.Model {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("News");
    public ArrayList<String> mName = new ArrayList<>();
    public ArrayList<String> mDescription = new ArrayList<>();
    public ArrayList<String> mUrl = new ArrayList<>();


    @Override
    public void loadData(FirebaseCallback callback) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Data data = ds.getValue(Data.class);
                    mName.add(data.name);
                    mDescription.add(data.description);
                    mUrl.add(data.url);
                    callback.returnData(mName, mDescription, mUrl);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}