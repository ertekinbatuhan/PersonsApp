package com.batuhanberkertekin.telefonrehberi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.batuhanberkertekin.telefonrehberi.data.DataBaseHelper
import com.batuhanberkertekin.telefonrehberi.adapter.PersonsAdapter
import com.batuhanberkertekin.telefonrehberi.data.PersonsDao
import com.batuhanberkertekin.telefonrehberi.R
import com.batuhanberkertekin.telefonrehberi.data.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : PersonsAdapter
    private lateinit var person : Person
    private lateinit var personList : ArrayList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dt = DataBaseHelper(this)
        toolbar.title = "Kişileriniz"
        setSupportActionBar(toolbar)

      recylerView.setHasFixedSize(true)

        recylerView.layoutManager= LinearLayoutManager(this)




        personList = PersonsDao().allPerson(dt)
        adapter = PersonsAdapter(applicationContext,personList,dt)
        recylerView.adapter = adapter



        floatingActionButton.setOnClickListener {

            val intent = Intent(this, AddingActivity::class.java)
            startActivity(intent)
        }
    }
}