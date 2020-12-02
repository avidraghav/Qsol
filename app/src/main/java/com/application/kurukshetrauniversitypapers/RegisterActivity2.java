package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity2 extends AppCompatActivity {
    ProgressBar progressBar;
    EditText email;
    EditText password;
    Button signup;
    TextView login;
   // Button forgotPass;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressBar = findViewById(R.id.progressbar);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.edit_text_password);
        signup = findViewById(R.id.button_register);
        login = findViewById(R.id.text_view_login);
       // forgotPass = findViewById(R.id.btnUserForgottPass);


        firebaseAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),
                        password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    firebaseAuth.getCurrentUser().sendEmailVerification()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(RegisterActivity2.this, "Registered successfully. Please check your email for verification",
                                                                Toast.LENGTH_LONG).show();
                                                        email.setText("");
                                                        password.setText("");
                                                        startActivity(new Intent(RegisterActivity2.this,LoginActivity2.class));
                                                    }else{
                                                        Toast.makeText(RegisterActivity2.this,  task.getException().getMessage(),
                                                                Toast.LENGTH_LONG).show();
                                                    }

                                                }
                                            });
                                } else {
                                    Toast.makeText(RegisterActivity2.this, task.getException().getMessage(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity2.this, LoginActivity2.class));
            }
        });

//

    }
}