package com.example.assign5_contactspart1.Utils;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class Button extends AppCompatButton {
    public Button(@NonNull Context context, String text) {
        super(context);
        setText(text);
        setWidth(20);
        setBackgroundColor(Color.GREEN);
    }
}
