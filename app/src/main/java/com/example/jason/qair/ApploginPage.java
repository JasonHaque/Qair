package com.example.jason.qair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ApploginPage extends Activity {

    private EditText LoginMail,LoginPassword;
    private Button logIn;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applogin_page);

        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        LoginMail= findViewById(R.id.LoginMail);
        LoginPassword=findViewById(R.id.LoginPassword);
        Button signUp = findViewById(R.id.Signup);
        logIn = findViewById(R.id.Login);

        /*if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(ApploginPage.this,AccountPage.class));
        } */

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                startActivity(new Intent(ApploginPage.this,com.example.jason.qair.SignUp.class));
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLogIn();
            }
        });
    }
    private void UserLogIn(){
        String email = LoginMail.getText().toString();
        String password = LoginPassword.getText().toString();

        progressDialog.setTitle("Logging you in");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //progressDialog.dismiss();
                        if (task.isSuccessful()){
                            //finish();
                            progressDialog.dismiss();
                            startActivity(new Intent(ApploginPage.this,com.example.jason.qair.AccountPage.class));
                        }
                    }
                });

    }

}
