package Adapters;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;

import models_youtubeapi.Apimodel;
import models_youtubeapi.VideoYT;

import com.application.kurukshetrauniversitypapers.VideoActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoYT> videoList;
    private String token;
    private int currentPosition = 999;   // any number greater than the number of videos in playlist

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
        yth.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        // currentPosition = position;
        Log.e("cur",currentPosition+"");
        Log.e("pos",position+"");
        if (currentPosition == position) {
            Log.e("info",currentPosition+"");
            Log.e("info",position+"");
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.reveal_details);

            //toggling visibility
            yth.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            yth.linearLayout.startAnimation(slideDown);
        }
        yth.reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition = position;
                //reloding the list
                notifyDataSetChanged();

            }
        });



        String getId= videoYT.getSnippet().getResourceId().getVideoId();

        yth.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VideoActivity.class);
                i.putExtra("videoId", getId);
                context.startActivity(i);
            }
        });



    }
    @NonNull
    @Override
    public int getItemCount() {
        return videoList.size();
    }
    class YoutubeHolder extends RecyclerView.ViewHolder{

//        ImageView thumbnail;
////        TextView t1,t2;
////        TextView hidden_view;
////        RelativeLayout relativeLayout;

        TextView textViewName, textViewRealName, textViewTeam, textViewFirstAppearance,
                textViewCreatedBy, textViewPublisher, textViewBio,reveal,description;
        ImageView imageView;
        LinearLayout linearLayout;

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            description=itemView.findViewById(R.id.description);
//            textViewRealName = itemView.findViewById(R.id.textViewRealName);
//            textViewTeam = itemView.findViewById(R.id.textViewTeam);
//            textViewFirstAppearance = itemView.findViewById(R.id.textViewFirstAppearance);
//            textViewCreatedBy = itemView.findViewById(R.id.textViewCreatedBy);
//            textViewPublisher = itemView.findViewById(R.id.textViewPublisher);
//            textViewBio = itemView.findViewById(R.id.textViewBio);
            imageView = itemView.findViewById(R.id.imageView);
            reveal=itemView.findViewById(R.id.reveal);


            linearLayout = itemView.findViewById(R.id.linearLayout);

        }

        public void setData(VideoYT hero,Apimodel data2,int position)
        {


//
//             t1.setText(getT1);
//             t2.setText(getT2);
//           //  hidden_view.setText(next_page_token);
//
//
//
//            Glide
//                    .with(context)
//                    .load(getThumb)
//                    .centerCrop()
//                    .placeholder(R.mipmap.ic_launcher)
//                    .into(thumbnail);

        }
    }

}
