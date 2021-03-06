package com.example.english;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.Arrays;
import java.util.List;

public class WordSearchActivity3 extends AppCompatActivity {
    final public static String TAG = "WordSearchActivity";
    final public static String FINISH_TIME = "finish_time";
    //    private String[] grid;
    private Context mContext;
    private com.example.english.WordListRecyclerViewAdapter listAdapter;
    private com.example.english.GridRecyclerViewAdapter gridAdapter;
    private RecyclerView wordGrid;
    private RecyclerView wordList;
    private TextView timerView;
    private TextView scoreView;
    Button checkWordButton;
    private List<String> words;

    final int MSG_START_TIMER = 0;
    final int MSG_STOP_TIMER = 1;
    final int MSG_UPDATE_TIMER = 2;

    private com.example.english.Timer timer = new com.example.english.Timer();
    private final int REFRESH_RATE = 100;

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_START_TIMER:
                    timer.start(); //start timer
                    mHandler.sendEmptyMessage(MSG_UPDATE_TIMER);
                    break;

                case MSG_UPDATE_TIMER:
                    timerView.setText(String.format("%02d:%02d",timer.getElapsedTimeMin(),timer.getElapsedTimeSecs()%60));
                    mHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIMER,REFRESH_RATE); //text view is updated every second,
                    break;                                  //though the timer is still running
                case MSG_STOP_TIMER:
                    mHandler.removeMessages(MSG_UPDATE_TIMER); // no more updates.
                    timer.stop();//stop timer
                    timerView.setText(String.format("%02d:%02d",timer.getElapsedTimeMin(),timer.getElapsedTimeSecs()%60));
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search);
        timerView = findViewById(R.id.timeLabel);
        scoreView = findViewById(R.id.scoreLabel);
        mContext = getApplicationContext();
        checkWordButton = findViewById(R.id.CheckWord);

        char[] grid = {
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j',
                'a','b','c','d','e','f','g','h','i','j'
        };
        checkWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: chars "+ com.example.english.GameBoard.getInstance().getSelectedChars().toString());
                com.example.english.GameBoard gameBoard = com.example.english.GameBoard.getInstance();
                String res = gameBoard.validWord();
                Log.d(TAG, "onClick: ->"+res);
                if (!res.isEmpty()) {
                    updateScore(gameBoard.incrScore());

                    gameBoard.clearSelectedChars();
                    updateWordList(res);
                    //Game Over
                    if (gameBoard.getScore() == gameBoard.getMaxScore()) {
                        Intent intent = new Intent(mContext, com.example.english.EndGame3.class);
                        String endTime = String.format("%02d:%02ds",timer.getElapsedTimeMin(),timer.getElapsedTimeSecs()%60);
                        intent.putExtra(FINISH_TIME,endTime);
                        startActivity(intent);
                    }
                }
                gameBoard.resetSelections();
                gridAdapter.notifyDataSetChanged();
            }
        });


        words = Arrays.asList("Wealth", "Reunion", "Invisible", "Infamy", "Honest", "Hood","Farewell", "Roam","Sluggrad");
        com.example.english.GameBoard.getInstance().setWords(words);

        updateScore(com.example.english.GameBoard.getInstance().getScore());
        mHandler.sendEmptyMessage(MSG_START_TIMER);
        com.example.english.GridGenerator g = new com.example.english.GridGenerator();

        Toast.makeText(mContext, String.format("we used %d",g.setGrid(words,grid).size()), Toast.LENGTH_SHORT).show();

        // set up the RecyclerViews
        final int num_cols = 10;
        wordGrid = findViewById(R.id.WordGrid);
        gridAdapter = new com.example.english.GridRecyclerViewAdapter(mContext, grid);

        wordGrid.setAdapter(gridAdapter);
        wordGrid.setLayoutManager(new GridLayoutManager(mContext, num_cols));

        wordList = findViewById(R.id.WordList);
        listAdapter = new com.example.english.WordListRecyclerViewAdapter(mContext,(String[])words.toArray());

        wordList.setAdapter(listAdapter);
        wordList.setLayoutManager(new GridLayoutManager(mContext, 4));
    }

    private void updateWordList(String res) {
        int idx = listAdapter.indexOf(res);
        Log.d(TAG, "updateWordList: idx of upd "+idx);
        if (idx >= 0) {
            com.example.english.GameBoard.getInstance().getFoundWords()[idx] = true;
            listAdapter.notifyDataSetChanged();
        }
    }


    public void updateScore(int score) {
        scoreView.setText(String.format("%d/%d",score,words.size()));
    }

}
