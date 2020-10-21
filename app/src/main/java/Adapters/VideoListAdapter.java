package Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import utils.Videoinfo;
import com.application.kurukshetrauniversitypapers.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class VideoListAdapter extends ArrayAdapter<Videoinfo> {
    List<Videoinfo> subjectlist;
    private Activity context;
//    StorageReference storageReference,myref;
//    FirebaseStorage firebaseStorage;
//    DatabaseReference rootref;
    private String videoid;
    FirebaseAuth mAuth;

    public VideoListAdapter(Activity context, List<Videoinfo> subjectlist)
    {
        super(context, R.layout.videos_available_row, subjectlist);
        this.context = context;
        this.subjectlist = subjectlist;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.videos_available_row, null, false);


        final TextView topic =  view.findViewById(R.id.topicname);
        final TextView teacher = view.findViewById(R.id.teacher);
        //final TextView duration = view.findViewById(R.id.duration);
        final ImageView imageView=view.findViewById(R.id.teacher_image);

        Videoinfo videoinfo = subjectlist.get(position);
        topic.setText(videoinfo.getSubjectname());
        teacher.setText(videoinfo.getChannelname());
        Glide.with(context).load(videoinfo.getImageurl()).into(imageView);

        mAuth=FirebaseAuth.getInstance();



        

        return view;
    }
}
