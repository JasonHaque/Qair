package com.example.jason.qair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamCreate extends Activity {

    private Button CreateExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_create);
        CreateExam = findViewById(R.id.create_exam);

        CreateExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamCreate.this,QuestionCreate.class));
            }
        });
    }
}
