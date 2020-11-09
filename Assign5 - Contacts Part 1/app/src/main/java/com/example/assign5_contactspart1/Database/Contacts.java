package com.example.assign5_contactspart1.Database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contacts {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name= "name")
    public String name;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name= "email")
    public String email;
    public Contacts(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

}
