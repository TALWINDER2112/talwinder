package com.example.admin.assignment3.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.assignment3.R;

/**
 * class
 */
public class MainActivity extends AppCompatActivity {

    private final int delay = 2000;
    private Button btnNext;
    private Intent intent;
    @Override
    protected void onCreate(final   Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = (Button) findViewById(R.id.btn_next);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnNext.setVisibility(View.VISIBLE);
            }
        }, delay);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                intent = new Intent(getApplicationContext(), ScreenBActivity.class);
                startActivity(intent);
            }
        });

    }
}
