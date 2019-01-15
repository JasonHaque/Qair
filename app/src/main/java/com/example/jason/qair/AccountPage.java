package com.example.jason.qair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountPage extends Activity {

    private TextView emailtext;
    private Button logout;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        firebaseAuth = FirebaseAuth.getInstance();
        emailtext = findViewById(R.id.Textview);
        logout =findViewById(R.id.Logoutbutton);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        emailtext.setText("Welcome to your account "+ firebaseUser.getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(AccountPage.this,ApploginPage.class));
            }
        });
    }
}
