package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Adapters.DatesheetAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.DatesheetApiHandler;
import utils.DatesheetListApiModel;
import utils.DatesheetsInfo;


import static android.content.ContentValues.TAG;

public class DatesheetsActivity extends AppCompatActivity {
    private DatesheetAdapter adapter;
    private List<DatesheetsInfo> datesheetlist=new ArrayList<>();
    private LinearLayoutManager manager;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datesheets);
        RecyclerView rv = findViewById(R.id.datesheet_recyclerView);
        adapter = new DatesheetAdapter(DatesheetsActivity.this, datesheetlist);
        manager = new LinearLayoutManager(DatesheetsActivity.this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
        if (datesheetlist.size() == 0) {
            getJson();
        }
    }
        private void getJson() {
            url = DatesheetApiHandler.BASE_URL;
            Log.e("url",url);
            Call<DatesheetListApiModel> data = DatesheetApiHandler.getDatesheetApiInterface().getMessage(url);
            data.enqueue(new Callback<DatesheetListApiModel>() {
                @Override
                public void onResponse(Call<DatesheetListApiModel> call, Response<DatesheetListApiModel> response) {
                    if(response.errorBody() != null){
                        Log.v(TAG, "onresponse: "+ response.errorBody());
                    }
                    else{
                        DatesheetListApiModel am =response.body();
                        datesheetlist.addAll(am.getItems());
                        adapter.notifyDataSetChanged();
                    }
                }
                @Override
                public void onFailure(Call<DatesheetListApiModel> call, Throwable t) {
                    Log.e(TAG,"onFailure ",t);
                }
            });
        }


//        SolutionSubjectsAdapter adapter = new SolutionSubjectsAdapter(getBaseContext(), R.layout.solution_subjects_row, subjectlist);
//        listView.setAdapter(adapter);
//
//
//
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            if(position==0){
//                toast();
//                download("IN/KU/CS/05/Datesheet/", "Engineering V Semester Examinations Jan 2021");
//            }
//            if(position==1){
//                toast();
//                download("IN/KU/CS/07/Datesheet/", "Engineering VII Semester Examinations Jan 2021");
//            }
//
//        });
//
//    }
//    public void download(final String directory, final String filename) {
//
//
//        storageReference = firebaseStorage.getInstance().getReference(directory);
//        rootref= FirebaseDatabase.getInstance().getReference(directory);
//
//        rootref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                myref = storageReference.child(filename+".pdf");
//                Log.e(filename,filename+".pdf");
//                myref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
//                        String url = uri.toString();
//                        Log.e("url",url);
//                        downloadfiles(DatesheetsActivity.this,filename, ".pdf", DIRECTORY_DOWNLOADS, url);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                    }
//                });
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//    public void downloadfiles(Context context, String file, String fileExtension, String destinationDirectory, String url)
//    {
//        DownloadManager downloadmanager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
//        Uri uri=Uri.parse(url);
//        DownloadManager.Request request =new DownloadManager.Request(uri);
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//        request.setDestinationInExternalFilesDir(context, destinationDirectory, file+fileExtension);
//        downloadmanager.enqueue(request);
//    }
//    public void toast(){
//        Toast.makeText(DatesheetsActivity.this, "1 file will be downloaded see notification panel", Toast.LENGTH_LONG).show();}

}

