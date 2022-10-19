package com.batuhanberkertekin.telefonrehberi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.batuhanberkertekin.telefonrehberi.data.DataBaseHelper
import com.batuhanberkertekin.telefonrehberi.data.PersonsDao
import com.batuhanberkertekin.telefonrehberi.R
import kotlinx.android.synthetic.main.activity_adding.*

class AddingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)
        val person = PersonsDao()
        val dt = DataBaseHelper(this)
        kayitToolBar.title = "Yeni kayit"
        setSupportActionBar(kayitToolBar)


       kaydetButton.setOnClickListener {

            val name = editNameText.text.toString().trim()
            val number = editNumberText.text.toString().trim()

            if(name.isNotEmpty() && number.isNotEmpty()){

                person.addPerson(dt,name,number.toInt())
                Toast.makeText(applicationContext,"Tebrikler kişiyi kaydettiniz",Toast.LENGTH_SHORT).show()

                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)



            }else{
                Toast.makeText(this,"Lütfen boş alanları boş bırakmayınız", Toast.LENGTH_SHORT).show()
            }



        }






    }
}