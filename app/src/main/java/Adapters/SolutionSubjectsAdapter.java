package Adapters;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.application.kurukshetrauniversitypapers.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import utils.GlobalClass;
import utils.Listdata;
import utils.Subjectcode;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class SolutionSubjectsAdapter extends ArrayAdapter<Listdata> {

    List<Listdata> subjectlist;
    Context context;
    int resource;
    FirebaseAuth mAuth;

    public SolutionSubjectsAdapter(Context context, int resource, List<Listdata> subjectlist)
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

        final TextView subjectname = view.findViewById(R.id.subjectname);
        final TextView papercount = view.findViewById(R.id.papercount);

        Listdata listdata = subjectlist.get(position);
        subjectname.setText(listdata.getSubjectname());
        papercount.setText(listdata.getPapercount());

        mAuth=FirebaseAuth.getInstance();

        return view;
    }




}

