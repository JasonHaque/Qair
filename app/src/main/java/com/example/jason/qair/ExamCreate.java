package com.example.jason.qair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ExamCreate extends Activity {

    private Button CreateExam;
    private RadioButton mcqOption,writtenOption,publicOption,privateOption;
    private EditText examName,examDate;
    public static String examname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_create);
        CreateExam = findViewById(R.id.create_exam);

        mcqOption=findViewById(R.id.mcq_option);
        writtenOption=findViewById(R.id.written_question_option);
        publicOption=findViewById(R.id.public_option);
        privateOption=findViewById(R.id.private_option);
        examName=findViewById(R.id.exam_name);
        examDate=findViewById(R.id.Date_option);

        CreateExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eName=examName.getText().toString();
                String eDate=examDate.getText().toString();

                examname = eName;
                if(TextUtils.isEmpty(eName) || TextUtils.isEmpty(eDate)){
                    Toast.makeText(ExamCreate.this,"Fill up the fields properly",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!(mcqOption.isChecked() || writtenOption.isChecked()) || !(privateOption.isChecked() || publicOption.isChecked())){
                    Toast.makeText(ExamCreate.this,"Fill up the options properly",Toast.LENGTH_LONG).show();
                    return;

                }
                startActivity(new Intent(ExamCreate.this,QuestionCreate.class));
            }
        });
    }
}
