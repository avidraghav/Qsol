package com.application.kurukshetrauniversitypapers;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapters.VideoListAdapter;
import utils.Videoinfo;
import utils.uploadPDF;

public class VideoFragment extends Fragment {
    Button cse,first,second,third,fourth,fifth,sixth,session;
    Button ku,dp,gj;
    String selected_branch = "null",selected_semester = "null",semester_number="null",branch_for_intent="null";
    String board="null";
    RelativeLayout ku_courses,ku_semesters,dp_courses,dp_semesters;
//    ArrayList<String> subjects;
//    List<uploadPDF> uploadPDFS;
    Button search;

    // List<Videoinfo> video_info;
//    TextView subjectname;
//    TextView teacher_name;
//    ImageView image;


  public VideoFragment(){
      //empty constructor
  }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v= inflater.inflate(R.layout.fragment_videos, container, false);
        cse=v.findViewById(R.id.cse);
        first=v.findViewById(R.id.first);
        third=v.findViewById(R.id.third);
        sixth=v.findViewById(R.id.sixth);
        search=v.findViewById(R.id.search);
        ku_courses=v.findViewById(R.id.ku_courses);
        ku_semesters=v.findViewById(R.id.ku_semesters);
        ku=v.findViewById(R.id.ku);
        session=v.findViewById(R.id.session_20_21);

        setDefaultList();
        cse.setOnClickListener(v1 -> {
            selected_branch="Cse";
            branch_for_intent="Computer science"; // for branches other than Cse when first or second sem is selected selected branch is
            // overriden to Cse
            cse.setBackgroundResource(R.drawable.button_pressed);
            third.setEnabled(true);
            sixth.setEnabled(true);
            Log.e("branch",selected_branch);
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="first";
                semester_number="1";
                first.setBackgroundResource(R.drawable.button_pressed);
                third.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="third";
                semester_number="3";
                first.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_pressed);
                sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="sixth";
                semester_number="6";
                first.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_pressed);
            }
        });

        ku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board="KU_";
                selected_semester="null";
                selected_branch="null";
                ku_courses.setVisibility(View.VISIBLE);
                ku_semesters.setVisibility(View.VISIBLE);
                first.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                ku.setBackgroundResource(R.drawable.button_pressed);

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),PlaylistsAvailableActivity.class);
                intent.putExtra("video_loc","IN/KU/CS/03/Videos/Business Intelligence and entrepreneurship");
                startActivity(intent);
            }
        });
//        listView=v.findViewById(R.id.list);
//        subjectname=v.findViewById(R.id.topicname);
//        teacher_name=v.findViewById(R.id.teacher);
//        image=v.findViewById(R.id.teacher_image);
//        video_info = new ArrayList<>();
//        video_info.add(new Videoinfo("Formal Language and Automata theory", "Dr. Shilpi Harnal","Jmit Radaur"));
//        video_info.add(new Videoinfo("Test", "Dr. abc","test"));
//
//
//        VideoListAdapter adapter = new VideoListAdapter(getActivity(), video_info);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                 if(position==0) {
//                     Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                     intent.putExtra("Playlistid","PLUhzUGU9G_1tZiY0Ec7qMk2yt1CbCZjh6");
//                     startActivity(intent);
//                 }
//                if(position==1) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O");
//                    startActivity(intent);
//                }
//                if(position==2) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLxCzCOWd7aiHMonh3G6QNKq53C6oNXGrX");
//                    startActivity(intent);
//                }
//                if(position==3) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLX9Zi6XTqOKQ7TdRz0QynGIKuMV9Q2H8E");
//                    startActivity(intent);
//                }
//                if(position==4) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLxCzCOWd7aiFAN6I8CuViBuCdJgiOkT2Y");
//                    startActivity(intent);
//                }
//                if(position==5) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLBlnK6fEyqRjMH3mWf6kwqiTbT798eAOm");
//                    startActivity(intent);
//                }
//                if(position==6) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfJuoOCgUCVRLvoiQNUhdO-P");
//                    startActivity(intent);
//                }
//                if(position==7) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfIIEY1wEAsVWdW-R_A1-KBJ");
//                    startActivity(intent);
//                }
//                if(position==8) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfJz9FAzbgocIjlkw4NXAar-");
//                    startActivity(intent);
//                }
//                if(position==9) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLLYz8uHU480j37APNXBdPz7YzAi4XlQUF");
//                    startActivity(intent);
//                }
//                if(position==10) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLanB6xNfkPv4u7_-JDjM-Tl6Fhde11l7u");
//                    startActivity(intent);
//                }
//                if(position==11) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLgjc0A1c-mohs7cCIJLk9rB8qTkLb8n-j");
//                    startActivity(intent);
//                }
//                if(position==12) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfKqtoZ2uDwgMya5m_x6cbOG");
//                    startActivity(intent);
//                }
//                if(position==13) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLanB6xNfkPv5gp8FUx9SDBeg7ur7lUk1d");
//                    startActivity(intent);
//                }
//                if(position==14) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLmXKhU9FNesSFvj6gASuWmQd23Ul5omtD");
//                    startActivity(intent);
//                }
//                if(position==15) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLxCzCOWd7aiGz9donHRrE9I3Mwn6XdP8p");
//                    startActivity(intent);
//                }
//
//                if(position==16) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PL7ersPsTyYt2Q-SqZxTA1D-melSfqBRMW");
//                    startActivity(intent);
//                }
//                if(position==17) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfI34zVjDYDCZ6KLAifHmN1v");
//                    startActivity(intent);
//                }
//                if(position==18) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfIJRl8mo2Rv1MpdvmVD0YyI");
//                    startActivity(intent);
//                }
//                if(position==19) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfLoKyzF_dwxAQf8lIi6VC54");
//                    startActivity(intent);
//                }
//                if(position==20) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLIhUrsYr8yHwTgo_zu_ELqOC1ypcp5Gr9");
//                    startActivity(intent);
//                }
//                if(position==21) {
//                    Intent intent = new Intent(getActivity(), VideosListActivity.class);
//                    intent.putExtra("Playlistid","PLU6SqdYcYsfLRq3tu-g_hvkHDcorrtcBK");
//                    startActivity(intent);
//                }
//
//            }
//        });
        return v;


    }
    public void setDefaultList()
    {
        ku_courses.setVisibility(View.VISIBLE);
        ku_semesters.setVisibility(View.VISIBLE);
        session.setBackgroundResource(R.drawable.button_pressed);
    }



}