package com.application.kurukshetrauniversitypapers;

import android.animation.ValueAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.application.kurukshetrauniversitypapers.expandablelist.ExpandableListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import static model.BranchGroup.GROUP_BTECH;
import static model.BranchGroup.GROUP_COMPUTER_APPLICATIONS;
import static model.BranchGroup.GROUP_DIPLOMA;
import static model.BranchGroup.GROUP_MANAGEMENT;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_RUN_COUNTER = "run counter";

    private Button signUpButton;
    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private TextView totalPapersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPapersTextView = findViewById(R.id.tv_total_papers);
        mAuth = FirebaseAuth.getInstance();
        signUpButton = findViewById(R.id.bt_sign_up);

        handleAnimations();
        setupToolbar();
        setupDrawer();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

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
    }

    /**
     * Instantiates and sets up the toolbar of the activity
     */
    private void setupToolbar() {
        toolbar = findViewById(R.id.tb_main);
        toolbar.setTitle("");
        // toolbar.setLogo(R.drawable.qslow);
        //toolbar.setBackground(getResources().getDrawable( R.drawable.actionbar_shape));
        setSupportActionBar(toolbar);
    }

    /**
     * Instantiates and sets up the drawer of the activity
     */
    private void setupDrawer() {
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nv_main);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * If {@link #KEY_RUN_COUNTER} is "yes", execute count animation and fade in animation
     * of card views. Otherwise only the total papers text is set and no animation is triggered.
     */
    private void handleAnimations() {
        Intent intent = getIntent();
        String runCounter = intent.getStringExtra(KEY_RUN_COUNTER);
        if ("yes".equals(runCounter)) {
            Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            startCountAnimation();
            findViewById(R.id.cv_btech).setAnimation(fadeIn);
            findViewById(R.id.cv_bca_mca).setAnimation(fadeIn);
            findViewById(R.id.cv_university_websites).setAnimation(fadeIn);
            findViewById(R.id.cv_bba_mba).setAnimation(fadeIn);
            findViewById(R.id.cv_quick_search).setAnimation(fadeIn);
            findViewById(R.id.cv_diploma).setAnimation(fadeIn);
        } else totalPapersTextView.setText("1542");
    }

    /**
     * Starts animation that counts upwards in {@link #totalPapersTextView}.
     */
    private void startCountAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 1542);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                totalPapersTextView.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

    /**
     * Starts an activity.
     *
     * @param clazz the class of the activity to start. Needs to be an extension of {@link AppCompatActivity}.
     */
    private void startActivity(@NonNull Class<? extends AppCompatActivity> clazz, String reference) {
        Intent intent = new Intent(this, clazz);
        // TODO Replace string extra key with constant
        intent.putExtra("reference", reference);
        startActivity(intent);
    }

    /**
     * Handles menu items / button clicks that start a new activity.
     *
     * @param view the menu item or button that was clicked
     */
    public void onItemClicked(View view) {
        Class<? extends AppCompatActivity> clazz = null;
        String reference = null;
        switch (view.getId()) {
            case R.id.bt_quick_search:
                clazz = Filters.class;
                break;
            case R.id.bt_university_websites:
                clazz = Websites.class;
                break;
            case R.id.bt_diploma:
                clazz = ExpandableListActivity.class;
                reference = GROUP_DIPLOMA;
                break;
            case R.id.bt_btech:
                clazz = ExpandableListActivity.class;
                reference = GROUP_BTECH;
                break;
            case R.id.bt_bba_mba:
                clazz = ExpandableListActivity.class;
                reference = GROUP_MANAGEMENT;
                break;
            case R.id.bt_bca_mca:
                clazz = ExpandableListActivity.class;
                reference = GROUP_COMPUTER_APPLICATIONS;
                break;
            case R.id.bt_sign_up:
                clazz = RegisterActivity.class;
        }
        if (clazz == null) return;
        startActivity(clazz, reference);
    }

    public void updateNavHeader() {
        NavigationView navigationView = findViewById(R.id.nv_main);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.username);
        TextView navWelcome = headerView.findViewById(R.id.txt_welcome);
        if (mAuth.getCurrentUser() != null) {
            navWelcome.setVisibility(View.VISIBLE);
            signUpButton.setVisibility(View.INVISIBLE);
            navUsername.setText(mAuth.getCurrentUser().getEmail());
            navigationView.getMenu().findItem(R.id.action_signin).setVisible(false);
            navigationView.getMenu().findItem(R.id.action_logout).setVisible(true);
        } else {
            navWelcome.setVisibility(View.INVISIBLE);
            signUpButton.setVisibility(View.VISIBLE);
            navUsername.setText("Sign in to Share Papers");
            navigationView.getMenu().findItem(R.id.action_signin).setVisible(true);
            navigationView.getMenu().findItem(R.id.action_logout).setVisible(false);
        }
    }

    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if (null != activenetwork) {

            if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // Toast.makeText(this, "Internet connected", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Turn on internet connection", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.quick:
                startActivity(new Intent(MainActivity.this, Filters.class));
                break;
//
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_signin:
                if (mAuth.getCurrentUser() == null) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    break;
                } else {
                    Toast.makeText(this, "You are already logged in", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.action_logout:
                if ((mAuth.getCurrentUser() == null)) {
                    Toast.makeText(this, "You are not logged in", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    String[] items = {"Yes", "No"};
                    androidx.appcompat.app.AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("Are you sure to log out?");
                    dialog.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                FirebaseAuth.getInstance().signOut();
                                updateNavHeader();
                                Toast.makeText(MainActivity.this, "You have been logged out", Toast.LENGTH_SHORT).show();
                            }
                            if (which == 1) {

                            }
                        }
                    });
                    dialog.create().show();
                    break;
                }
            case R.id.credits:
                startActivity(new Intent(MainActivity.this, CreditActivity.class));
                break;
            case R.id.rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getPackageName())));
                    break;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    break;
                }

            case R.id.write_feedback:
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("mailto:" + "qsol.info@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "My contribution to Qsol");
                intent.putExtra(Intent.EXTRA_TEXT, "/* Contribute by\n 1. Attaching previous year exam papers\n 2. Reporting bugs, suggesting features\n 3. Collaborate for maintaining the application */");
                startActivity(intent);
                break;


        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getIntent().getBooleanExtra("EXIT", false)) {
                finish();
            }
            finish();
        }
    }

    @Override
    protected void onStart() {
        updateNavHeader();
        checkConnection();
        super.onStart();
    }

}
