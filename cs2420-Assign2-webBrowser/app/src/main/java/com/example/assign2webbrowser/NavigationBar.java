package com.example.assign2webbrowser;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;

public class NavigationBar extends LinearLayout {
    pushButton previous = new pushButton(getContext(), "P");
    pushButton forward = new pushButton(getContext(), "F");
    AppCompatEditText url = new AppCompatEditText(getContext());
    pushButton go = new pushButton(getContext(), "G");
    LinearLayout.LayoutParams layoutParamsUrl = new LinearLayout.LayoutParams(
            750,
            170
    );
    public NavigationBar(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        addView(previous);
        addView(forward);
        addView(url);
        addView(go);
        url.setLayoutParams(layoutParamsUrl);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
    }
}
