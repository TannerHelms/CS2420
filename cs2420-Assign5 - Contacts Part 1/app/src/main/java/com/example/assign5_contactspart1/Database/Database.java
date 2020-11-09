package com.example.assign5_contactspart1.Database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.Insert;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.List;
@androidx.room.Database(entities = {Contacts.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract ContactsDao getContactsDao();
}
