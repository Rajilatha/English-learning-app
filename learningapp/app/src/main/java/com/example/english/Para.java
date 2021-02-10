package com.example.english;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Para extends AppCompatActivity {

    EditText writtenAns1;
    EditText writtenAns2;
    EditText writtenAns3;
    EditText writtenAns4;
    EditText writtenAns5;
    EditText writtenAns6;
    EditText writtenAns7;
    EditText writtenAns8;
    EditText writtenAns9;
    EditText writtenAns10;
    EditText writtenAns11;
    EditText writtenAns12;
    EditText writtenAns13;
    EditText writtenAns14;
    EditText writtenAns15;
    private playAudioForAnswer playAudioForAnswer;
    MediaPlayer player;
    int FLAG=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para);
    }

    public void getScore(View view) {
        CharSequence resultsDisplay;

        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int answer6_score;
        int answer7_score;
        int answer8_score;
        int answer9_score;
        int answer10_score;
        int answer11_score;
        int answer12_score;
        int answer13_score;
        int answer14_score;
        int answer15_score;
        int final_score;
        playAudioForAnswer=new playAudioForAnswer(this);

        String answer1;
        writtenAns1 = (EditText) this.findViewById(R.id.answer);
        answer1 = writtenAns1.getText().toString().toLowerCase();
        if (answer1.equals("missing")) {
            answer1_score = 2;
        } else {
            answer1_score = 0;
        }

        String answer2;
        writtenAns2 = (EditText) this.findViewById(R.id.answer1);
        answer2 = writtenAns2.getText().toString().toLowerCase();
        if (answer2.equals("which")) {
            answer2_score = 2;
        } else {
            answer2_score = 0;
        }

        String answer3;
        writtenAns3 = (EditText) this.findViewById(R.id.answer2);
        answer3 = writtenAns3.getText().toString().toLowerCase();
        if (answer3.equals("only")) {
            answer3_score = 2;
        } else {
            answer3_score = 0;
        }

        String answer4;
        writtenAns4 = (EditText) this.findViewById(R.id.answer3);
        answer4 = writtenAns4.getText().toString().toLowerCase();
        if (answer4.equals("value")) {
            answer4_score = 2;
        } else {
            answer4_score = 0;
        }

        String answer5;
        writtenAns5 = (EditText) this.findViewById(R.id.answer4);
        answer5 = writtenAns5.getText().toString().toLowerCase();
        if (answer5.equals("case")) {
            answer5_score = 2;
        } else {
            answer5_score = 0;
        }

        String answer6;
        writtenAns6 = (EditText) this.findViewById(R.id.answer5);
        answer6 = writtenAns6.getText().toString().toLowerCase();
        if (answer6.equals("quickly")) {
            answer6_score = 2;
        } else {
            answer6_score = 0;
        }

        String answer7;
        writtenAns7 = (EditText) this.findViewById(R.id.answer6);
        answer7 = writtenAns7.getText().toString().toLowerCase();
        if (answer7.equals("settle")) {
            answer7_score = 2;
        } else {
            answer7_score = 0;
        }

        String answer8;
        writtenAns8 = (EditText) this.findViewById(R.id.answer7);
        answer8 = writtenAns8.getText().toString().toLowerCase();
        if (answer8.equals("agreed")) {
            answer8_score = 2;
        } else {
            answer8_score = 0;
        }

        String answer9;
        writtenAns9 = (EditText) this.findViewById(R.id.answer8);
        answer9 = writtenAns9.getText().toString().toLowerCase();
        if (answer9.equals("cheque")) {
            answer9_score = 2;
        } else {
            answer9_score = 0;
        }

        String answer10;
        writtenAns10 = (EditText) this.findViewById(R.id.answer9);
        answer10 = writtenAns10.getText().toString().toLowerCase();
        if (answer10.equals("success")) {
            answer10_score = 2;
        } else {
            answer10_score = 0;
        }

        String answer11;
        writtenAns11 = (EditText) this.findViewById(R.id.answer10);
        answer11 = writtenAns11.getText().toString().toLowerCase();
        if (answer11.equals("engine-driver")) {
            answer11_score = 2;
        } else {
            answer11_score = 0;
        }

        String answer12;
        writtenAns12 = (EditText) this.findViewById(R.id.answer11);
        answer12 = writtenAns12.getText().toString().toLowerCase();
        if (answer12.equals("drunk")) {
            answer12_score = 2;
        } else {
            answer12_score = 0;
        }

        String answer13;
        writtenAns13 = (EditText) this.findViewById(R.id.answer12);
        answer13 = writtenAns13.getText().toString().toLowerCase();
        if (answer13.equals("witness")) {
            answer13_score = 2;
        } else {
            answer13_score = 0;
        }

        String answer14;
        writtenAns14 = (EditText) this.findViewById(R.id.answer13);
        answer14 = writtenAns14.getText().toString().toLowerCase();
        if (answer14.equals("benignly")) {
            answer14_score = 2;
        } else {
            answer14_score = 0;
        }

        String answer15;
        writtenAns15 = (EditText) this.findViewById(R.id.answer14);
        answer15 = writtenAns15.getText().toString().toLowerCase();
        if (answer15.equals("about")) {
            answer15_score = 2;
        } else {
            answer15_score = 0;
        }

        final_score = answer1_score + answer2_score + answer3_score + answer4_score +
                answer5_score + answer6_score+ answer7_score+ answer8_score + answer9_score+ answer10_score
                + answer11_score + answer12_score + answer13_score + answer14_score + answer15_score ;

        if (final_score == 15) {
            FLAG=3;
            playAudioForAnswer.setAudioforAnswer(FLAG);
            resultsDisplay = "Perfect! You scored 15 out of 15";
        } else {
            FLAG=4;
            playAudioForAnswer.setAudioforAnswer(FLAG);
            resultsDisplay = "Try again. You scored " + final_score + " out of 15";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        finalResult();

    }
    private void finalResult(){
        Intent resultData = new Intent(Para.this,results.class);

        startActivity(resultData);
    }

}
