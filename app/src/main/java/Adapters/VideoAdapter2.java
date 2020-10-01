package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;
import com.application.kurukshetrauniversitypapers.VideoYT;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

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

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.iv_thumbnail);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);

        }

        public void setData(VideoYT data) {
            String getT1=data.getSnippet().getTitle();
             String getT2= data.getSnippet().getDescription();
             String getThumb= data.getSnippet().getThumbnails().getMedium().getUrl();

             t1.setText(getT1);
             t2.setText(getT2);
            Picasso.get().load(getThumb)
                    .placeholder(R.mipmap.ic_launcher)
                    .fit()
                    .centerCrop()
                    .into(thumbnail, new Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d(TAG, "success" );
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d(TAG, "failure",e);
                        }
                    });
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
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
