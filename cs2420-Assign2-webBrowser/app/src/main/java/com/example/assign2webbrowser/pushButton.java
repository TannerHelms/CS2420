package com.example.assign2webbrowser;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class pushButton extends AppCompatButton {
    LinearLayout.LayoutParams layoutParamsButton = new LinearLayout.LayoutParams(
            100,
            100
    );
    public pushButton(@NonNull Context context, String text) {
        super(context);
        setText(text);
        setTextScaleX((float) .8);
        setLayoutParams(layoutParamsButton);
    }
}
