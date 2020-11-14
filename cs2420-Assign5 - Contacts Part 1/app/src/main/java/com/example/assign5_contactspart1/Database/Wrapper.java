package com.example.assign5_contactspart1.Database;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Query;
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

    public List<Contacts> SelectAll() {
        List<Contacts> contacts = new ArrayList<>();
        contacts.addAll(database.getContactsDao().SelectAll());
        return contacts;
    }

    public void Insert(Contacts contact) {
        new Thread(() -> {
            database.getContactsDao().Insert(contact);
        }).start();
    }

    public Contacts GetID(int id) {
        return database.getContactsDao().FindById(id);
    }

    public void Delete(Contacts contacts) {
        database.getContactsDao().Delete(contacts);
    }
}
