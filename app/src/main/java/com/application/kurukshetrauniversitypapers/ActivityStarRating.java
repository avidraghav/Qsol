package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityStarRating extends AppCompatActivity {
    //DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_rating);

       // final RatingBar ratingBar=findViewById(R.id.ratingbar);
      //  LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
       // stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        Button dismiss=findViewById(R.id.dismiss);
        Button yes=findViewById(R.id.yes);
       // final TextView textView=findViewById(R.id.show_rating);

//       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//           @SuppressLint("SetTextI18n")
//           @Override
//           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//               switch ((int)rating) {
//                   case 1:
//                   textView.setText("The experience was bad");
//                   break;
//                   case 2:
//                       textView.setText("The experience was poor");
//                       break;
//                   case 3:
//                       textView.setText("The experience was fair");
//                       break;
//                   case 4:
//                       textView.setText("The experience was good");
//                       break;
//                   case 5:
//                       textView.setText("The experience was excellent");
//                       break;
//
//               }
//               databaseReference=FirebaseDatabase.getInstance().getReference("Feedback/");
//               databaseReference.child(databaseReference.push().getKey()).setValue(ratingBar.getRating());
//               Toast.makeText(ActivityStarRating.this, "Thanks for submitting the feedback", Toast.LENGTH_SHORT).show();
//
//               final Handler handler = new Handler();
//               handler.postDelayed(new Runnable() {
//                   @Override
//                   public void run() {
//                       System.exit(0);
//                   }
//               }, 1500);
//
//
//           }
//       });


       yes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   startActivity(new Intent(Intent.ACTION_VIEW,
                           Uri.parse("market://details?id=" + getPackageName())));
               } catch (ActivityNotFoundException e) {
                   startActivity(new Intent(Intent.ACTION_VIEW,
                           Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
               }
           }
       });
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
                finish();

            }
        });
    }

}
