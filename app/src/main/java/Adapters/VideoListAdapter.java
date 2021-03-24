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
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;

import models_youtubeapi.VideoYT;

import com.application.kurukshetrauniversitypapers.VideoPlayerActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoYT> videoList;
    private String token;
    private int currentPosition = 999; // any number greater than the number of videos in playlist
    private boolean expansion_state=false;


    public VideoListAdapter(Context context, List<VideoYT> videoList, String token) {
        this.context = context;
        this.videoList = videoList;
        this. token = token;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.video_list_row,parent,false);
        return  new YoutubeHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VideoYT videoYT= videoList.get(position);
        YoutubeHolder yth = (YoutubeHolder) holder;
        int video_number= videoYT.getSnippet().getPosition() + 1;
        yth.description.setText(videoYT.getSnippet().getDescription());
        yth.textViewName.setText(videoYT.getSnippet().getTitle());
        yth.position.setText("Video "+video_number);
        Glide.with(context).load(videoYT.getSnippet().getThumbnails().getMedium().getUrl()).into(yth.videoThumbnail);
        yth.relativeLayout.setVisibility(View.GONE);

        if (currentPosition == position) {
            if(expansion_state) {
                Log.e("info","inside if");
                Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.reveal_details);
                yth.relativeLayout.setVisibility(View.VISIBLE);
                yth.relativeLayout.startAnimation(slideDown);
                yth.reveal.setBackgroundResource(R.drawable.ic_up_arrow);
            }
            else {
                Log.e("info","inside else");
                Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.hide_details);
                yth.relativeLayout.setVisibility(View.GONE);
                yth.relativeLayout.startAnimation(slideUp);
                yth.reveal.setBackgroundResource(R.drawable.ic_angle_arrow_down);
            }
        }
        yth.reveal.setOnClickListener(view -> {
            Log.e("info","inside listener");
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
        Intent i = new Intent(context, VideoPlayerActivity.class);
        i.putExtra("videoId", getId);
        context.startActivity(i);
    }
    class YoutubeHolder extends RecyclerView.ViewHolder{


        TextView textViewName, description,position;
        ImageView videoThumbnail;
        RelativeLayout relativeLayout;
        Button reveal;

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            position = itemView.findViewById(R.id.position);
            description=itemView.findViewById(R.id.description);
            videoThumbnail = itemView.findViewById(R.id.video_thumbnail);
            reveal=itemView.findViewById(R.id.reveal);
            relativeLayout = itemView.findViewById(R.id.description_relativelayout);

        }

    }

}
