package com.example.maxiselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View mainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = findViewById(R.id.mainView);
        mainView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        });


    }



    public void nextPage(View view) {
        nextPageLoad();
    }

    public void nextPageLoad(){
        Intent i = new Intent(this, LoginScreenActivity.class);
        startActivity(i);
    }
}
