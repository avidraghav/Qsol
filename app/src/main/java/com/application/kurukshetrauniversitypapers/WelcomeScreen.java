package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {
ImageView imageView;
TextView textView2;
Animation top, bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_screen);

        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);
        imageView.setAnimation(top);
        textView2.setAnimation(bottom);
        int SPLASH_SCREEN = 2000;
        new Handler().postDelayed(() -> {
                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                intent.putExtra("run counter","yes");
                startActivity(intent);
                finish();

        }, SPLASH_SCREEN);

    }

    @Override
    public void onBackPressed() {
        System.exit(0);
        super.onBackPressed();
    }
}
