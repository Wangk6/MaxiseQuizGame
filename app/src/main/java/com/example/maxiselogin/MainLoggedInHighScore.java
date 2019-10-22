package com.example.maxiselogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainLoggedInHighScore extends AppCompatActivity {
    TextView txtHighScore, txtHighScoreName;
    int highScore;
    String userName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_high_score);
        //txtHighScoreName = findViewById(R.id.txtHighScoreUser);
        //txtHighScoreName.setText(userName);
        //txtHighScore = findViewById(R.id.txtHighScore);
        //txtHighScore.setText(highScore);
    }

    public void PreviousPage(View view) {
        Intent i = new Intent(this, MainLoggedInActivity.class);
        startActivity(i);
    }
}
