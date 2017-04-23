package com.example.ramzanullah.firebaseregistrationlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SavingRetreivingData extends AppCompatActivity implements View.OnClickListener {

    private EditText AuthorName, AuthorQuote;
    private Button btnAdd, btnView;
    DatabaseReference databaseAuthors;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_retreiving_data);
        databaseAuthors = FirebaseDatabase.getInstance().getReference("authors");
        AuthorName = (EditText) findViewById(R.id.id_AuthorName);
        AuthorQuote = (EditText) findViewById(R.id.id_AuthorQuote);
        btnAdd = (Button) findViewById(R.id.id_btnAdd);
        btnView = (Button) findViewById(R.id.id_btnView);


        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.id_btnAdd) {
            addAuthor();
        }
        if (v.getId() == R.id.id_btnView) {

            Intent i = new Intent(SavingRetreivingData.this, RetreivedData.class);
            startActivity(i);
        }

    }

    private void addAuthor() {

        String name = AuthorName.getText().toString().trim();
        String quotes = AuthorQuote.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = databaseAuthors.push().getKey();
            Authors author = new Authors(name, quotes);

            databaseAuthors.child(id).setValue(author);

            Toast.makeText(this, "Author added", Toast.LENGTH_SHORT).show();


        } else {

            Toast.makeText(this, "You should enter Author Name", Toast.LENGTH_SHORT).show();
        }

    }


    private void viewAuthor() {

    }


}
