package com.dev.knplab.knp.dbtestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    Button btnAdd;
    ListView lvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        btnAdd = findViewById(R.id.btnAdd);
        lvTasks = findViewById(R.id.lvTasks);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] vals = etTitle.getText().toString().split(" ");
                if (vals.length == 2){
                    Task task = new Task(vals[0], vals[1]);
                    long id = task.save();
                    Toast.makeText(MainActivity.this, "ID: " + id, Toast.LENGTH_SHORT).show();
                } else {
                    List<Task> tasks = new Select().from(Task.class).execute();
                    ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            tasks
                            );
                    lvTasks.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "oops", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
