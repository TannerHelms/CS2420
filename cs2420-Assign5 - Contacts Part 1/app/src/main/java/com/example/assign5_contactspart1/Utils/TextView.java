package com.example.assign5_contactspart1.Utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class TextView extends AppCompatTextView {

    public TextView(@NonNull Context context, String text) {
        super(context);
        setTextSize(25);
        setText(text);
    }
}
