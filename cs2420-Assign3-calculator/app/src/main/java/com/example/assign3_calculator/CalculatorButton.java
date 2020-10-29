package com.example.assign3_calculator;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

public class CalculatorButton extends AppCompatButton {
    private ButtonData data;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CalculatorButton(@NonNull Context context, ButtonData buttonData, TextViewInterface textViewInterface) {
        super(context);
        this.data = buttonData;
        setText(data.getButtonText());
        setBackgroundColor(data.getColor());
        setTextSize(40);
        setTextColor(Color.WHITE);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.getRow(), 1, 1f);
        params.columnSpec = GridLayout.spec(data.getColumn(), data.getSize(), 1f);
        params.setMargins(3,3,3,3);
        setLayoutParams(params);
        setOnClickListener(view -> {
            textViewInterface.addText(data.getButtonText());
        });
    }
}
