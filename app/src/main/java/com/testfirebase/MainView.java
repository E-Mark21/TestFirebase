package com.testfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainView extends AppCompatActivity implements ViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("0");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MainModel mainModel = snapshot.getValue(MainModel.class);


                TextView view = findViewById(R.id.textview);
                TextView view1 = findViewById(R.id.text2);
                view.setText(mainModel.name);
                view1.setText(mainModel.description);
                ImageView imageView = findViewById(R.id.image);
                loadImage(mainModel.url, imageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void loadImage(String url, ImageView imageView) {
        Picasso.with(this).
                load(url)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }

}