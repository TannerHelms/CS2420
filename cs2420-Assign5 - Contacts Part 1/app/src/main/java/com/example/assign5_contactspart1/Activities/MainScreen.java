package com.example.assign5_contactspart1.Activities;

import android.content.Intent;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assign5_contactspart1.Database.Contacts;

import com.example.assign5_contactspart1.Database.Wrapper;
import com.example.assign5_contactspart1.Utils.Button;
import com.example.assign5_contactspart1.Utils.TextView;

import android.graphics.Color;


import java.util.List;


public class MainScreen extends AppCompatActivity {
    Wrapper database;
    LinearLayout mainLayout;
    LinearLayout contactLayout;
    Button newContact;
    List<Contacts> contacts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new Wrapper(this, "contacts-database");
        setupScreen();
        newContact.setOnClickListener(view -> {
            Intent intent = new Intent(MainScreen.this, NewContact.class);
            startActivity(intent);
        });
    }

    private void setupScreen() {
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(Color.CYAN);
        newContact = new Button(this, "New Contact");
        mainLayout.addView(newContact);
        contactLayout = new LinearLayout(this);
        contactLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(contactLayout);
        setContentView(mainLayout);
        renderScreen();
    }

    private void renderScreen() {
        contactLayout.removeAllViews();
        LinearLayout tmpContactLayout = new LinearLayout(this);
        tmpContactLayout.setOrientation(LinearLayout.VERTICAL);
        contactLayout.addView(tmpContactLayout);
        new Thread(() -> {
            contacts = database.SelectAll();
            runOnUiThread(() -> {
                contacts.forEach(contact -> {
                    TextView textView = new TextView(this, contact.name);
                    textView.setOnClickListener(view -> {
                        Intent intent = new Intent(MainScreen.this, ViewContact.class);
                        intent.putExtra("id", contact.id);
                        startActivity(intent);
                    });
                    tmpContactLayout.addView(textView);
                });
            });
        }).start();
    }
}
