package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity2 extends AppCompatActivity {

    ProgressBar progressBar;
    EditText userEmail,userPass;
    Button userLogin,google_signin;
    TextView createAccount,forgetPassword,displaysiginoptions,contwithemail;
    FirebaseAuth firebaseAuth;
    RelativeLayout contwithemaillayout, loginoptionslayout;


    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
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
        google_signin=findViewById(R.id.google_signIn);
        contwithemail=findViewById(R.id.text_view_continue_with_email);
        loginoptionslayout=findViewById(R.id.sigin_options_layout);
        contwithemaillayout=findViewById(R.id.continue_with_email_layout);
        displaysiginoptions=findViewById(R.id.display_signin_options);

        firebaseAuth = FirebaseAuth.getInstance();
        createRequest();

        google_signin.setOnClickListener(view -> signIn());

        contwithemail.setOnClickListener(view -> {
            loginoptionslayout.setVisibility(View.GONE);
            contwithemaillayout.setVisibility(View.VISIBLE);
        });
        displaysiginoptions.setOnClickListener(view -> {
            loginoptionslayout.setVisibility(View.VISIBLE);
            contwithemaillayout.setVisibility(View.GONE);
        });
        userLogin.setOnClickListener(view -> {
            if(userEmail.getText().toString().isEmpty() || userPass.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity2.this, "Enter required details!", Toast.LENGTH_SHORT).show();
            }
            else {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(),
                        userPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity2.this, "Please verify your email address"
                                                , Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity2.this, task.getException().getMessage()
                                            , Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        createAccount.setOnClickListener(view -> startActivity(new Intent(LoginActivity2.this, RegisterActivity2.class)));
        forgetPassword.setOnClickListener(view -> startActivity(new Intent(LoginActivity2.this,ForgotPasswordActivity.class)));
    }

    private void createRequest() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately

            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        progressBar.setVisibility(View.VISIBLE);
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(LoginActivity2.this, "Sigin Success", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity2.this, "Google sigin failed", Toast.LENGTH_SHORT).show();
                        }
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