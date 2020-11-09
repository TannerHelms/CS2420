package com.example.assign5_contactspart1.Activities;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assign5_contactspart1.Database.Contacts;
import com.example.assign5_contactspart1.Database.Database;
import com.example.assign5_contactspart1.Database.Wrapper;
import com.example.assign5_contactspart1.Utils.Button;
import com.example.assign5_contactspart1.Utils.EditText;
import com.example.assign5_contactspart1.Utils.TextView;

import java.util.ArrayList;

public class NewContact extends AppCompatActivity {
    Wrapper database;
    LinearLayout mainLayout;
    Button createButton;
    String[] fields = new String[]{"Name", "Phone Number", "Email"};
    ArrayList<EditText> fieldsVal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new Wrapper(this, "contacts-database");
        fieldsVal = new ArrayList<>();
        setupScreen();
        createButton.setOnClickListener(view -> {
            Contacts contact = new Contacts(fieldsVal.get(0).getText().toString(), fieldsVal.get(1).getText().toString(),
                    fieldsVal.get(2).getText().toString());
            database.Insert(contact);
            Intent intent = new Intent(NewContact.this, MainScreen.class);
            startActivity(intent);
        });
    }

    private void setupScreen() {
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        for (String field : fields) {
            TextView textView = new TextView(this, field);
            mainLayout.addView(textView);
            EditText editText = new EditText(this);
            mainLayout.addView(editText);
            fieldsVal.add(editText);
        }
        createButton = new Button(this,"Create Contact");
        mainLayout.addView(createButton);
        setContentView(mainLayout);
    }

}
