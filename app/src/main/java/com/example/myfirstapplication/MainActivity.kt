package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Date

public lateinit var mainViewList: RecyclerView
public lateinit var todoList: ArrayList<Task>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewList = findViewById(R.id.mainViewList)
        mainViewList.layoutManager = LinearLayoutManager(this)

        todoList = ArrayList<Task>()

        val adapter = TodoAdapter(todoList)
        mainViewList.adapter = adapter

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            val addTaskDialog = AddTaskDialog()
            addTaskDialog.show(supportFragmentManager, "AddTaskDialog")
        }
    }
}
class TodoAdapter(private val taskList:ArrayList<Task>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>(){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val taskTitle:TextView = itemView.findViewById(R.id.task_title)
        val taskDescription : TextView = itemView.findViewById(R.id.task_description)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_todo, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskTitle.text = task.title
        holder.taskDescription.text = task.description
    }
    override fun getItemCount(): Int {
        return taskList.size
    }
}