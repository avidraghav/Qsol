package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

public class Expendable_loader extends AppCompatActivity {
    private  static  int SPLASH_SCREEN1 =3000;
    private  static  int SPLASH_SCREEN2 =1000;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expendableloader);
        Intent intent=getIntent();
        key=intent.getStringExtra("reference");

        if(key.equals("btech"))
        {
            ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
            Sprite wave = new Wave();
            progressBar.setIndeterminateDrawable(wave);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Expendable_loader.this, Btech_expendable_list.class);
                    startActivity(intent);
                    finish();

                }
            }, SPLASH_SCREEN1);
        }
        if(key.equals("diploma"))
        {
            ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
            Sprite wave = new Wave();
            progressBar.setIndeterminateDrawable(wave);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Expendable_loader.this, Diploma_expendable_list.class);
                    startActivity(intent);
                    finish();

                }
            }, SPLASH_SCREEN1);
        }
        if(key.equals("management"))
            {
                ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
                Sprite wave = new Wave();
                progressBar.setIndeterminateDrawable(wave);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Expendable_loader.this, Management_expendable_list.class);
                    startActivity(intent);
                    finish();

                }
            }, SPLASH_SCREEN2);
        }
        if(key.equals("computer_applications"))
        {
            ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
            Sprite wave = new Wave();
            progressBar.setIndeterminateDrawable(wave);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Expendable_loader.this, ComputerApplications_expendable_list.class);
                    startActivity(intent);
                    finish();

                }
            }, SPLASH_SCREEN2);
        }


    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
