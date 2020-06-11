package com.example.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Button btechbtn,bbabtn,mbabtn,bcabtn,mcabtn,kubtn;
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
        checkConnection();

    }

    public void showfirst(View view) {
//        startActivity(new Intent(this,SplashScreen_branchlist.class));
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
//            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//            builder.setTitle("Turn on Internet connection");
//
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//
//                }
//            });
//            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                         moveTaskToBack(true);
//                         android.os.Process.killProcess(android.os.Process.myPid());
//                         System.exit(1);
//                }
//            });
//
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
        }
    }


}
