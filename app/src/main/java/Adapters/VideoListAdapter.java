package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.application.kurukshetrauniversitypapers.VideoActivity;
import com.application.kurukshetrauniversitypapers.Videoinfo;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class VideoListAdapter extends ArrayAdapter<Videoinfo> {
    List<Videoinfo> subjectlist;
    Context context;
    int resource;
    private String videoid;
    FirebaseAuth mAuth;

    public VideoListAdapter(Context context, int resource, List<Videoinfo> subjectlist)
    {
        super(context, resource, subjectlist);
        this.context = context;
        this.resource = resource;
        this.subjectlist = subjectlist;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        final TextView topic = view.findViewById(R.id.topicname);
        final TextView teacher = view.findViewById(R.id.teacher);
        final TextView duration = view.findViewById(R.id.duration);
        final ImageView imageView=view.findViewById(R.id.teacher_image);

        Videoinfo videoinfo = subjectlist.get(position);
        topic.setText(videoinfo.getTopic());
        teacher.setText(videoinfo.getTeacher());
        duration.setText(videoinfo.getDuration());
        imageView.setImageResource(videoinfo.getImage());

        mAuth=FirebaseAuth.getInstance();



        

        return view;
    }
}
