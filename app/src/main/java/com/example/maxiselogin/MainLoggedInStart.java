package com.example.maxiselogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
}
