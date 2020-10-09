package com.application.kurukshetrauniversitypapers;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapters.VideoListAdapter;

public class VideoFragment extends Fragment {
    ListView listView;
    List<Videoinfo> video_info;
    TextView subjectname;
    TextView teacher_name;
    ImageView image;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v= inflater.inflate(R.layout.fragment_videos, container, false);
        listView=v.findViewById(R.id.list);
        subjectname=v.findViewById(R.id.subjectname);
        teacher_name=v.findViewById(R.id.papercount);
        image=v.findViewById(R.id.teacher_image);
        video_info = new ArrayList<>();
        video_info.add(new Videoinfo("Formal Language and Automata theory", "Dr. Shilpi Harnal","Jmit Radaur",R.drawable.unnamed));
        video_info.add(new Videoinfo("Design & analysis of algorithm", "Abdul Bari","",R.drawable.ab));
        video_info.add(new Videoinfo("Computer organization & architecture", "Gate Smashers","",R.drawable.gs));
        video_info.add(new Videoinfo("Essentials of information technology", "Java by Saurabh Shukla Sir","",R.drawable.jv));
        video_info.add(new Videoinfo("Database management system", "Gate Smashers","",R.drawable.gs));
        video_info.add(new Videoinfo("Digital electronics", "Neso Academy","",R.drawable.ns));
        video_info.add(new Videoinfo("Sequence & series", "Dr.Gajendra Purohit","",R.drawable.gp));
        video_info.add(new Videoinfo("Multivariable calculus", "Dr.Gajendra Purohit","",R.drawable.gp));
        video_info.add(new Videoinfo("Vector calculus", "Dr.Gajendra Purohit","",R.drawable.gp));
        video_info.add(new Videoinfo("Object-oriented programming using C++", "C++ by Saurabh Shukla sir","",R.drawable.jv));
        video_info.add(new Videoinfo("Business Intelligence and entrepreneurship", "PPC learning","",R.drawable.ppc));
        video_info.add(new Videoinfo("Design & analysis of algorithm", "The Insight Coders","",R.drawable.ic));
        video_info.add(new Videoinfo("Discrete Mathematics", "Group Theory","",R.drawable.gp));
        video_info.add(new Videoinfo("Organisational behaviour", "PPC learning","",R.drawable.ppc));
        video_info.add(new Videoinfo("Operating systems", "Knowledge Gate","",R.drawable.kg));
        video_info.add(new Videoinfo("Operating systems", "Gate Smashers","",R.drawable.gs));

        VideoListAdapter adapter = new VideoListAdapter(getActivity(), R.layout.videos_available_row, video_info);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 if(position==0) {
                     Intent intent = new Intent(getActivity(), VideosListActivity.class);
                     intent.putExtra("Playlistid","PLUhzUGU9G_1tZiY0Ec7qMk2yt1CbCZjh6");
                     startActivity(intent);
                 }
                if(position==1) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLxCzCOWd7aiHMonh3G6QNKq53C6oNXGrX");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLX9Zi6XTqOKQ7TdRz0QynGIKuMV9Q2H8E");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLxCzCOWd7aiFAN6I8CuViBuCdJgiOkT2Y");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLBlnK6fEyqRjMH3mWf6kwqiTbT798eAOm");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLU6SqdYcYsfJuoOCgUCVRLvoiQNUhdO-P");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLU6SqdYcYsfIIEY1wEAsVWdW-R_A1-KBJ");
                    startActivity(intent);
                }
                if(position==8) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLU6SqdYcYsfJz9FAzbgocIjlkw4NXAar-");
                    startActivity(intent);
                }
                if(position==9) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLLYz8uHU480j37APNXBdPz7YzAi4XlQUF");
                    startActivity(intent);
                }
                if(position==10) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLanB6xNfkPv4u7_-JDjM-Tl6Fhde11l7u");
                    startActivity(intent);
                }
                if(position==11) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLgjc0A1c-mohs7cCIJLk9rB8qTkLb8n-j");
                    startActivity(intent);
                }
                if(position==12) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLU6SqdYcYsfKqtoZ2uDwgMya5m_x6cbOG");
                    startActivity(intent);
                }
                if(position==13) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLanB6xNfkPv5gp8FUx9SDBeg7ur7lUk1d");
                    startActivity(intent);
                }
                if(position==14) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLmXKhU9FNesSFvj6gASuWmQd23Ul5omtD");
                    startActivity(intent);
                }
                if(position==15) {
                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
                    intent.putExtra("Playlistid","PLxCzCOWd7aiGz9donHRrE9I3Mwn6XdP8p");
                    startActivity(intent);
                }

            }
        });



        return v;


    }



}