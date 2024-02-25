package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity {
    private EditText editTask;
    private EditText editDescription;
    private Button btnAddTask;
    private ListView listTasks;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;
    private Button btnGoToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        editTask = findViewById(R.id.edit_task);
        editDescription = findViewById(R.id.edit_description);
        btnAddTask = findViewById(R.id.btn_add_task);
        listTasks = findViewById(R.id.list_tasks);
        btnGoToMain = findViewById(R.id.btn_goto_main);

        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listTasks.setAdapter(adapter);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void addTask() {
        String task = editTask.getText().toString().trim();
        String description = editDescription.getText().toString().trim();
        if (!task.isEmpty() && !description.isEmpty()) {
            String taskDetail = "Task: " + task + "\nDescription: " + description;
            tasks.add(taskDetail);
            adapter.notifyDataSetChanged();
            editTask.setText("");
            editDescription.setText("");
        }
    }
}
