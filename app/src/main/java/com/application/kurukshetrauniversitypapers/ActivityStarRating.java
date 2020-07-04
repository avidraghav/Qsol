package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityStarRating extends AppCompatActivity {
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_rating);

        final RatingBar ratingBar=findViewById(R.id.ratingbar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        Button button=findViewById(R.id.submit_rating);
        final TextView textView=findViewById(R.id.show_rating);

       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @SuppressLint("SetTextI18n")
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               switch ((int)rating) {
                   case 1:
                   textView.setText("The experience was bad");
                   break;
                   case 2:
                       textView.setText("The experience was poor");
                       break;
                   case 3:
                       textView.setText("The experience was fair");
                       break;
                   case 4:
                       textView.setText("The experience was good");
                       break;
                   case 5:
                       textView.setText("The experience was excellent");
                       break;

               }
               databaseReference=FirebaseDatabase.getInstance().getReference("Feedback/");
               databaseReference.child(databaseReference.push().getKey()).setValue(ratingBar.getRating());
              // startActivity(new Intent(ActivityStarRating.this,MainActivity.class));
               Toast.makeText(ActivityStarRating.this, "Thanks for submitting the feedback", Toast.LENGTH_SHORT).show();

           }
       });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);

            }
        });
    }
    public void  send(){

    }
}
