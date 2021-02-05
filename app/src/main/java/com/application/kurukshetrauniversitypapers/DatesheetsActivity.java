package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.ArrayList;
import java.util.List;

import Adapters.DatesheetActivityAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.DatesheetsApiHandler;
import utils.DatesheetsApiModel;
import utils.DatesheetsInfo;

import static android.content.ContentValues.TAG;

public class DatesheetsActivity extends AppCompatActivity {
    private DatesheetActivityAdapter adapter;
    private List<DatesheetsInfo> videoList=new ArrayList<>();
    private LinearLayoutManager manager;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datesheets);
        RecyclerView rv= findViewById(R.id.rv);
        adapter=new DatesheetActivityAdapter(DatesheetsActivity.this,videoList);
        manager=new LinearLayoutManager(DatesheetsActivity.this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
        if(videoList.size()== 0){
            getJson();
        }
    }
    private void getJson() {
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite wave = new Wave();
        progressBar.setIndeterminateDrawable(wave);
        url = DatesheetsApiHandler.BASE_URL;
        Log.e("url",url);
        Call<DatesheetsApiModel> data = DatesheetsApiHandler.getDemoInterface().getMessage(url);
        data.enqueue(new Callback<DatesheetsApiModel>() {
            @Override
            public void onResponse(Call<DatesheetsApiModel> call, Response<DatesheetsApiModel> response) {
                if(response.errorBody() != null){
                    Log.v(TAG, "onresponse: "+ response.errorBody());
                }
                else{
                    DatesheetsApiModel am=response.body();
                    videoList.addAll(am.getItems());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<DatesheetsApiModel> call, Throwable t) {
                Log.e(TAG,"onFailure ",t);
                Toast.makeText(DatesheetsActivity.this, "Kindly go back to previous screen and enter again.", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }


}