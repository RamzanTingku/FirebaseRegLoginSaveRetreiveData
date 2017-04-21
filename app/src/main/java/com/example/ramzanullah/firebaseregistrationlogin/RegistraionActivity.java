package com.example.ramzanullah.firebaseregistrationlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistraionActivity extends AppCompatActivity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion);
        txtEmailAddress = (EditText) findViewById(R.id.email_registration);
        txtPassword = (EditText) findViewById(R.id.password_registration);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void btnRegistrationUser(View v) {

        final ProgressDialog progressDialog = ProgressDialog.show(RegistraionActivity.this, "Please wait...", "Processing...", true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(), txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(RegistraionActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegistraionActivity.this, LoginActivity.class);
                            startActivity(i);
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(RegistraionActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}