package com.example.jason.qair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class QuestionCreate extends Activity {

    private ImageButton questionCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_create);

        questionCreate = findViewById(R.id.question_button);

        questionCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuestionCreate.this,"Question Created",Toast.LENGTH_LONG).show();
            }
        });
    }
}
