package com.example.assign4_drawingtrees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenerateUserSection userSection = new GenerateUserSection(this);
        setContentView(userSection);
        userSection.getButton().setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TreeActivity.class);
            for (String header: userSection.SectionHeaders){
                intent.putExtra(header, userSection.GetEditText(header));
            }

            startActivity(intent);
        });
    }
}