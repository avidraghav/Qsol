package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

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
    private String token;
    private String playlist_id;
    Button next;
    public VideosListActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        Intent intent1=getIntent();
        playlist_id=intent1.getStringExtra("Playlistid");

        next=findViewById(R.id.nextpage);
        RecyclerView rv= findViewById(R.id.recyclerView);
        adapter=new VideoAdapter2(VideosListActivity.this,videoList,token);
        manager=new LinearLayoutManager(VideosListActivity.this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);


        if(videoList.size()== 0){
            getJson();
        }



    }
    private void getJson() {
        String url= YoutubeAPI.BASE_URL+ YoutubeAPI.request+playlist_id+YoutubeAPI.apikey;
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