package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import Adapters.VideoListAdapter;
import models_youtubeapi.Apimodel;
import models_youtubeapi.VideoYT;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class VideosListActivity extends AppCompatActivity {
    private VideoListAdapter adapter;
    private List<VideoYT> videoList=new ArrayList<>();
    private static String token;
    private static float totalresults;
    private static final float resultsperpage=50;
    private String playlist_id;
    Button next;
    String playlistitems_url;
    TextView videocount;
    String VIDEOS_AVAILABLE="Videos in Playlist: ";


    public VideosListActivity() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        checkConnection();
        Intent intent1=getIntent();
        playlist_id=intent1.getStringExtra("PlaylistId");

        next=findViewById(R.id.nextpage);
        videocount=findViewById(R.id.video_count);
        RecyclerView rv= findViewById(R.id.recyclerView);
        adapter=new VideoListAdapter(VideosListActivity.this,videoList,token);
        LinearLayoutManager manager = new LinearLayoutManager(VideosListActivity.this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
        Button rate = findViewById(R.id.rate_btn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if(videoList.size()== 0){
            getJson("null");
        }

          next.setOnClickListener(view -> {
              checkConnection();
              totalresults=totalresults-resultsperpage;
              Log.e("results",totalresults+"");
              getJson(token);
              Toast.makeText(VideosListActivity.this, "Scroll", Toast.LENGTH_SHORT).show();
          });

        rate.setOnClickListener(view -> {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + getPackageName())));

            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            }
        });

    }


    private void getJson(String nextpagetoken) {
        if(nextpagetoken.equals("null")) {
             playlistitems_url = YoutubeAPI.BASE_URL + YoutubeAPI.request + playlist_id + YoutubeAPI.apikey;

        }
        else{
             playlistitems_url = YoutubeAPI.BASE_URL + YoutubeAPI.request + playlist_id + YoutubeAPI.apikey+YoutubeAPI.nextpage+nextpagetoken;
        }

        Log.e("playlistitems_url",playlistitems_url);
        Call<Apimodel> data =YoutubeAPI.getHomeVideo().getYT(playlistitems_url);
        data.enqueue(new Callback<Apimodel>() {
            @Override
            public void onResponse(Call<Apimodel> call, Response<Apimodel> response) {
                if(response.errorBody() != null){
                    Log.v(TAG, "onresponse: "+ response.errorBody());

                }
                else{
                    Apimodel am=response.body();
                    videoList.addAll(am.getItems());
                    if(nextpagetoken.equals("null")) {
                        totalresults = am.getPageInfo().getTotalResults();
                        videocount.setText(VIDEOS_AVAILABLE+(int) totalresults);
                    }
                     if(totalresults>resultsperpage)
                     {
                         Log.e("inside if",totalresults+"");
                         token=am.getNextPageToken();
                         Log.e("token",token);
                     }
                     else
                     {
                         next.setEnabled(false);
                         Log.e("token","a"+token);
                     }


                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Apimodel> call, Throwable t) {
                checkConnection();
                Log.e(TAG,"onFailure ",t);
            }
        });
    }
    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if (null != activenetwork) {
            if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
            }
        } else {
            View view =findViewById(R.id.videolistactivity_constraintlayout);
            Snackbar snackbar = Snackbar.make(view, "Kindly Enable Internet Connection To View Results", Snackbar.LENGTH_LONG);
            snackbar.setDuration(5000);
            snackbar.show();
        }
    }

}