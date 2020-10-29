package com.example.assign4_drawingtrees;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class TreeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        HashMap<String, Integer> drawParams = new HashMap<>();
        GenerateUserSection generateUserSection = new GenerateUserSection(this);
        for (String header: generateUserSection.SectionHeaders){
            drawParams.put(header, intent.getIntExtra(header, 0));
        }
        DrawingView drawingView = new DrawingView(this, drawParams);
        setContentView(drawingView);
    }
}
