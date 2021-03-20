package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapters.VideoAdapter2;
import models_youtubeapi.Apimodel;
import models_youtubeapi.VideoYT;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class VideosListActivity extends AppCompatActivity {
    private VideoAdapter2 adapter;
    private LinearLayoutManager manager;
    private List<VideoYT> videoList=new ArrayList<>();
    private static String token;
    private static float totalresults;
    private static final float resultsperpage=50;
    private String playlist_id;
    private Button rate;
    Button next;
    String url;

    public VideosListActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_video_list);

        Intent intent1=getIntent();
        playlist_id=intent1.getStringExtra("PlaylistId");

        next=findViewById(R.id.nextpage);
        RecyclerView rv= findViewById(R.id.recyclerView);
        adapter=new VideoAdapter2(VideosListActivity.this,videoList,token);
        manager=new LinearLayoutManager(VideosListActivity.this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
        rate=findViewById(R.id.rate_btn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if(videoList.size()== 0){
            getJson("null");
        }

          next.setOnClickListener(view -> {
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
             url = YoutubeAPI.BASE_URL + YoutubeAPI.request + playlist_id + YoutubeAPI.apikey;
        }
        else{
             url = YoutubeAPI.BASE_URL + YoutubeAPI.request + playlist_id + YoutubeAPI.apikey+YoutubeAPI.nextpage+nextpagetoken;

        }
        Log.e("url",url);
        Call<Apimodel> data =YoutubeAPI.getHomeVideo().getYT(url);
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
                Log.e(TAG,"onFailure ",t);
            }
        });
    }


}