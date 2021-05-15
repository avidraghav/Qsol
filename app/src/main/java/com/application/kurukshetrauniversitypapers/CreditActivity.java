package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class CreditActivity extends AppCompatActivity {
 TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p13,p14,p16,p17,p18,p19,p20,p21,p22,p23,p27,p28,p31,p32,p34,p35,p36,p40,p41,p42;
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
        p20=findViewById(R.id.person20);
        p21=findViewById(R.id.person21);
        p22=findViewById(R.id.person22);
        p23=findViewById(R.id.person23);
        p27=findViewById(R.id.person27);
        p28=findViewById(R.id.person28);
        p31=findViewById(R.id.person31);
        p32=findViewById(R.id.person32);
        p34=findViewById(R.id.person34);
        p35=findViewById(R.id.person35);
        p36=findViewById(R.id.person36);
        p40=findViewById(R.id.person40);
        p41=findViewById(R.id.person41);
        p42=findViewById(R.id.person42);


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


        p1.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/qsoltech/"));
            startActivity(Browserintent);
        });
        p2.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/prachi-garg-00a04b18b/"));
            startActivity(Browserintent);
        });
        p3.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vijayant-bhardwaj-498416172/"));
            startActivity(Browserintent);
        });
        p4.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/aashima-nanda-b7b683143/"));
            startActivity(Browserintent);
        });
        p5.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/prachi-garg-00a04b18b/"));
            startActivity(Browserintent);
        });
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sj5/"));
                startActivity(Browserintent);
            }
        });
        p7.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/manav-sharma-a917251b2/"));
            startActivity(Browserintent);
        });
        p8.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/lakshay-nandal-a6b801171/"));
            startActivity(Browserintent);
        });
        p9.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/palak-dua-287a1a193/"));
            startActivity(Browserintent);
        });
        p11.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/khyati24/"));
            startActivity(Browserintent);
        });
        p13.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/chirag-sharma-3b99961b3/"));
            startActivity(Browserintent);
        });
        p14.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sarthak-pal-8638ba171/"));
            startActivity(Browserintent);
        });
        p16.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiverr.com/s2/5ff15b31e8"));
            startActivity(Browserintent);
        });
        p17.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/yash-ahuja-551b92192"));
            startActivity(Browserintent);
        });
        p18.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vidit-choudhary-21aa111a6"));
            startActivity(Browserintent);
        });
        p19.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abhishek-braru-578967141/"));
            startActivity(Browserintent);
        });
        p20.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/christos-malliaridis/"));
            startActivity(Browserintent);
        });
        p21.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/prachi-garg-00a04b18b/"));
            startActivity(Browserintent);
        });
        p22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/taksh-mehta-29b372193/"));
                startActivity(Browserintent);
            }
        });
        p23.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mayank-arora-7031a319a/"));
            startActivity(Browserintent);
        });
        p27.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abhishek-braru-578967141/"));
            startActivity(Browserintent);
        });
        p27.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abhishek-braru-578967141/"));
            startActivity(Browserintent);
        });
        p28.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/lakshay-nandal-a6b801171/"));
            startActivity(Browserintent);
        });
        p31.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rajat-sharma-06ba9a141/"));
            startActivity(Browserintent);
        });
        p32.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/ram-rawat-b8424b190"));
            startActivity(Browserintent);
        });
        p34.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sarthak-pal-8638ba171/"));
            startActivity(Browserintent);
        });
        p35.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/astha-malhotra-ab7242195/"));
            startActivity(Browserintent);
        });
        p36.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sugandha-malhotra-a95685193/"));
            startActivity(Browserintent);
        });
        p40.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sachinadhwaria/"));
            startActivity(Browserintent);
        });
        p41.setOnClickListener(view -> {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/gaurav-kumar-pandit-9319651b0/"));
            startActivity(Browserintent);
        });
        p42.setOnClickListener(view ->{
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rohan-saini-22b461201/"));
            startActivity(Browserintent);
        });
        contribute.setOnClickListener(view -> {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + getPackageName())));
            }
            catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
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