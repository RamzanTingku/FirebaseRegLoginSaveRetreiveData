package com.example.ramzanullah.firebaseregistrationlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mEmail = (TextView) findViewById(R.id.email_Profile);
        mEmail.setText(getIntent().getExtras().getString("Email"));
    }
}
