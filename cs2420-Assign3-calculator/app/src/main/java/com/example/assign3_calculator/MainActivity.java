package com.example.assign3_calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ButtonData> buttonData = new ArrayList<ButtonData>(){
        {
            add(new ButtonData("", 0,0,3, Color.WHITE, ButtonData.buttonType.TEXTVIEW));
            add(new ButtonData("C", 3,0, 1, Color.RED));
            add(new ButtonData("7", 0,1, 1, Color.GRAY));
            add(new ButtonData("8", 1,1, 1, Color.GRAY));
            add(new ButtonData("9", 2,1, 1, Color.GRAY));
            add(new ButtonData("/", 3,1, 1, Color.RED));
            add(new ButtonData("4", 0,2, 1, Color.GRAY));
            add(new ButtonData("5", 1,2, 1, Color.GRAY));
            add(new ButtonData("6", 2,2, 1, Color.GRAY));
            add(new ButtonData("*", 3,2, 1, Color.RED));
            add(new ButtonData("1", 0,3, 1, Color.GRAY));
            add(new ButtonData("2", 1,3, 1, Color.GRAY));
            add(new ButtonData("3", 2,3, 1, Color.GRAY));
            add(new ButtonData("-", 3,3, 1, Color.RED));
            add(new ButtonData("0", 0,4, 2, Color.GRAY));
            add(new ButtonData(".", 2,4, 1, Color.GRAY));
            add(new ButtonData("+", 3,4, 1, Color.RED));
            add(new ButtonData("=", 0,5, 4, Color.RED));
        }
    };


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalculatorDisplayView calculatorDisplayView = new CalculatorDisplayView(this, buttonData);
        setContentView(calculatorDisplayView);
    }

}