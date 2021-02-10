package com.example.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class VExplorative_English extends AppCompatActivity {
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_explorative__english);


    l1 = (LinearLayout) findViewById(R.id.l1);
    l3 = (LinearLayout) findViewById(R.id.l3);
    l2 = (LinearLayout) findViewById(R.id.l2);




        l1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(VExplorative_English.this, Settings.class);
            startActivity(intent);
        }
    });

        l2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(VExplorative_English.this, vListning.class);
            startActivity(intent);
        }
    });

        l3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(VExplorative_English.this, Settings2.class);
            startActivity(intent);
        }
    });



}
}