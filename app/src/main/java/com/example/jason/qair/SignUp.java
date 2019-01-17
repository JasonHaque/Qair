package com.example.jason.qair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends Activity {
    private Button SignUp;
    private EditText user_email,user_password,user_confirm_password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progess;
    private DatabaseReference Database;

    RadioButton TeacherOption,StudentOption;
    public String Occupation="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progess=new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        Database = FirebaseDatabase.getInstance().getReference("/Account/");
        SignUp =  findViewById(R.id.sign_up);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        user_confirm_password =findViewById(R.id.user_confirm_password);
        TeacherOption = findViewById(R.id.Teacher_option);
        StudentOption = findViewById(R.id.Student_option);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        TeacherOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Occupation = "Teacher";
                System.out.println(Occupation);
            }
        });

        StudentOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Occupation = "Student";
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
                            saveData();
                            finish();
                            startActivity(new Intent(com.example.jason.qair.SignUp.this,AccountPage.class));
                        }
                        else {
                            Toast.makeText(SignUp.this,"Failure",Toast.LENGTH_LONG).show();
                            progess.dismiss();
                        }


                    }
                });
    }

    public void saveData()
    {
        String email_string = user_email.getText().toString();

        String id = Database.push().getKey();

        Accounts account = new Accounts(email_string,Occupation,id);

        System.out.println(email_string+" "+ Occupation + " "+ id);

        Database.child(id).setValue(Occupation);

    }



}
