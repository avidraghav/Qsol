package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class CreditActivity extends AppCompatActivity {
 TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p13,p14,p16,p17,p18,p19;
 Button contribute;
 LinearLayout linearLayout;
 AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        p1=findViewById(R.id.person1);
        p2=findViewById(R.id.person2);
        p3=findViewById(R.id.person3);
        p4=findViewById(R.id.person4);
        p5=findViewById(R.id.person5);
        p6=findViewById(R.id.person6);
        p7=findViewById(R.id.person7);
        p8=findViewById(R.id.person8);
        p9=findViewById(R.id.person9);
        p10=findViewById(R.id.person10);
        p11=findViewById(R.id.person11);
        p13=findViewById(R.id.person13);
        p14=findViewById(R.id.person14);
        p16=findViewById(R.id.person16);
        p17=findViewById(R.id.person17);
        p18=findViewById(R.id.person18);
        p19=findViewById(R.id.person19);

        contribute=findViewById(R.id.contribute);


        linearLayout=findViewById(R.id.linear);
        animatorSet=new AnimatorSet();

        ObjectAnimator fadeout= ObjectAnimator.ofFloat(linearLayout,"alpha",0.5f,0.1f);
        fadeout.setDuration(500);
        ObjectAnimator fadein= ObjectAnimator.ofFloat(linearLayout,"alpha",0.1f,0.5f);
        fadein.setDuration(500);
        animatorSet.play(fadein).after(fadeout);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorSet.start();
            }
        });
        animatorSet.start();


//        p1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/raghav-aggarwal-74b873143/"));
//                startActivity(Browserintent);
//            }
//        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/prachi-garg-00a04b18b/"));
                startActivity(Browserintent);
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vijayant-bhardwaj-498416172/"));
                startActivity(Browserintent);
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/aashima-nanda-b7b683143/"));
                startActivity(Browserintent);
            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/prachi-garg-00a04b18b/"));
                startActivity(Browserintent);
            }
        });
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sj5/"));
                startActivity(Browserintent);
            }
        });
        p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/manav-sharma-a917251b2/"));
                startActivity(Browserintent);
            }
        });
        p8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/lakshay-nandal-a6b801171/"));
                startActivity(Browserintent);
            }
        });
        p9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/palak-dua-287a1a193/"));
                startActivity(Browserintent);
            }
        });
        p11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/khyati24/"));
                startActivity(Browserintent);
            }
        });
        p13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/chirag-sharma-3b99961b3/"));
                startActivity(Browserintent);
            }
        });
        p14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sarthak-pal-8638ba171/"));
                startActivity(Browserintent);
            }
        });
        p16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiverr.com/s2/5ff15b31e8"));
                startActivity(Browserintent);
            }
        });
        p17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/yash-ahuja-551b92192"));
                startActivity(Browserintent);
            }
        });
        p18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vidit-choudhary-21aa111a6"));
                startActivity(Browserintent);
            }
        });
        contribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/raghavagg01/Qsol/blob/master/README.md#everyone-can-contribute-to-qsol-by"));
                startActivity(Browserintent);
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(CreditActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();

    }
}