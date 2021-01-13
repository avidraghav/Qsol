package com.application.kurukshetrauniversitypapers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.lang.reflect.Array;
import java.util.ArrayList;

import utils.AppUpdateChecker;
import utils.NotificationGetter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_RUN_COUNTER = "run counter";
    public static final String KEY_NOTIFICATION_TEXT="notification text";
    public static final String KEY_NOTIFICATION_URL="notification url";

    private Button signUpButton;
    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private TextView totalPapersTextView,newNotificationsTextView;
    private String notificationUrl;
    public String notificationText;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalPapersTextView = findViewById(R.id.tv_total_papers);
        mAuth = FirebaseAuth.getInstance();
        signUpButton = findViewById(R.id.bt_sign_up);
        newNotificationsTextView=findViewById(R.id.notification_textview);
        PieChart pieChart = (PieChart) findViewById(R.id.chart);



        handleNotification();
        handleAnimations();
        setupToolbar();
        setupDrawer();
        getEntries();

        pieDataSet = new PieDataSet(pieEntries, " ");
        pieData= new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("Paper distribution in Percentage");
        pieChart.animate().setDuration(2000);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawSliceText(false);
        pieChart.setUsePercentValues(true);
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setColors(new int[] { R.color.colorPrimary, R.color.fontColor, R.color.colorAccent, R.color.colorPressed }, getBaseContext());
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);


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

    private void checkUpdate() {
        AppUpdateChecker appUpdateChecker=new AppUpdateChecker(this);  //pass the activity in constructure
        appUpdateChecker.checkForUpdate(false); //mannual check false here
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
            startCountAnimation();
        } else totalPapersTextView.setText("1575");
    }

    /**
     * Starts animation that counts upwards in {@link #totalPapersTextView}.
     */
    private void startCountAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 1575);
        animator.setDuration(2000);
        animator.addUpdateListener(animation -> totalPapersTextView.setText(animation.getAnimatedValue().toString()));
        animator.start();
    }

    /**
     * Starts an activity.
     *
     * @param clazz the class of the activity to start. Needs to be an extension of {@link AppCompatActivity}.
     */
    private void startActivity(@NonNull Class<? extends AppCompatActivity> clazz) {
        startActivity(new Intent(MainActivity.this, clazz));
    }

    /**
     * Handles menu items / button clicks that start a new activity.
     *
     * @param view the menu item or button that was clicked
     */
    public void onItemClicked(View view) {
        Class<? extends AppCompatActivity> clazz = null;
        switch (view.getId()) {
            case R.id.bt_quick_search:
                clazz = Filters.class;
                break;
//            case R.id.bt_university_websites:
//                clazz = Websites.class;
//                break;
//            case R.id.bt_diploma:
//                clazz = Diploma_expendable_list.class;
//                break;
//            case R.id.bt_btech:
//                clazz = Btech_expendable_list.class;
//                break;
//            case R.id.bt_bba_mba:
//                clazz = Management_expendable_list.class;
//                break;
//            case R.id.bt_bca_mca:
//                clazz = ComputerApplications_expendable_list.class;
//                break;
            case R.id.bt_sign_up:
                clazz = RegisterActivity2.class;
            case R.id.notification_textview:

        }
        if (clazz == null) return;
        startActivity(clazz);
    }

    public void updateNavHeader() {
        NavigationView navigationView = findViewById(R.id.nv_main);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.username);
        TextView navWelcome = headerView.findViewById(R.id.txt_welcome);
        if (mAuth.getCurrentUser() != null && mAuth.getCurrentUser().isEmailVerified()) {
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
            }
        } else {
            View view =findViewById(R.id.drawer_layout);
            Snackbar snackbar = Snackbar.make(view, "No Internet Connection!", Snackbar.LENGTH_SHORT);
            snackbar.setDuration(3000);
            snackbar.show();

        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.option_menu2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.quick:
//                startActivity(new Intent(MainActivity.this, Filters.class));
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//        return true;
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_signin:
                if (signUpButton.getVisibility()==View.VISIBLE) {
                    startActivity(new Intent(MainActivity.this, LoginActivity2.class));
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
                }
                catch (ActivityNotFoundException e) {
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
        checkUpdate();
        updateNavHeader();
        checkConnection();
        super.onStart();
    }

    public void handleNotification() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("IN/Notifications/");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                NotificationGetter notificationGetter = dataSnapshot.getValue(NotificationGetter.class);
                notificationText=notificationGetter.getText();
                if(notificationText.equals(" ")){
                    // do nothing
                }
                else{
                    findViewById(R.id.notification_textview).setBackgroundResource(R.drawable.notification_textview_shape);
                    Animation fadeIn = AnimationUtils.loadAnimation(getBaseContext(), R.anim.reveal_details);
                    findViewById(R.id.notification_textview).setAnimation(fadeIn);
                }
                newNotificationsTextView.setText(notificationText);
                notificationUrl=notificationGetter.getUrl();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void notificationClicked(View view) {
        if(newNotificationsTextView.getText().equals(" ")){

        }
        else {
            startActivity(new Intent(MainActivity.this,DatesheetsActivity.class));
        }
    }
    private void getEntries(){
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(791, "B.tech"));
        pieEntries.add(new PieEntry(468, "Diploma"));
        pieEntries.add(new PieEntry(111, "MBA/BBA"));
        pieEntries.add(new PieEntry(82,  "BCA/MCA"));

    }
}
