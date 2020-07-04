package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    Button btechbtn,quick_search,mbabtn,bcabtn,mcabtn,kubtn;
    FirebaseAuth mAuth;
   // Animation zoomin,zoomout;
    TextView total_papers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btechbtn=findViewById(R.id.btechbtn);
        quick_search=findViewById(R.id.quick_search);
        mbabtn=findViewById(R.id.mbabtn);
        bcabtn=findViewById(R.id.bcabtn);
        mcabtn=findViewById(R.id.mcabtn);
        kubtn=findViewById(R.id.kubtn);
        total_papers=findViewById(R.id.total_papers);
        mAuth=FirebaseAuth.getInstance();
        checkConnection();
        startCountAnimation();
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        total_papers.setText("764");


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        quick_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Filter_search.class));
            }
        });


    }

    public void showfirst(View view) {

        Intent i=new Intent(this,Btech_expendable_list.class);
        startActivity(i);
    }
    public void progress(View view) {
        Toast.makeText(this, "Will be uploaded soon", Toast.LENGTH_SHORT).show();
    }
    public void website(View view){
        Intent Browserintent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.kuk.ac.in/"));
        startActivity(Browserintent);
    }



    public void checkConnection(){
        ConnectivityManager manager=(ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork=manager.getActiveNetworkInfo();
        if(null!=activenetwork) {

            if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                //Toast.makeText(this, "Internet not connected", Toast.LENGTH_SHORT).show();
            }
        }
       else {
            Toast.makeText(this, "Turn on internet connection", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.source_code:
                Intent Browserintent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/raghavagg01/Qsol"));
                startActivity(Browserintent);
//                if((mAuth.getCurrentUser()==null)){
//                    Toast.makeText(this, "You are not logged in", Toast.LENGTH_SHORT).show();
//            }
//                else {
//                    mAuth.getInstance().signOut();
//                    //finish();
//                    Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show();
//                   // startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                }
                break;
//            case R.id.feedback_option:
//                startActivity(new Intent(MainActivity.this,ActivityStarRating.class));
//                break;

        }
        return true;
    }
    private void startCountAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 764);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                total_papers.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this,ActivityStarRating.class));
        super.onBackPressed();
    }


}
