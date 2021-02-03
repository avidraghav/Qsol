package Adapters;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.LoginActivity2;
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

import utils.DatesheetsInfo;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DatesheetActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DatesheetsInfo> videoList;
    FirebaseAuth mAuth;
    StorageReference storageReference,myref;
    FirebaseStorage firebaseStorage;
    DatabaseReference rootref;

    public DatesheetActivityAdapter(Context context, List<DatesheetsInfo> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.datesheets_row,parent,false);
        return  new YoutubeHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        mAuth=FirebaseAuth.getInstance();
        DatesheetsInfo videoYT= videoList.get(position);
        YoutubeHolder yth = (YoutubeHolder) holder;
        yth.textView.setText(videoYT.getName());
        yth.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFiles(position);
            }
        });
        yth.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((mAuth.getCurrentUser()!=null && mAuth.getCurrentUser().isEmailVerified())){
                    Uri uri = getLink(position);
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    String shareBody = uri.toString();
                    String shareSubject = "Paper Link";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                    context.startActivity(Intent.createChooser(shareIntent, "Share Using"));
                }
                else {
                    checkAuthentication();
                }
            }
            private void checkAuthentication() {
                String[] items = {"Yes", "No"};
                AlertDialog.Builder dialog= new AlertDialog.Builder(context);
                dialog.setTitle("To Share you need to Login");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0){
                            Intent intent=new Intent(context, LoginActivity2.class);
                            context.startActivity(intent);
                        }
                        if(which ==1){
                            // do nothing
                        }
                    }
                });
                dialog.create().show();
            }
        });
        yth.btn_download.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View view) {
                String directory=getDirectory(position);
                toast();
                download(directory, yth.textView.getText().toString());
                Log.e("name",directory);

            }
        });

    }
    @NonNull
    @Override
    public int getItemCount() {
        return videoList.size();
    }
    class YoutubeHolder extends RecyclerView.ViewHolder{
        TextView textView;
        Button btn_share, btn_download;
        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.datesheetname);
            btn_share=itemView.findViewById(R.id.share);
            btn_download=itemView.findViewById(R.id.download_single);
            //t2=itemView.findViewById(R.id.t2);

        }
    }
    public void viewFiles(int position) {
        DatesheetsInfo datesheetsInfo = videoList.get(position);
        Intent intent = new Intent();
        intent.setType(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(datesheetsInfo.getUrl());
        if (uri.toString().contains(".pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public Uri getLink(int position){
        DatesheetsInfo datesheetsInfo = videoList.get(position);
        return ( Uri.parse(datesheetsInfo.getUrl()) );
    }
    public String getDirectory(int position){
        DatesheetsInfo datesheetsInfo = videoList.get(position);
        return ( datesheetsInfo.getDirectory() );
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
                        downloadfiles(context,filename, ".pdf", DIRECTORY_DOWNLOADS, url);
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
    public void toast(){
        Toast.makeText(context, "downloading", Toast.LENGTH_LONG).show();}

    public void downloadfiles(Context context, String file, String fileExtension, String destinationDirectory, String url)
    {
        DownloadManager downloadmanager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request =new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, file+fileExtension);
        downloadmanager.enqueue(request);
    }

}

