package com.example.todoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.example.todoapp.data.Todo
import com.example.todoapp.databinding.ItemTodoBinding

class TodoAdapter(private val onClick: (Todo) -> Unit) :
    ListAdapter<Todo, TodoAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(old: Todo, new: Todo) = old.id == new.id
            override fun areContentsTheSame(old: Todo, new: Todo) = old == new
        }
    }

    inner class ViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.tvName.text = todo.name
            binding.root.setOnClickListener { onClick(todo) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
