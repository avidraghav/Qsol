package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.Pdflistadapter;
import Adapters.VideoListAdapter;
import utils.Videoinfo;
import utils.uploadPDF;

public class PlaylistsAvailableActivity extends AppCompatActivity {
    ArrayList<String> subjects;
    ListView listView;
     List<Videoinfo> playlist_info;
    TextView subjectname;
    TextView teacher_name;
    ImageView image;
    String directory;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists_available);
        listView=findViewById(R.id.playlists_available_listview);
        playlist_info = new ArrayList<>();

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
                VideoListAdapter adapter= new VideoListAdapter(PlaylistsAvailableActivity.this,playlist_info);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Videoinfo playlistinfodata=playlist_info.get(position);
                Log.e("info",playlistinfodata.getPlaylistid());
                Intent intent=new Intent(PlaylistsAvailableActivity.this, VideosListActivity.class);
                intent.putExtra("PlaylistId",playlistinfodata.getPlaylistid());
                startActivity(intent);
            }
        });
    }
}