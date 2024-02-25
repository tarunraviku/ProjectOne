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

public class AssignmentActivity extends AppCompatActivity {
    private EditText editAssignmentName;
    private EditText editDueDate;
    private Button btnAddAssignment;
    private ListView listAssignments;
    private ArrayList<String> assignments;
    private ArrayAdapter<String> adapter;
    private Button btnGotoCourses;
    private Button btnGotoTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        editAssignmentName = findViewById(R.id.edit_assignment_name);
        editDueDate = findViewById(R.id.edit_due_date);
        btnAddAssignment = findViewById(R.id.btn_add_assignment);
        listAssignments = findViewById(R.id.list_assignments);
        btnGotoCourses = findViewById(R.id.btn_goto_courses);
        btnGotoTodo = findViewById(R.id.btn_goto_todo);

        assignments = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, assignments);
        listAssignments.setAdapter(adapter);

        btnAddAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAssignment();
            }
        });

        btnGotoCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignmentActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        btnGotoTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignmentActivity.this, TodoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addAssignment() {
        String assignmentName = editAssignmentName.getText().toString().trim();
        String dueDate = editDueDate.getText().toString().trim();
        if (!assignmentName.isEmpty() && !dueDate.isEmpty()) {
            String assignmentDetail = assignmentName + " - Due: " + dueDate;
            assignments.add(assignmentDetail);
            adapter.notifyDataSetChanged();
            editAssignmentName.setText("");
            editDueDate.setText("");
        }
    }
}
