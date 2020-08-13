package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText e1=(EditText) findViewById(R.id.sender_name);
        final EditText e2=(EditText) findViewById(R.id.feedback);
        Button b1=(Button)findViewById(R.id.button_send);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty() && e2.getText().toString().isEmpty()){
                    Toast.makeText(FeedbackActivity.this, "Kindly fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("mailto:" + "qsol.info@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "My contribution to Qsol");
                    intent.putExtra(Intent.EXTRA_TEXT, "/* Contribute by\n 1. Sending previous year exam papers\n 2. Reporting bugs, suggesting features\n 3. Collaborate for maintaining the application */");
                    startActivity(intent);
                }
            }
        });


    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(FeedbackActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();

    }
}
