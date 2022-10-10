package com.example.assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= adapter(mutableListOf())
        recycler_view.adapter=adapter
        recycler_view.layoutManager= LinearLayoutManager(this)
        btnaddtodo.setOnClickListener {
            val z=ettodolist.text.toString()
            if(z.isNotEmpty()){
                val todo= todo(z)
                adapter.addtodo(todo)
                ettodolist.text.clear()
            }
        }
        buttondel.setOnClickListener {
            adapter.deletedone()
        }
    }
}