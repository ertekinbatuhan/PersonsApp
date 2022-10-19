package com.batuhanberkertekin.telefonrehberi.data

import android.annotation.SuppressLint
import android.content.ContentValues
import com.batuhanberkertekin.telefonrehberi.data.DataBaseHelper
import com.batuhanberkertekin.telefonrehberi.data.Person


    class PersonsDao {


        @SuppressLint("Range", "SuspiciousIndentation")
        fun allPerson(dt : DataBaseHelper,) : ArrayList<Person> {


            val wt = dt.writableDatabase
            val allList = ArrayList<Person>()

            val c = wt.rawQuery("SELECT * FROM persons",null)

            while(c.moveToNext()){
                val persons =  Person(c.getInt(c.getColumnIndex("person_id")),
                    c.getString(c.getColumnIndex("person_name")),
                    c.getInt(c.getColumnIndex("person_number")))

                allList.add(persons)
            }


            return allList

        }











        fun addPerson(dt : DataBaseHelper, person_name : String, person_number : Int) {



            val wt = dt.writableDatabase
            val values = ContentValues()
            values.put("person_name",person_name)
            values.put("person_number",person_number)

            wt.insertOrThrow("persons",null,values)

            wt.close()






        }
        fun deleteNot(dt : DataBaseHelper, not_id : Int){

            val wt = dt.writableDatabase

            wt.delete("persons","person_id=?", arrayOf(not_id.toString()))
            wt.close()



        }
    }
