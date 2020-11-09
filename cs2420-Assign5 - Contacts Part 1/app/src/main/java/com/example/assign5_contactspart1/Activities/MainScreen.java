package com.example.assign5_contactspart1.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assign5_contactspart1.Database.Contacts;

import com.example.assign5_contactspart1.Database.Wrapper;
import com.example.assign5_contactspart1.Utils.Button;
import com.example.assign5_contactspart1.Utils.TextView;


import java.util.List;


public class MainScreen extends AppCompatActivity {
    Wrapper database;
    LinearLayout mainLayout;
    LinearLayout contactLayout;
    Button newContact;
    List<Contacts> contacts;
    @RequiresApi(api = Build.VERSION_CODES.N)
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupScreen() {
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        newContact = new Button(this, "New Contact");
        newContact.setOnClickListener(view -> {
            database.Insert(new Contacts("tanner", "", ""));
            renderScreen();
        });
        mainLayout.addView(newContact);
        contactLayout = new LinearLayout(this);
        contactLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(contactLayout);
        setContentView(mainLayout);
        renderScreen();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
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
                    tmpContactLayout.addView(textView);
                });
            });
        }).start();
    }
}
