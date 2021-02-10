package com.example.english;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridGenerator {
    final public static String TAG = "GridGenerator";

    public List<String> setGrid(List<String> dataInput, char[] grid) {

        List<String> usedStrings = new ArrayList<>();
        int usedCount;
        usedStrings.clear();
        clearGrid(grid);
        for (String w : dataInput) {
            String word = w.toLowerCase();

            if (tryPlaceWord(word, grid)) {
                usedStrings.add(word);
            }
        }
        randomizeNullGrid(grid);
        return usedStrings;
    }

    private void clearGrid(char[] grid) {

        for (int i=0;i<grid.length;i++) {
            grid[i] = '\0';
        }
    }

    private void randomizeNullGrid(char[] grid) {
        Random rnd = new Random();
        char c = (char) (Math.abs(rnd.nextInt(26)) + 'a');
        for (int i=0;i<grid.length;i++) {
            if (grid[i] == '\0') {
                grid[i] = c;
                c = (char) (Math.abs(rnd.nextInt(26)) + 'a');
                Log.d(TAG, "randomizeNullGrid: char="+c);
            }
        }
    }

    private com.example.raji.Direction getRandomDirection() {
        com.example.raji.Direction dir;
        Random rand = new Random();
        do {
            dir = com.example.raji.Direction.values()[ Math.abs(rand.nextInt()) % com.example.raji.Direction.values().length ];
        } while (dir == com.example.raji.Direction.NONE);
        return dir;
    }

    private boolean tryPlaceWord(String word, char gridArr[]) {
        com.example.raji.Direction startDir = getRandomDirection();
        com.example.raji.Direction currDir = startDir;
        int len = (int) Math.sqrt(gridArr.length);

        for (int i = 0; i< com.example.raji.Direction.values().length; i++){
            for (int row=0;row<len;row++){
                for (int col=0;col<len;col++){
                    if (isValidPlacement(row,col,currDir,gridArr,word)){
                        placeWordAt(row,col,currDir,gridArr,word);
                        return true;
                    }
                }
            }
            currDir = currDir.nextDirection();
        }

        return false;
    }

    /**
     *
     * @param col starting column
     * @param row starting row
     * @param dir direction of the word
     * @param gridArr grid where the word will be placed
     * @param word the actual word to be checked
     * @return true if it is a valid placement, false otherwise
     */
    private boolean isValidPlacement(int row, int col, com.example.raji.Direction dir, char gridArr[], String word) {
        int rowLen = (int) Math.sqrt(gridArr.length);

        int len = word.length()-1;

        if (dir == com.example.raji.Direction.RIGHT && (col + len) >= rowLen) return false;
        if (dir == com.example.raji.Direction.LEFT && (col - len) < 0) return false;

        if (dir == com.example.raji.Direction.UP && (row - len) < 0) return false;
        if (dir == com.example.raji.Direction.DOWN && (row + len) >= rowLen) return false;

        if (dir == com.example.raji.Direction.DOWN_RIGHT && ((col + len) >= rowLen || (row + len) >= rowLen)) return false;
        if (dir == com.example.raji.Direction.UP_LEFT && ((col - len) < 0 || (row - len) < 0)) return false;

        if (dir == com.example.raji.Direction.DOWN_LEFT && ((col - len) < 0 || (row + len) >= rowLen)) return false;
        if (dir == com.example.raji.Direction.UP_RIGHT && ((col + len) >= rowLen || (row - len) < 0)) return false;

        for (int i = 0; i <= len; i++) {
            if (gridArr[row*rowLen+col] != '\0' && gridArr[row*rowLen+col] != word.charAt(i))
                return false;
            col += dir.x;
            row += dir.y;
        }

        Log.d(TAG, "isValidPlacement: "+word+" "+col + " "+ row+" "+dir.name());
        return true;
    }

    private void placeWordAt(int row, int col, com.example.raji.Direction dir, char gridArr[], String word) {
        Log.d(TAG, "placeWordAt: len "+gridArr.length);
        int len = (int)Math.sqrt(gridArr.length);
        Log.d(TAG, "placeWordAt: "+word);
        for (int i = 0; i < word.length(); i++) {
            int idx = (int)row*len+col;
            gridArr[idx] = word.charAt(i);
            Log.d(TAG, "placeWordAt: "+row+" "+len+" "+col+" "+idx);

            col += dir.x;
            row += dir.y;
        }
    }
}
