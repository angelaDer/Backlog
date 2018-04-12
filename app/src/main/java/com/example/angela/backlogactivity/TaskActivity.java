package com.example.angela.backlogactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    private static final String TASKPROJECT = "com.example.angela.backlogactivity.taskproject";
    private static final int REQUEST_CODE_ADD_SMTH = 1;

    private Task mTask;
    private ImageButton mDelete;
    private ImageButton mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        mTask = getIntent().getParcelableExtra(TASKPROJECT);
        mDelete = (ImageButton) findViewById(R.id.deleteButton);
        mEdit = (ImageButton) findViewById(R.id.editButton);
    }

    public static Intent newIntent(Context packageContext, Task task){
        Intent intent = new Intent(packageContext, TaskActivity.class);
        intent.putExtra(TASKPROJECT, task);
        return intent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_ADD_SMTH) {
            if (data == null) {
                return;
            }
            Toast.makeText(TaskActivity.this, "Bedzie fajnie, jesli zadziala", Toast.LENGTH_LONG).show();
        }
    }
}
