package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

        Videoinfo videoinfo = subjectlist.get(position);
        topic.setText(videoinfo.getTopic());
        teacher.setText(videoinfo.getTeacher());
        duration.setText(videoinfo.getDuration());

        mAuth=FirebaseAuth.getInstance();

//        topic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                switch (topic.getText().toString()) {
//                    case "Advance computer network and applications":
//                        videoid="PLUhzUGU9G_1tZiY0Ec7qMk2yt1CbCZjh6&index=1";
//                        break;
//                    case "test":
//                        System.out.println("Got it");
//                        break;
//                }
//                Intent intent=new Intent(getContext(), VideoActivity.class);
//                intent.putExtra("videoId",videoid);
//                context.startActivity(intent);
//
//            }
//        });


        

        return view;
    }
}
