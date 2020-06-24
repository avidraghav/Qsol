package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.sprite.Sprite;

import com.github.ybq.android.spinkit.style.Wave;

public class Expendable_loader extends AppCompatActivity {
    private  static  int SPLASH_SCREEN =2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expendableloader);


        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite wave = new Wave();
        progressBar.setIndeterminateDrawable(wave);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Expendable_loader.this, Btech_expendable_list.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);


    }
}
