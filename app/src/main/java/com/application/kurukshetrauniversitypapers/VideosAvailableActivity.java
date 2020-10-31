package com.application.kurukshetrauniversitypapers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.VideoListAdapter;
import utils.Videoinfo;

public class VideosAvailableActivity extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<Videoinfo> videoinfos;
    TextView subject, channel;
    ImageView imageView;
    String key= "Formal Language and Automata Theory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_available);
        listView=findViewById(R.id.videos_available_list);
        subject=findViewById(R.id.topicname);
        channel=findViewById(R.id.teacher);
        imageView=findViewById(R.id.teacher_image);
        videoinfos=new ArrayList<>();

//        Intent intent1=getIntent();
//        key=intent1.getStringExtra("subject");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Videoinfo videoinfo=videoinfos.get(position);
                Intent intent=new Intent(VideosAvailableActivity.this,VideosListActivity.class);
                intent.putExtra("Playlistid",videoinfo.getPlaylistid());
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
      //  Intent intent=getIntent();
        //key=intent.getStringExtra("subject");
        databaseReference= FirebaseDatabase.getInstance().getReference("IN/KU/Videos/"+key);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoinfos.clear();
                for(DataSnapshot videoSnapshot: dataSnapshot.getChildren()){
                    Videoinfo videoinfo=videoSnapshot.getValue(Videoinfo.class);
                    videoinfos.add(videoinfo);
                }

                VideoListAdapter adapter= new VideoListAdapter(VideosAvailableActivity.this,videoinfos);
                listView.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}