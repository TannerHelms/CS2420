package com.example.assign1_madlibs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.HashMap;
/*
This assignment is designed to be a basic Java refresher as well as
to get familiar with the Android environment. In this assignment you
will build a simple MadLibs application. MadLibs is an old game where
you are asked to provide a list of words or phrases that match a
specific grammar rule (a noun or a verb for example) and then has
you insert those words into the framework of story. Your assignment
is to develop an application that provides 5 or more text fields that
prompt the user to input words or phrases, then when the user pushes
a button it displays a short story that uses those words. Your story
can be whatever you want but just has to use all of the words. Refer
to the video for an example. Each assignment will list the project
requirements as well as how many points are associated with each requirement.
 */

/*
    This Assignment was developed by Tanner Helms, 10 September 2020
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create a Linear Layout for the main screen
        final LinearLayout layout = new LinearLayout(this);

        // Create layout params for editText
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        // Create an array for all of the fields that I want on my story
        final String[] arrayOfFields = {"Enter A Holiday", "Enter A Noun", "Enter A Place", "Enter A Person", "Enter A Adjective",
        "Enter A Body Part"};

        // Create a Hash Map to store the values of the text Fields
        final HashMap<String, AppCompatEditText> valuesOfEditText = new HashMap<>();

        // Range over the items, create a textView field and editText field
        for (String field : arrayOfFields) {
            // textView
            AppCompatTextView textView= new AppCompatTextView(this);
            textView.setText(field);
            layout.addView(textView);
            // editText
            AppCompatEditText editText = new AppCompatEditText(this);
            editText.setLayoutParams(params);
            layout.addView(editText);
            // Add the editText field to the Hash Map for later use
            valuesOfEditText.put(field, editText);
        }

        // Add a button at the end of the fields
        AppCompatButton button = new AppCompatButton(this);
        button.setText("GENERATE MAD LIB");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout secondScreen = new LinearLayout(MainActivity.this);
                AppCompatTextView story = new AppCompatTextView(MainActivity.this);
                story.setText(writeStory(arrayOfFields, valuesOfEditText));
                secondScreen.addView(story);
                setContentView(secondScreen);
            }
        });
        layout.addView(button);

        layout.setOrientation(LinearLayout.VERTICAL);
        // Set the context to the layout
        this.setContentView(layout);
    }

    public String writeStory(String[] fields, HashMap<String, AppCompatEditText> textFields) {
        Log.d("textFields", String.valueOf(textFields));
        return "I can't Believe it's already " + textFields.get(fields[0]).getText().toString() + "! I can't wait to put on " +
                "my " + textFields.get(fields[1]).getText().toString() + " and visit every " + textFields.get(fields[2]).getText().toString() +
                " in my neighborhood. This year, I am going to dress up as (a) " + textFields.get(fields[3]).getText().toString() +
                " with a " + textFields.get(fields[4]).getText().toString() + " " + textFields.get(fields[5]).getText().toString();
    }
}