package com.example.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class VCommunicative_English extends AppCompatActivity {
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;
    LinearLayout l4;

    private long backPressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_communicative__english);

        l1 = (LinearLayout) findViewById(R.id.l1);
        l3 = (LinearLayout) findViewById(R.id.l3);
        l2 = (LinearLayout) findViewById(R.id.l2);
        l4 = (LinearLayout) findViewById(R.id.l4);



        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VCommunicative_English.this, LetterWritting.class);
                startActivity(intent);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VCommunicative_English.this, EmailWritting.class);
                startActivity(intent);
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VCommunicative_English.this, Conversation.class);
                startActivity(intent);
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VCommunicative_English.this, speech.class);
                startActivity(intent);
            }
        });


    }
}