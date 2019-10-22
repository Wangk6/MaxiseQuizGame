package com.example.maxiselogin.QuizFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maxiselogin.MainLoggedInStart;
import com.example.maxiselogin.R;

public class QuestionFiveFragment extends Fragment {

    private CheckBox cb1, cb2, cb3, cb4;
    private Button submitBtn;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String QUESTION_FIVE = "questionFive";
    public static final String SCORE = "score";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_quiz_question_five, container, false);

        submitBtn = view.findViewById(R.id.btnSubmitQuizFive);
        cb1 = view.findViewById(R.id.checkBox);
        cb2 = view.findViewById(R.id.checkBox2);
        cb3 = view.findViewById(R.id.checkBox3);
        cb4 = view.findViewById(R.id.checkBox4);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
                    String checkBoxChoices = "";

                    if (cb1.isChecked()) {
                        checkBoxChoices += cb1.getText().toString() + "\n";
                    }

                    if (cb2.isChecked()) {
                        checkBoxChoices += cb2.getText().toString() + "\n";
                    }

                    if (cb3.isChecked()) {
                        checkBoxChoices += cb3.getText().toString() + "\n";
                    }

                    if (cb4.isChecked()) {
                        checkBoxChoices += cb4.getText().toString() + "\n";
                    }

                    new AlertDialog.Builder(getContext())
                            .setTitle("Confirm")
                            .setMessage("Selected: " + (checkBoxChoices))
                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                    //Save results
                                    isCheckedAns();
                                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                                    ft.replace(R.id.quiz_fragment, new QuestionResultsFragment());
                                    ft.commit();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });
        return view;
    }

    private void isCheckedAns(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        MainLoggedInStart ls = new MainLoggedInStart();
        if (cb1.isChecked()) {
            //new MainLoggedInStart().saveData(4, cb1.getText().toString());
            //editor.putInt(SCORE, getScoreData("SCORE")+7);
            editor.putInt(QUESTION_FIVE, getScoreData()-7); //Calculate at the end, if total is 21, all 3 correct were selected
        }

        if (cb2.isChecked()) {
            //new MainLoggedInStart().saveData(4, cb2.getText().toString());
            editor.putInt(QUESTION_FIVE, getScoreData()+7); //Calculate at the end, if total is 21, all 3 correct were selected
        }

        if (cb3.isChecked()) {
            //new MainLoggedInStart().saveData(4, cb3.getText().toString());
            editor.putInt(QUESTION_FIVE, getScoreData()+7); //Calculate at the end, if total is 21, all 3 correct were selected
        }

        if (cb4.isChecked()) {
            //new MainLoggedInStart().saveData(4, cb4.getText().toString());
            editor.putInt(QUESTION_FIVE, getScoreData()+7); //Calculate at the end, if total is 21, all 3 correct were selected
        }

        editor.commit();
    }

    public int getScoreData(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        int num = 0;

        num = sharedPreferences.getInt(QUESTION_FIVE, 0);

        return num;
    }
}
