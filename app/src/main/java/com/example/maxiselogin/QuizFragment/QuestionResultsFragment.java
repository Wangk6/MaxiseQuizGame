package com.example.maxiselogin.QuizFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.maxiselogin.MainLoggedInStart;
import com.example.maxiselogin.R;

import static android.content.Context.MODE_PRIVATE;

public class QuestionResultsFragment extends Fragment {
    ImageView q1, q2, q3, q4, q5;
    TextView totalScore;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String QUESTION_ONE = "questionOne";
    public static final String QUESTION_TWO = "questionTwo";
    public static final String QUESTION_THREE = "questionThree";
    public static final String QUESTION_FOUR = "questionFour";
    public static final String QUESTION_FIVE = "questionFive";
    public static final String SCORE = "score";
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_result, container, false);
        q1 = view.findViewById(R.id.imgQuestionOneResult);
        q2 = view.findViewById(R.id.imgQuestionTwoResult);
        q3 = view.findViewById(R.id.imgQuestionThreeResult);
        q4 = view.findViewById(R.id.imgQuestionFourResult);
        q5 = view.findViewById(R.id.imgQuestionFiveResult);
        totalScore = view.findViewById(R.id.txtTotalScore);

        if(getScoreData("QONE") == 1){ //If correct
            q1.setImageResource(R.drawable.ic_check_circle_black_24dp);
        }
        if(getScoreData("QTWO") == 1){ //If correct
            q2.setImageResource(R.drawable.ic_check_circle_black_24dp);
        }
        if(getScoreData("QTHREE") == 1){ //If correct
            q3.setImageResource(R.drawable.ic_check_circle_black_24dp);
        }
        if(getScoreData("QFOUR") == 21){ //If correct
            q4.setImageResource(R.drawable.ic_check_circle_black_24dp);
        }
        if(getScoreData("QFIVE") == 21){ //If correct
            q5.setImageResource(R.drawable.ic_check_circle_black_24dp);
        }
        //totalScore.setText(getScoreData("SCORE"));
        return view;
    }

    public int getScoreData(String key){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        int num = 0;
        boolean ans;
        //if(key == "SCORE") {
        //    num = sharedPreferences.getInt(SCORE, 0);
        //}
        if(key == "QONE") {
            ans = sharedPreferences.getBoolean(QUESTION_ONE, false);
            if (ans == true) {
                num = 1;
            }
        }else if(key == "QTWO") {
            ans = sharedPreferences.getBoolean(QUESTION_TWO, false);
            if(ans == true){
                num = 1;
            }
        }else if(key == "QTHREE"){
            ans = sharedPreferences.getBoolean(QUESTION_THREE, false);
            if(ans == true){
                num = 1;
            }
        }else if(key == "QFOUR"){
            num = sharedPreferences.getInt(QUESTION_FOUR, 0);
            if(num >= 21){
                num = 1;
            }
        }else if(key == "QFIVE"){
            num = sharedPreferences.getInt(QUESTION_FIVE, 0);
            if(num >= 21){
                num = 1;
            }
        }

        return num;
    }
}
