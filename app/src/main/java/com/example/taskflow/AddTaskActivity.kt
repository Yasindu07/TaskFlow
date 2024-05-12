package com.example.taskflow

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskflow.databinding.ActivityAddTaskBinding


class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db:TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = TaskDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val priority = binding.priorityEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val task = Task(0, title, priority, content)
            db.insertTask(task)
            finish()
            Toast.makeText(this, "Task Saved", Toast.LENGTH_SHORT).show()
        }

    }
}