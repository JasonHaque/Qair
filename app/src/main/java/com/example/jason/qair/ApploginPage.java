package com.example.jason.qair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApploginPage extends Activity {
    private Button SignUp,LogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applogin_page);
        SignUp = findViewById(R.id.Signup);
        LogIn = findViewById(R.id.Login);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_sign_up);
            }
        });
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_account_page);
            }
        });
    }




}
