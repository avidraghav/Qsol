package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;

import java.util.List;

import utils.DatesheetsInfo;

public class DatesheetActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DatesheetsInfo> videoList;

    public DatesheetActivityAdapter(Context context, List<DatesheetsInfo> videoList) {
        this.context = context;
        this.videoList = videoList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rowx,parent,false);
        return  new YoutubeHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Log.e("info","info");
        DatesheetsInfo videoYT= videoList.get(position);
        Log.e("position",position+"");
        Log.e(videoYT.getName(),videoYT.getId());
        YoutubeHolder yth = (YoutubeHolder) holder;
        //yth.t2.setText(videoYT.getId());
        yth.t1.setText(videoYT.getName());

//        if (currentPosition == position) {
//            if(expansion_state) {
//                Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.reveal_details);
//                yth.relativeLayout.setVisibility(View.VISIBLE);
//                yth.relativeLayout.startAnimation(slideDown);
//                yth.divider1.setVisibility(View.GONE);
//                yth.reveal.setBackgroundResource(R.drawable.ic_up_arrow);
//            }
//            else {
//                Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.hide_details);
//                yth.relativeLayout.setVisibility(View.GONE);
//                yth.relativeLayout.startAnimation(slideUp);
//                yth.divider1.setVisibility(View.VISIBLE);
//                yth.reveal.setBackgroundResource(R.drawable.ic_angle_arrow_down);
//            }
//
//        }
//        yth.reveal.setOnClickListener(view -> {
//            expansion_state=!expansion_state;
//            currentPosition = position;
//            notifyDataSetChanged();
//        });


//        String getId= videoYT.getSnippet().getResourceId().getVideoId();
//        yth.textViewName.setOnClickListener(v -> {
//            startVideo(getId);
//        });
//        yth.relativeLayout.setOnClickListener(view -> {
//            startVideo(getId);
//        });
    }
    @NonNull
    @Override
    public int getItemCount() {
        return videoList.size();
    }
    class YoutubeHolder extends RecyclerView.ViewHolder{
        TextView t1, t2;
        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.datesheetname);
            //t2=itemView.findViewById(R.id.t2);

        }

    }
}

