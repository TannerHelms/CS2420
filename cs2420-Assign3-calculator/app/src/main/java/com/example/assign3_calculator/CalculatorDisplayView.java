package com.example.assign3_calculator;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.GridLayout;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class CalculatorDisplayView extends GridLayout {
    private TextViewInterface textViewInterface;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CalculatorDisplayView(Context context, ArrayList<ButtonData> buttonData) {
        super(context);
        setColumnCount(4);
        setBackgroundColor(Color.BLACK);
        buttonData.forEach(data -> {
            if (data.getType() == ButtonData.buttonType.TEXTVIEW){
                TextViewInterface calculatorTextView = new CalculatorTextView(context, data);
                textViewInterface = calculatorTextView;
                addView((View) calculatorTextView);
            } else {
                CalculatorButton calcButton = new CalculatorButton(context, data, textViewInterface);
                addView(calcButton);
            }
        });
    }
}