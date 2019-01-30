package com.example.jason.qair;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ShowQuestion extends Activity {

    private Button submitAnswer,NextQuestion;
    private FirebaseFirestore db;
    private CollectionReference examref = db.collection("exam");
    private TextView showQuestionNumber,showQuestionText,showOptionA,showOptionB,showOptionC,showOptionD;
    private EditText Showchoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_question);

        showQuestionNumber = findViewById(R.id.Showquestionnumber);
        showQuestionText = findViewById(R.id.showquestiontext);
        showOptionA= findViewById(R.id.showoptiona);
        showOptionB = findViewById(R.id.showoptionb);
        showOptionC = findViewById(R.id.showoptionc);
        showOptionD = findViewById(R.id.showoptiond);
        Showchoice = findViewById(R.id.showchoiceoption);
        submitAnswer = findViewById(R.id.submit_answer);
        NextQuestion = findViewById(R.id.next_question);

        int a = Integer.parseInt(showQuestionNumber.getText().toString());

        examref.whereEqualTo("questionnumber",a)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot qshot : queryDocumentSnapshots){
                            Question question = qshot.toObject(Question.class);
                            String QuestionText= question.getQuestiontext();
                            String optiona = question.getOptiona();
                            String optionb = question.getOptionb();
                            String optionc = question.getOptionc();
                            String optiond =question.getOptiond();

                            showQuestionText.setText(QuestionText);
                            showOptionA.setText(optiona);
                            showOptionB.setText(optionb);
                            showOptionC.setText(optionc);
                            showOptionD.setText(optiond);
                        }
                    }
                });
    }


}
