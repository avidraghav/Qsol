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

public class LoginActivity2 extends AppCompatActivity {

    ProgressBar progressBar;
    EditText userEmail;
    EditText userPass;
    Button userLogin;
    TextView createAccount;
    TextView forgetPassword;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressbar);
        userEmail = findViewById(R.id.text_email);
        userPass = findViewById(R.id.edit_text_password);
        userLogin = findViewById(R.id.button_sign_in);
        createAccount=findViewById(R.id.text_view_register);
        forgetPassword=findViewById(R.id.text_view_forget_password);


        firebaseAuth = FirebaseAuth.getInstance();

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(),
                        userPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if(task.isSuccessful()){
                                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                                        finish();
                                    }else{
                                        Toast.makeText(LoginActivity2.this, "Please verify your email address"
                                                , Toast.LENGTH_LONG).show();
                                    }
                                }else{
                                    Toast.makeText(LoginActivity2.this, task.getException().getMessage()
                                            , Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity2.this, RegisterActivity2.class));
            }
        });
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity2.this,ForgotPasswordActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(LoginActivity2.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter", "no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}