package com.example.assign5_contactspart1.Utils;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

public class EditText extends AppCompatEditText {

    final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );
    public EditText(@NonNull Context context) {
        super(context);
        setLayoutParams(params);
    }
}
