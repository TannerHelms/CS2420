package com.example.assign5_contactspart1.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactsDao {
    @Query("SELECT * FROM CONTACTS")
    List<Contacts> SelectAll();

    @Insert
    void Insert(Contacts contacts);

    @Update
    void Update(Contacts contacts);

}
