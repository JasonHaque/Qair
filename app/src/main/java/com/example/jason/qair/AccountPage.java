package com.example.jason.qair;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.jason.qair.ApploginPage.userID;

public class AccountPage extends Activity {

    private TextView emailtext,textView;
    private ImageButton logout;
    private FirebaseAuth firebaseAuth;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        firebaseAuth = FirebaseAuth.getInstance();
        emailtext = findViewById(R.id.Textview);
        textView=findViewById(R.id.TextviewName);
        logout =findViewById(R.id.Logoutbutton);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        assert firebaseUser != null;
        emailtext.setText("Welcome to your account:\n");
        textView.setText(userID);

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
