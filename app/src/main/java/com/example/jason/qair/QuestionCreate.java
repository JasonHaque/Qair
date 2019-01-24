package com.example.jason.qair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionCreate extends Activity {

    private ImageButton questionCreate;
    private TextView QuestionNumber;
    private EditText questiontext,optionA,optionB,optionC,optionD,ChoiceOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_create);

        questionCreate = findViewById(R.id.question_button);
        QuestionNumber = findViewById(R.id.Question_number_view);
        questiontext = findViewById(R.id.Question_text);
        optionA = findViewById(R.id.OptionA);
        optionB = findViewById(R.id.OptionB);
        optionC = findViewById(R.id.OptionC);
        optionD = findViewById(R.id.OptionD);
        ChoiceOption = findViewById(R.id.OptionChoice);


        questionCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=QuestionNumber.getText().toString();
                int b = Integer.parseInt(a)+1;
                QuestionNumber.setText(String.valueOf(b));
                questiontext.setText("");
                optionA.setText("");
                optionB.setText("");
                optionC.setText("");
                optionD.setText("");
                ChoiceOption.setText("");
                Toast.makeText(QuestionCreate.this,"Question Created",Toast.LENGTH_LONG).show();
            }
        });
    }
}
