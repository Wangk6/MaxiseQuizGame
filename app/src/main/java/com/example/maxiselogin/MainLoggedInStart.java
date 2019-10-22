package com.example.maxiselogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maxiselogin.QuizFragment.HighScore;
import com.example.maxiselogin.QuizFragment.QuestionOneFragment;
import com.example.maxiselogin.QuizFragment.QuestionTwoFragment;

public class MainLoggedInStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_start);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.quiz_fragment, new QuestionOneFragment());
        fragmentTransaction.commit();
    }

    public void PreviousPageStart(View view) {
        Intent i = new Intent(MainLoggedInStart.this, MainLoggedInActivity.class);
        startActivity(i);
    }

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String QUESTION_ONE = "questionOne";
    public static final String QUESTION_TWO = "questionTwo";
    public static final String QUESTION_THREE = "questionThree";
    public static final String QUESTION_FOUR = "questionFour";
    public static final String QUESTION_FIVE = "questionFive";
    public static final String SCORE = "score";

/*    //Save the results from quizzes into sharedpref
    public int saveData(int quizNum, String ans){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch(quizNum){
            case 1:
                if(ans == "50"){ //user chose correct answer
                    editor.putInt(SCORE, getScoreData("SCORE")+20);
                    editor.putBoolean(QUESTION_ONE, true);
                }else{
                    editor.putBoolean(QUESTION_ONE, false);
                }
                break;
            case 2:
                if(ans == "8"){ //user chose correct answer
                    editor.putInt(SCORE, getScoreData("SCORE")+20);
                    editor.putBoolean(QUESTION_TWO, true);
                }else{
                    editor.putBoolean(QUESTION_TWO, false);
                }
                break;
            case 3:
                if(ans == "32"){ //user chose correct answer
                    editor.putInt(SCORE, getScoreData("SCORE")+20);
                    editor.putBoolean(QUESTION_THREE, true);
                }else{
                    editor.putBoolean(QUESTION_THREE, false);
                }
                break;
            case 4:
                if(ans == "Tomato" || ans == "Cucumber" || ans == "Apple") { //user chose correct answer
                    editor.putInt(SCORE, getScoreData("SCORE")+7);
                    editor.putInt(QUESTION_FOUR, getScoreData("QFOUR")+7); //Calculate at the end, if total is 21, all 3 were selected, if total is 14, 2 were selected
                }
                break;
            case 5:
                if(ans == "Mars" || ans == "Uranus" || ans == "Jupiter") { //user chose correct answer
                    editor.putInt(SCORE, getScoreData("SCORE")+7);
                    editor.putInt(QUESTION_FIVE, getScoreData("QFIVE")+7); //Calculate at the end, if total is 21, all 3 were selected, if total is 14, 2 were selected
                }
            case 6: //Check for highscore
                //If no highscore is set, set highscore as score
                HighScore hs = new HighScore();
                int currentHighScore = hs.getHighScore();
                if(currentHighScore < getScoreData("SCORE")){ //Return 1 and call HighScore class, setHighScore
                    return 1;
                }
                break;
        }
        editor.commit();
        return 0;
    }*/



}
