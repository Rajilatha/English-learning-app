package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VPractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_practice);
    }
    public void first (View view) {
        startActivity(new Intent(this, VEnglish.class));
    }
    public void secound (View view) {
        startActivity(new Intent(this, VCommunicative_English.class));
    }
    public void third (View view) {
        startActivity(new Intent(this, rMainActivity.class));
    }
    public void four (View view) {
        startActivity(new Intent(this, VExplorative_English.class));
    }
}