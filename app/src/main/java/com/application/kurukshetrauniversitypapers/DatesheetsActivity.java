package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import Adapters.SolutionSubjectsAdapter;
import utils.Listdata;
import utils.SingleDownloadClass;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DatesheetsActivity extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    StorageReference storageReference,myref;
    FirebaseStorage firebaseStorage;
    DatabaseReference rootref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datesheets);
        listView =findViewById(R.id.datesheet_listview);
        subjectlist = new ArrayList<>();
        subjectlist.add(new Listdata("Engineering V Semester Examinations Jan 2021", "1"));
        subjectlist.add(new Listdata("Engineering VII Semester Examinations Jan 2021", "1"));

        SolutionSubjectsAdapter adapter = new SolutionSubjectsAdapter(getBaseContext(), R.layout.solution_subjects_row, subjectlist);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position==0){
                toast();
                download("IN/KU/CS/05/Datesheet/", "Engineering V Semester Examinations Jan 2021");
            }
            if(position==1){
                toast();
                download("IN/KU/CS/07/Datesheet/", "Engineering VII Semester Examinations Jan 2021");
            }

        });

    }
    public void download(final String directory, final String filename) {


        storageReference = firebaseStorage.getInstance().getReference(directory);
        rootref= FirebaseDatabase.getInstance().getReference(directory);

        rootref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                myref = storageReference.child(filename+".pdf");
                Log.e(filename,filename+".pdf");
                myref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String url = uri.toString();
                        Log.e("url",url);
                        downloadfiles(DatesheetsActivity.this,filename, ".pdf", DIRECTORY_DOWNLOADS, url);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void downloadfiles(Context context, String file, String fileExtension, String destinationDirectory, String url)
    {
        DownloadManager downloadmanager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request =new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, file+fileExtension);
        downloadmanager.enqueue(request);
    }
    public void toast(){
        Toast.makeText(DatesheetsActivity.this, "1 file will be downloaded see notification panel", Toast.LENGTH_LONG).show();}
}
