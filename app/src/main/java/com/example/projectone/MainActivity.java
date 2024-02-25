// MainActivity.java
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

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ListView list;
    private Button button;
    private EditText editCourseName;
    private EditText editProfessorName;
    private EditText editCourseTime;
    private ArrayAdapter<String> itemsAdapter;
    private Button btnGotoAssignments;
    private Button btnGotoTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        button = findViewById(R.id.button);
        editCourseName = findViewById(R.id.edit_course_name);
        editProfessorName = findViewById(R.id.edit_professor_name);
        editCourseTime = findViewById(R.id.edit_course_time);
        btnGotoAssignments = findViewById(R.id.btn_goto_assignments);
        btnGotoTodo = findViewById(R.id.btn_goto_main);

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(itemsAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        btnGotoAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AssignmentActivity.class);
                startActivity(intent);
            }
        });

        btnGotoTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addItem() {
        String courseName = editCourseName.getText().toString().trim();
        String professorName = editProfessorName.getText().toString().trim();
        String courseTime = editCourseTime.getText().toString().trim();

        if (!courseName.isEmpty() && !professorName.isEmpty() && !courseTime.isEmpty()) {
            String courseInfo = "Course: " + courseName + "\nProfessor: " + professorName + "\nTime: " + courseTime;
            items.add(courseInfo);
            itemsAdapter.notifyDataSetChanged();

            editCourseName.setText("");
            editProfessorName.setText("");
            editCourseTime.setText("");
        }
    }
}
