package com.batuhanberkertekin.telefonrehberi.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context : Context) : SQLiteOpenHelper(context,"persons",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE persons(person_id INTEGER PRIMARY KEY AUTOINCREMENT,person_name VARCHAR ,person_number INTEGER);")


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS persons")

        onCreate(db)

    }


}