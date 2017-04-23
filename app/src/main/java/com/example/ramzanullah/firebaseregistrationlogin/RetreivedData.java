package com.example.ramzanullah.firebaseregistrationlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetreivedData extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseAuthors;
    List<Authors> authors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreived_data);
        databaseAuthors = FirebaseDatabase.getInstance().getReference("authors");
        authors = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
    }

    protected void onStart() {
        super.onStart();
        databaseAuthors.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                authors.clear();
                for (DataSnapshot authorSnapdhot:dataSnapshot.getChildren()) {
                    Authors author = authorSnapdhot.getValue(Authors.class);
                    authors.add(author);
                }
                AdapterClass adapter = new AdapterClass(RetreivedData.this,authors);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
