package Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;
import models_youtubeapi.VideoYT;

import com.application.kurukshetrauniversitypapers.VideoActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.ContentValues.TAG;

public class VideoAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoYT> videoList;

    public VideoAdapter2(Context context, List<VideoYT> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    class YoutubeHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView t1,t2;
        RelativeLayout relativeLayout;

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.iv_thumbnail);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            relativeLayout=itemView.findViewById(R.id.relativeLayout);

        }

        public void setData(VideoYT data) {
            String getT1=data.getSnippet().getTitle();
             String getT2= data.getSnippet().getDescription();
             String getThumb= data.getSnippet().getThumbnails().getMedium().getUrl();

             t1.setText(getT1);
             t2.setText(getT2);

            Glide
                    .with(context)
                    .load(getThumb)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(thumbnail);

        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.videolist_row,parent,false);
        return  new YoutubeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            VideoYT videoYT= videoList.get(position);
           YoutubeHolder yth = (YoutubeHolder) holder;
              yth.setData(videoYT);

              ((YoutubeHolder) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent intent=new Intent(context,VideoActivity.class);
                      intent.putExtra("videoId","dmIfFIHnKsk");
                      context.startActivity(intent);
                  }
              });


    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
