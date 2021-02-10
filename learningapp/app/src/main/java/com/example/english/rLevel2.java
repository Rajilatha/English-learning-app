package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class rLevel2 extends AppCompatActivity {
    RadioButton radioButton3Q1;
    RadioButton radioButton4Q2;
    RadioButton radioButton3Q3;
    RadioButton radioButton2Q4;
    RadioButton radioButton1Q5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_level2);
    }
    public void getScore(View view) {
        CharSequence resultsDisplay;

        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;

        int final_score;

        Boolean answer1;

        radioButton3Q1 = (RadioButton) this.findViewById(R.id.radioButton3Q1);
        answer1 = radioButton3Q1.isChecked();
        if (answer1) {
            answer1_score = 2;
        } else {
            answer1_score = 0;
        }

        Boolean answer2;

        radioButton4Q2 = (RadioButton) this.findViewById(R.id.radioButton4Q2);
        answer2 = radioButton4Q2.isChecked();
        if (answer2) {
            answer2_score = 2;
        } else {
            answer2_score = 0;
        }

        Boolean answer3;

        radioButton3Q3 = (RadioButton) this.findViewById(R.id.radioButton3Q3);
        answer3 = radioButton3Q3.isChecked();
        if (answer3) {
            answer3_score = 2;
        } else {
            answer3_score = 0;
        }

        Boolean answer4;

        radioButton2Q4 = (RadioButton) this.findViewById(R.id.radioButton2Q4);
        answer4 = radioButton2Q4.isChecked();
        if (answer4) {
            answer4_score = 2;
        } else {
            answer4_score = 0;
        }

        Boolean answer5;

        radioButton1Q5 = (RadioButton) this.findViewById(R.id.radioButton1Q5);
        answer5 = radioButton1Q5.isChecked();
        if (answer5) {
            answer5_score = 2;
        } else {
            answer5_score = 0;
        }

        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

        if (final_score == 10) {
            resultsDisplay = "Perfect! You scored 10 out of 10";
        } else {
            resultsDisplay = "Try again. You scored " + final_score + " out of 10";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();


    }
}