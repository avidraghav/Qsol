package com.example.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    }

    public void showfirst(View view) {
        Intent i=new Intent(this,Btech_expendable_list.class);
        startActivity(i);
    }

}
