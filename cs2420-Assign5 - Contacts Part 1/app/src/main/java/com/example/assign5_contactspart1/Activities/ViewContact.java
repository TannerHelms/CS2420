package com.example.assign5_contactspart1.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import com.example.assign5_contactspart1.Database.Contacts;
import com.example.assign5_contactspart1.Database.Wrapper;
import com.example.assign5_contactspart1.Utils.Button;
import com.example.assign5_contactspart1.Utils.TextView;


public class ViewContact extends AppCompatActivity {
    Wrapper database;
    Contacts contact;
    LinearLayout mainLayout;
    Button backButton;
    Button deleteButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new Wrapper(this, "contacts-database");
        Intent intent =  getIntent();
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(Color.CYAN);
        setContentView(mainLayout);
        renderContact(intent.getIntExtra("id", 0));
        backButton = new Button(this, "BACK");
        backButton.setOnClickListener(view -> {
            Intent intent1 = new Intent(ViewContact.this, MainScreen.class);
            startActivity(intent1);
        });
        deleteButton = new Button(this, "DELETE");
        deleteButton.setOnClickListener(view -> {
            new Thread(() -> {
                database.Delete(contact);
            }).start();
            Intent intent1 = new Intent(ViewContact.this, MainScreen.class);
            startActivity(intent1);
        });
        mainLayout.addView(deleteButton);
        mainLayout.addView(backButton);


    }

    private void renderContact(int id) {
        new Thread(() -> {
            contact = database.GetID(id);
            TextView name = new TextView(this, contact.name);;
            mainLayout.addView(name);
            TextView phone = new TextView(this, contact.phone);
            mainLayout.addView(phone);
            TextView email = new TextView(this, contact.email);
            mainLayout.addView(email);
        }).start();
    }
}
