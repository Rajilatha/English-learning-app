package com.example.english;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGame3 extends AppCompatActivity {
    final public static String TAG = "EndGame";
    private TextView endTime;
    Button restartButton;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        restartButton = findViewById(R.id.RestartButton);
        endTime = findViewById(R.id.EndTime);
        mContext = getApplicationContext();

        String time = getIntent().getStringExtra(WordSearchActivity3.FINISH_TIME);
        endTime.setText(time);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameBoard.getInstance().setScore(0);
                GameBoard.getInstance().resetSelections();
                GameBoard.getInstance().clearSelectedChars();
                Intent intent = new Intent(mContext, Game.class);
                startActivity(intent);
            }
        });
    }
}
