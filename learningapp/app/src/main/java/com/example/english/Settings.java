package com.example.english;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    MediaPlayer player;
    private Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button on = (Button) this.findViewById(R.id.on);

    }
    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.song);

        }
        player.start();
    }
    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }
    public void stop(View v) {
        stopPlayer();
    }
    private void stopPlayer() {
        if (player != null) {
            player.stop();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }


    public void getScore(View view) {
        CharSequence resultsDisplay;
        EditText writtenAns1;
        EditText writtenAns2;
        EditText writtenAns3;
        EditText writtenAns4;
        EditText writtenAns5;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;

        String answer1;
        writtenAns1 = (EditText) this.findViewById(R.id.answer);
        answer1 = writtenAns1.getText().toString().toLowerCase();
        if (answer1.equals("eyes of stone")) {
            answer1_score = 2;
        } else {
            answer1_score = 0;
        }

        String answer2;
        writtenAns2 = (EditText) this.findViewById(R.id.answer1);
        answer2 = writtenAns2.getText().toString().toLowerCase();
        if (answer2.equals("being")) {
            answer2_score = 2;
        } else {
            answer2_score = 0;
        }

        String answer3;
        writtenAns3 = (EditText) this.findViewById(R.id.answer2);
        answer3 = writtenAns3.getText().toString().toLowerCase();
        if (answer3.equals("surrender")) {
            answer3_score = 2;
        } else {
            answer3_score = 0;
        }

        String answer4;
        writtenAns4 = (EditText) this.findViewById(R.id.answer3);
        answer4 = writtenAns4.getText().toString().toLowerCase();
        if (answer4.equals("can't")) {
            answer4_score = 2;
        } else {
            answer4_score = 0;
        }

        String answer5;
        writtenAns5 = (EditText) this.findViewById(R.id.answer4);
        answer5 = writtenAns5.getText().toString().toLowerCase();
        if (answer5.equals("need")) {
            answer5_score = 2;
        } else {
            answer5_score = 0;
        }


        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score ;

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