package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Adapters.VideoAdapter2;
import models_youtubeapi.Apimodel;
import models_youtubeapi.VideoYT;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class AutomataVideos extends AppCompatActivity {
    private VideoAdapter2 adapter;
    private LinearLayoutManager manager;
    private List<VideoYT> videoList=new ArrayList<>();
    public AutomataVideos() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automata_videos);

        RecyclerView rv= findViewById(R.id.recyclerView);
        adapter=new VideoAdapter2(AutomataVideos.this,videoList);
        manager=new LinearLayoutManager(AutomataVideos.this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);


        if(videoList.size()== 0){
            getJson();
        }



//        video_info.add(new Videoinfo("What is Automata and Why we study it | Lecture 1", "Dr. Shilpi Harnal (Jmit Radaur)","24 minutes"));
//        video_info.add(new Videoinfo("Formal Model of FA, Application and Limitations | Lecture 2", "Dr. Shilpi Harnal (Jmit Radaur)","43 minutes"));
//        video_info.add(new Videoinfo("DFA Definition and Example | Lecture 3", "Dr. Shilpi Harnal (Jmit Radaur)","34 minutes"));
//        video_info.add(new Videoinfo("DFA for strings of ‘0’ and ‘1’ starting with 011  |  Lecture 4", "Dr. Shilpi Harnal (Jmit Radaur)","19 minutes"));
//        video_info.add(new Videoinfo("DFA for strings starting with 110 and DFA for strings ending with 110. | Lecture 5", "Dr. Shilpi Harnal (Jmit Radaur)","25 minutes"));
//        video_info.add(new Videoinfo("DFA Practice questions | for strings ending with 101 or 100 | having 110 as substring | Lecture 6", "Dr. Shilpi Harnal (Jmit Radaur)","26 minutes"));
//        video_info.add(new Videoinfo("NFA Definition and examples | Non Deterministic Finite Automata | NFA examples | Lecture 7", "Dr. Shilpi Harnal (Jmit Radaur)","45 minutes"));
//        video_info.add(new Videoinfo("Practice Questions of DFA | DFA for strings having even number of a’s and b’s | Lecture 8", "Dr. Shilpi Harnal (Jmit Radaur)","19 minutes"));
//        video_info.add(new Videoinfo("NFA examples | Non Deterministic Finite Automata | Strings ending with double character | Lecture 9", "Dr. Shilpi Harnal (Jmit Radaur)","27 minutes"));
//        video_info.add(new Videoinfo("NFA to DFA conversion | Why to convert NFA to DFA | Lecture 10", "Dr. Shilpi Harnal (Jmit Radaur)","36 minutes"));
//        video_info.add(new Videoinfo("DFA for decimal strings divisible by 3 or 4 | DFA for strings divisibility check | Lecture 11", "Dr. Shilpi Harnal (Jmit Radaur)","34 minutes"));
//        video_info.add(new Videoinfo("DFA for binary strings divisible by 3 or 4 | DFA for binary strings divisibility check | Lecture 12", "Dr. Shilpi Harnal (Jmit Radaur)","25 minutes"));
//        video_info.add(new Videoinfo("DFA for base 3 number system strings divisible by 5 | strings divisibility check | Lecture 13", "Dr. Shilpi Harnal (Jmit Radaur)","19 minutes"));
//        video_info.add(new Videoinfo("Minimization of DFAs | Grouping method of DFA| Partition method for minimization of DFA | Lecture 14", "Dr. Shilpi Harnal (Jmit Radaur)","41 minutes"));
//        video_info.add(new Videoinfo("Regular Expressions | Examples of Regular Expression | Kleene Closure, Positive Closure | Lecture 15", "Dr. Shilpi Harnal (Jmit Radaur)","42 minutes"));
//        video_info.add(new Videoinfo("Strings not having a particular pattern | Strings start or end with double characters | Lecture 16.", "Dr. Shilpi Harnal (Jmit Radaur)","34 minutes"));
//        video_info.add(new Videoinfo("Minimization of DFAs | Grouping method of DFA| Partition method for minimization of DFA | Lecture 17", "Dr. Shilpi Harnal (Jmit Radaur)","51 minutes"));
//        video_info.add(new Videoinfo("NFA to DFA conversion Example | Lecture 18", "Dr. Shilpi Harnal (Jmit Radaur)","18 minutes"));
//        video_info.add(new Videoinfo("NFA with Epsilon Closure | Epsilon Closure of a State | Lecture 19", "Dr. Shilpi Harnal (Jmit Radaur)","14 minutes"));
//        video_info.add(new Videoinfo("Conversion of NFA with Epsilon closure to equivalent NFA without epsilon moves or DFA | Lecture 20", "Dr. Shilpi Harnal (Jmit Radaur)","19 minutes"));
//        VideoListAdapter adapter = new VideoListAdapter(getBaseContext(), R.layout.videolist_row, video_info);
//        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                if(position==0) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","Vh_O_3YGrJs");
//                    startActivity(intent);
//                }
//                if(position==1) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","Bp8f88QOm9c");
//                    startActivity(intent);
//                }
//                if(position==2) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","3rdTxXlKM04");
//                    startActivity(intent);
//                }
//                if(position==3) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","IGoGhbj3h98");
//                    startActivity(intent);
//                }
//                if(position==4) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","DfxrCiWRkxE");
//                    startActivity(intent);
//                }
//                if(position==5) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","P37fFEFX8ts");
//                    startActivity(intent);
//                }
//                if(position==6) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","sPaaBVcC-0k");
//                    startActivity(intent);
//                }
//                if(position==7) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","NSX5joO0nig");
//                    startActivity(intent);
//                }
//                if(position==8) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","SWIx3aliMJQ");
//                    startActivity(intent);
//                }
//                if(position==9) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","AmTq6tkdYV0");
//                    startActivity(intent);
//                }
//                if(position==10) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","_rqVSRRivDo");
//                    startActivity(intent);
//                }
//                if(position==11) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","_xOva9K8E3o");
//                    startActivity(intent);
//                }
//                if(position==12) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","L5Dd0GRNz6s");
//                    startActivity(intent);
//                }
//                if(position==13) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","_aP_s2wH2x8");
//                    startActivity(intent);
//                }
//                if(position==14) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","NTFW5K391Ak");
//                    startActivity(intent);
//                }
//                if(position==15) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","f094WMt57_Y");
//                    startActivity(intent);
//                }
//                if(position==16) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","djldm3JiLZY");
//                    startActivity(intent);
//                }
//                if(position==17) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","2h4p0yB0V8w");
//                    startActivity(intent);
//                }
//                if(position==18) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","E9VltuvrTcM");
//                    startActivity(intent);
//                }
//                if(position==19) {
//                    Intent intent=new Intent(AutomataVideos.this, VideoActivity.class);
//                    intent.putExtra("videoId","8zFmp5HDm3M");
//                    startActivity(intent);
//                }
//
//            }
//        });

    }
    private void getJson() {
        String url= YoutubeAPI.BASE_URL + YoutubeAPI.request;
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