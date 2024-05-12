package com.example.taskflow

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(private var tasks: List<Task>, context: Context) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {


    private val db: TaskDatabaseHelper = TaskDatabaseHelper(context)

        class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
            val priorityTextView: TextView = itemView.findViewById(R.id.priorityTextView)
            val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
            val updateButton: ImageView = itemView.findViewById(R.id.updateButton)
            val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = tasks[position]
        holder.titleTextView.text = task.title
        holder.priorityTextView.text = task.priority
        holder.contentTextView.text = task.content

        holder.updateButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateTaskActivity::class.java).apply {
                putExtra("task_id", task.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener {
            db.deleteTask(task.id)
           refreshData(db.getAllTasks())
            Toast.makeText(holder.itemView.context, "Task Deleted", Toast.LENGTH_SHORT).show()
        }

    }

    fun refreshData(newTask: List<Task>){
        tasks = newTask
        notifyDataSetChanged()
    }
}