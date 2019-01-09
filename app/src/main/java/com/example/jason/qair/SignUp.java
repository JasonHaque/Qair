package com.example.jason.qair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends Activity {
    private Button SignUp;
    private EditText user_email,user_password,user_confirm_password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progess=new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        SignUp =  findViewById(R.id.sign_up);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        user_confirm_password =findViewById(R.id.user_confirm_password);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }

    public void signup()
    {
        String email_string = user_email.getText().toString();
        String password_string = user_password.getText().toString();
        String confirm_password_string = user_confirm_password.getText().toString();


        if(TextUtils.isEmpty(email_string) || TextUtils.isEmpty(password_string) || TextUtils.isEmpty(confirm_password_string)){
            Toast.makeText(SignUp.this,"Fill in all Required Fields",Toast.LENGTH_LONG).show();
            return;
        }
        if(!password_string.equals(confirm_password_string)){
            Toast.makeText(SignUp.this,"Confirm Password Correctly Hooman",Toast.LENGTH_LONG).show();
            return;
        }

        progess.setTitle("Signing UP");
        progess.show();

        firebaseAuth.createUserWithEmailAndPassword(email_string,password_string)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this,"Success",Toast.LENGTH_LONG).show();
                            progess.dismiss();
                            setContentView(R.layout.activity_account_page);
                        }
                        else {
                            Toast.makeText(SignUp.this,"Failure",Toast.LENGTH_LONG).show();
                        }

                        progess.dismiss();
                    }
                });
    }



}
