package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.PlaylistsAvailableAdapter;
import utils.Videoinfo;

public class PlaylistsAvailableActivity extends AppCompatActivity {
    ListView listView;
     List<Videoinfo> playlist_info;
    String directory;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists_available);
        listView=findViewById(R.id.playlists_available_listview);
        playlist_info = new ArrayList<>();

        checkConnection();

        Intent intent1=getIntent();
        directory = intent1.getStringExtra("video_loc");

        databaseReference= FirebaseDatabase.getInstance().getReference(directory);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                playlist_info.clear();
                for(DataSnapshot playlistsnapshot: dataSnapshot.getChildren()){
                    Videoinfo playlistinfodata=playlistsnapshot.getValue(Videoinfo.class);
                    playlist_info.add(playlistinfodata);
                }
                PlaylistsAvailableAdapter adapter= new PlaylistsAvailableAdapter(PlaylistsAvailableActivity.this,playlist_info);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("info", databaseError+"");
            }
        });

        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            Videoinfo playlistinfodata=playlist_info.get(position);
            Log.e("info",playlistinfodata.getPlaylistid());
            Intent intent=new Intent(PlaylistsAvailableActivity.this, VideosListActivity.class);
            intent.putExtra("PlaylistId",playlistinfodata.getPlaylistid());
            startActivity(intent);
        });

    }
    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if (null != activenetwork) {
            if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
            }
        } else {
            View view =findViewById(R.id.playlists_display_layout);
            Snackbar snackbar = Snackbar.make(view, "Kindly Enable Internet Connection To View Results", Snackbar.LENGTH_LONG);
            snackbar.setDuration(5000);
            snackbar.show();
        }
    }

}