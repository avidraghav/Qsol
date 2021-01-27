package Adapters;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;

import models_youtubeapi.Apimodel;
import models_youtubeapi.Token;
import models_youtubeapi.VideoYT;

import com.application.kurukshetrauniversitypapers.VideoActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoYT> videoList;
    private String token;
    private int currentPosition = 999; // any number greater than the number of videos in playlist
    private boolean expansion_state=false;
    public VideoAdapter2(Context context, List<VideoYT> videoList,String token) {
        this.context = context;
        this.videoList = videoList;
        this. token = token;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.video_list_new,parent,false);
        return  new YoutubeHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VideoYT videoYT= videoList.get(position);

        YoutubeHolder yth = (YoutubeHolder) holder;

        yth.description.setText(videoYT.getSnippet().getDescription());
        yth.textViewName.setText(videoYT.getSnippet().getTitle());
        Glide.with(context).load(videoYT.getSnippet().getThumbnails().getMedium().getUrl()).into(yth.imageView);
        yth.relativeLayout.setVisibility(View.GONE);


        if (currentPosition == position) {
            if(expansion_state) {
                Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.reveal_details);
                yth.relativeLayout.setVisibility(View.VISIBLE);
                yth.relativeLayout.startAnimation(slideDown);
                yth.divider1.setVisibility(View.GONE);
                yth.reveal.setBackgroundResource(R.drawable.ic_up_arrow);
            }
            else {
                Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.hide_details);
                yth.relativeLayout.setVisibility(View.GONE);
                yth.relativeLayout.startAnimation(slideUp);
                yth.divider1.setVisibility(View.VISIBLE);
                yth.reveal.setBackgroundResource(R.drawable.ic_angle_arrow_down);
            }

        }
        yth.reveal.setOnClickListener(view -> {
            expansion_state=!expansion_state;
            currentPosition = position;
            notifyDataSetChanged();
        });


        String getId= videoYT.getSnippet().getResourceId().getVideoId();
        yth.textViewName.setOnClickListener(v -> {
            startVideo(getId);
        });
        yth.relativeLayout.setOnClickListener(view -> {
            startVideo(getId);
        });
    }
    @NonNull
    @Override
    public int getItemCount() {
        return videoList.size();
    }
    public void startVideo(String getId){
        Intent i = new Intent(context, VideoActivity.class);
        i.putExtra("videoId", getId);
        context.startActivity(i);
    }
    class YoutubeHolder extends RecyclerView.ViewHolder{


        TextView textViewName, description;
        ImageView imageView;
        RelativeLayout relativeLayout;
        View divider1;
        Button reveal;

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            description=itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
            reveal=itemView.findViewById(R.id.reveal);
            divider1=itemView.findViewById(R.id.divider1);
            relativeLayout = itemView.findViewById(R.id.linearLayout);

        }

    }

}
