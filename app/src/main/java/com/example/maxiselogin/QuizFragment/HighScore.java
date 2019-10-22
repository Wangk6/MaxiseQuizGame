package com.example.maxiselogin.QuizFragment;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class HighScore extends AppCompatActivity {
    int highScore;
    String highScoreUser;
    public static final String HIGH_SCORE = "highScore";
    public static final String HIGH_SCORE_USER = "highScoreUser";
    public static final String SHARED_PREFS = "sharedPrefs";

    public HighScore(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highScore = sharedPreferences.getInt(HIGH_SCORE, 0);
        highScoreUser = sharedPreferences.getString(HIGH_SCORE_USER, "");
    }

    public void setHighScore(int score, String name){
        highScore = score;
        highScoreUser = name;
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HIGH_SCORE, score);
        editor.putString(HIGH_SCORE_USER, name);
        editor.apply();
    }

    public int getHighScore(){
        return highScore;
    }
}
