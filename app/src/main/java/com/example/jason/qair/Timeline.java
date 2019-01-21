package com.example.jason.qair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Timeline extends Activity {

    private ImageButton searchButton,examCreateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        searchButton = findViewById(R.id.search_button);
        examCreateButton = findViewById(R.id.create_button);

        examCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Timeline.this,ExamCreate.class));
            }
        });
    }
}
