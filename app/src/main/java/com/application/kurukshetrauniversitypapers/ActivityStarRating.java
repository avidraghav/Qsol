package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityStarRating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_rating);

        final RatingBar ratingBar=findViewById(R.id.ratingbar);
        Button button=findViewById(R.id.submit_rating);
        final TextView textView=findViewById(R.id.show_rating);

       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               textView.setText(rating+"");
           }
       });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=firebaseDatabase.getReference("Feedback/");
                databaseReference.child(databaseReference.push().getKey()).setValue(ratingBar.getRating());
                Toast.makeText(ActivityStarRating.this, "Thanks for submitting the feedback", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
