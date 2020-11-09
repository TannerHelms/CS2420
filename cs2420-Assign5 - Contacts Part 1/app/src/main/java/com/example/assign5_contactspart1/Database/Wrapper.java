package com.example.assign5_contactspart1.Database;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Wrapper {
    Database database;
    Context context;
    public Wrapper(Context context, String databaseName) {
        this.context = context;
        this.database = Room.databaseBuilder(context.getApplicationContext(), Database.class, databaseName).build();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Contacts> SelectAll() {
        List<Contacts> contacts = new ArrayList<>();
        contacts.addAll(database.getContactsDao().SelectAll());
        return contacts;
    }

    public void Insert(Contacts contact) {
        new Thread(() -> {
            database.getContactsDao().Insert(contact);
            System.out.println("successfully inserted value");
        }).start();
    }
}
