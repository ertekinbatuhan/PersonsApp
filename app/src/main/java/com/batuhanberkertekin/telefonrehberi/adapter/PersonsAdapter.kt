package com.batuhanberkertekin.telefonrehberi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batuhanberkertekin.telefonrehberi.data.DataBaseHelper
import com.batuhanberkertekin.telefonrehberi.R
import com.batuhanberkertekin.telefonrehberi.data.Person
import com.batuhanberkertekin.telefonrehberi.data.PersonsDao
import com.batuhanberkertekin.telefonrehberi.view.AddingActivity
import kotlinx.android.synthetic.main.recyler_view.view.*

class PersonsAdapter(private val mcontext : Context, val personList : ArrayList<Person>, private val dt : DataBaseHelper) : RecyclerView.Adapter<PersonsAdapter.person>() {


    class person(view : View) : RecyclerView.ViewHolder(view){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): person {
        val design = LayoutInflater.from(mcontext).inflate(R.layout.recyler_view,parent,false)
        return person(design)

    }

    override fun onBindViewHolder(holder: person, position: Int) {
        val personList = personList.get(position)

        holder.itemView.nameText.text = personList.person_name
        holder.itemView.numberText.text =personList.person_number.toString()
        holder.itemView.imageView.setImageResource(R.drawable.ic_baseline_call_24)
        holder.itemView.imageView2.setImageResource(R.drawable.ic_baseline_delete_24)
        holder.itemView.imageView2.setOnClickListener {
            PersonsDao().deleteNot(dt,personList.person_id)

            val intent = Intent(mcontext,AddingActivity::class.java)
            mcontext.startActivity(intent)
        }






    }

    override fun getItemCount(): Int {
        return personList.size
    }
}