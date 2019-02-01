package com.example.jason.qair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import java.sql.Time;

public class Timeline extends Activity {

    private ImageButton searchButton,examCreateButton;
    private BottomNavigationView bottomNav;
    private BottomNavigationItemView home,activity_log,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        bottomNav = findViewById(R.id.navigation);
        searchButton = findViewById(R.id.search_button);
        examCreateButton = findViewById(R.id.create_button);

        profile = findViewById(R.id.Profile);

        examCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Timeline.this,ExamCreate.class));
            }
        });

        bottomNav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                    if(menuItem.getItemId() == R.id.Profile) {
                        startActivity(new Intent(Timeline.this,AccountPage.class));
                    }
                    else if(menuItem.getItemId() == R.id.LogIcon) {
                        startActivity(new Intent(Timeline.this,LogActivity.class));
                }
            }
        });
    }
}
