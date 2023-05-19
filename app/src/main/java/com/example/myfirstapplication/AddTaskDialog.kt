package com.example.myfirstapplication

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.Date

class AddTaskDialog : DialogFragment() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_add_task, null)

        titleEditText = view.findViewById(R.id.editTextTitle)
        descriptionEditText = view.findViewById(R.id.editTextDescription)

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Add Task")
            .setView(view)
            .setPositiveButton("Add") { _, _ ->
                val title = titleEditText.text.toString()
                val description = descriptionEditText.text.toString()
                addTask(title, description)
            }
            .setNegativeButton("Cancel", null)
            .create()

        return dialog
    }

    private fun addTask(title: String, description: String) {
        val adapter = TodoAdapter(todoList)
        mainViewList.adapter = adapter

        val newTask = Task(title, description, Date())
        todoList.add(newTask)
        adapter.notifyItemInserted(todoList.size - 1)
    }
}
