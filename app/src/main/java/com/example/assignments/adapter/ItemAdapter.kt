package com.example.assignments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments.R
import com.example.assignments.model.assignment

class ItemAdapter(
    private val assignments:MutableList<assignment>

) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(a: View) : RecyclerView.ViewHolder(a)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    fun addItem(item: assignment) {
        assignments.add(item)
        notifyItemInserted(assignments.size - 1)
    }

    fun deleteChecked() {
        assignments.removeAll { assignment ->
            assignment.ischecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val x = assignments[position]
        holder.itemView.apply {
            itemText.text = x.title
            check.isChecked = x.ischecked
            check.setOnCheckedChangeListener { _, ischecked ->
                x.ischecked = !x.ischecked
            }

        }

    }

    override fun getItemCount(): Int {

        return assignments.size

    }
}
