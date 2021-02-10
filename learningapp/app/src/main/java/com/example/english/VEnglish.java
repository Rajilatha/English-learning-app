package com.example.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class VEnglish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_english);
    }
    public void vocabulary (View view) {
        startActivity(new Intent(this, Game.class));
    }
    public void grammer (View view) {
        startActivity(new Intent(this, Grammer.class));
    }
}