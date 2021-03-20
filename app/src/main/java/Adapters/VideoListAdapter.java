package Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import utils.Videoinfo;
import com.application.kurukshetrauniversitypapers.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class VideoListAdapter extends ArrayAdapter<Videoinfo> {
    List<Videoinfo> subjectlist;
    private Activity context;
//    StorageReference storageReference,myref;
//    FirebaseStorage firebaseStorage;
//    DatabaseReference rootref;
    private String playlistid;

    public VideoListAdapter(Activity context, List<Videoinfo> subjectlist)
    {
        super(context, R.layout.subject_playlists_available_row, subjectlist);
        this.context = context;
        this.subjectlist = subjectlist;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.subject_playlists_available_row, null, false);


        final TextView topic =  view.findViewById(R.id.topicname);
        final TextView teacher = view.findViewById(R.id.teacher);
        //final TextView duration = view.findViewById(R.id.duration);
        final ImageView imageView=view.findViewById(R.id.teacher_image);

        Videoinfo videoinfo = subjectlist.get(position);
        topic.setText(videoinfo.getSubjectname());
        teacher.setText(videoinfo.getChannelname());
        Glide.with(context).load(videoinfo.getImageurl()).into(imageView);

        return view;
    }
}
