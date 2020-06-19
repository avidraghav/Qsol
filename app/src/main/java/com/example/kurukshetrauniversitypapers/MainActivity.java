package com.example.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btechbtn,bbabtn,mbabtn,bcabtn,mcabtn,kubtn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btechbtn=findViewById(R.id.btechbtn);
        bbabtn=findViewById(R.id.bbabtn);
        mbabtn=findViewById(R.id.mbabtn);
        bcabtn=findViewById(R.id.bcabtn);
        mcabtn=findViewById(R.id.mcabtn);
        kubtn=findViewById(R.id.kubtn);
        mAuth=FirebaseAuth.getInstance();
        checkConnection();

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            case R.id.action_logout:
                if((mAuth.getCurrentUser()==null)){
                    Toast.makeText(this, "You are not logged in", Toast.LENGTH_SHORT).show();
            }
                else {
                    mAuth.getInstance().signOut();
                    //finish();
                    Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show();
                   // startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
            case R.id.feedback_option:
                startActivity(new Intent(MainActivity.this,FeedbackActivity.class));
                break;

        }
        return true;
    }


}
