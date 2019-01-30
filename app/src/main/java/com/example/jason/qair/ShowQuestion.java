package com.example.jason.qair;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ShowQuestion extends Activity {


    private TextView textView;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference examref = db.collection("exam");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_question);
        textView = findViewById(R.id.text_view_data);

        examref.orderBy("questionnumber", Query.Direction.ASCENDING)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data="";
                        int count =0;
                        for (QueryDocumentSnapshot dshot : queryDocumentSnapshots){
                            Question question = dshot.toObject(Question.class);

                            int question_number = question.getQuestionnumber();
                            String question_text =question.getQuestiontext();
                            String optionA = question.getOptiona();
                            String optionB = question.getOptionb();
                            String optionC = question.getOptionc();
                            String optionD = question.getOptiond();
                            count++;

                            data += question_number +" "+question_text +"\n"+
                                    "A" + " "+optionA+"\n"+
                                    "B" + " "+optionB+"\n"+
                                    "C" + " "+optionC+"\n"+
                                    "D" + " "+optionD+"\n\n\n";

                            System.out.println(data);

                        }
                        textView.setText(data);
                        System.out.println(count);
                    }
                });
    }

}
