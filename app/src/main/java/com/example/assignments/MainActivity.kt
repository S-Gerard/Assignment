package com.example.assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments.adapter.ItemAdapter
import com.example.assignments.model.assignment
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: ItemAdapter
    private lateinit var recycler_view: RecyclerView
    private lateinit var btnAddItem: Button
    private lateinit var editText: EditText
    private lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view = findViewById(R.id.recycler_view)
        btnAddItem = findViewById(R.id.btnAddItem)
        editText = findViewById(R.id.editText)
        btnDelete = findViewById(R.id.btnDelete)

        adapter= ItemAdapter(mutableListOf())
        recycler_view.adapter = adapter
        recycler_view.layoutManager= LinearLayoutManager(this)
        btnAddItem.setOnClickListener {
            val z=editText.text.toString()
            if(z.isNotEmpty()){
                val assignment= assignment(z)
                adapter.addItem(assignment)
                editText.text.clear()
            }
        }
        btnDelete.setOnClickListener {
            adapter.deleteChecked()
        }
    }
}