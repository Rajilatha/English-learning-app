package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void learn (View view) {
        startActivity(new Intent(this, Science_Lessons.class));
    }
    public void practice (View view) {
        startActivity(new Intent(this, VPractice.class));
    }
}