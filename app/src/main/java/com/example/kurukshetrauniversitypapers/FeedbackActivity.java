package com.example.kurukshetrauniversitypapers;

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

                Intent intent=new Intent(Intent.ACTION_VIEW,
                        Uri.parse("mailto:"+ "raghavaggarwal776@gmail.com"));
                       intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback for KUK papers application");
                       intent.putExtra(Intent.EXTRA_TEXT,"Name: "+e1.getText().toString()+"\n Feedback: "+e2.getText().toString());
                startActivity(intent);
            }
        });


    }
}
