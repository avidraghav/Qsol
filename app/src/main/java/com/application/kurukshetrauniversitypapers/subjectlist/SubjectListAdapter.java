package com.application.kurukshetrauniversitypapers.subjectlist;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;
import java.util.Locale;

import model.Lecture;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.LectureViewHolder> {

    private static final String TAG = "SubjectListAdapter";

    private Context context;
    private List<Lecture> subjectList;
    private String board;
    private String branch;
    private String semester;
    private OnLectureItemClickListener listener;

    public SubjectListAdapter(Context context, String board, String branch, String semester, List<Lecture> subjectList, OnLectureItemClickListener listener) {
        this.context = context;
        this.board = board;
        this.branch = branch;
        this.semester = semester;
        this.subjectList = subjectList;
        this.listener = listener;
    }

    /**
     * Downloads all files from the given subject.
     * TODO This method needs to be updated to work properly
     *
     * @param subject the subject from which to download the files
     */
    private void download(final Lecture subject) {

        StorageReference storageReference = FirebaseStorage.getInstance().getReference("IN")
                .child(board).child(branch).child(semester).child(subject.getId());
        DatabaseReference rootref = FirebaseDatabase.getInstance().getReference("IN")
                .child(board).child(branch).child(semester).child(subject.getId());

        rootref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (final DataSnapshot paper : dataSnapshot.getChildren()) {
                    // TODO Improve this part of code
                    Object file = paper.child("name").getValue();
                    storageReference.child(file.toString() + ".pdf")
                            .getDownloadUrl().addOnSuccessListener(uri -> {
                        String url = uri.toString();
                        downloadFile(file.toString(), url);
                    }).addOnFailureListener(e -> {
                        Toast.makeText(context, "Unable to download now, try later", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Failed to get download URL.", e);
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // TODO Handle cancellation
            }
        });
    }

    /**
     * Downloads a file and stores it locally under the downloads directory of the device.
     * TODO This method needs to be updated to work properly
     *
     * @param file the file name to use for the downloaded file
     * @param url  the download URL of the file to download
     */
    private void downloadFile(String file, String url) {
        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, DIRECTORY_DOWNLOADS, file + ".pdf");
        downloadmanager.enqueue(request);
    }

    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_subject, parent, false);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder holder, int position) {
        Lecture lecture = subjectList.get(position);
        holder.itemView.setOnClickListener(v -> {
            listener.onClick(lecture);
        });
        holder.subjectNameTextView.setText(lecture.getName());
        holder.paperCountTextView.setText(String.format(Locale.getDefault(), "%d", lecture.getPapersCount()));
        holder.downloadButton.setOnClickListener(v -> {
            download(subjectList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public interface OnLectureItemClickListener {
        void onClick(Lecture lecture);
    }

    public static class LectureViewHolder extends RecyclerView.ViewHolder {

        TextView subjectNameTextView;
        TextView paperCountTextView;
        ImageButton downloadButton;

        public LectureViewHolder(@NonNull View itemView) {
            super(itemView);
            this.subjectNameTextView = itemView.findViewById(R.id.tv_subject_name);
            this.paperCountTextView = itemView.findViewById(R.id.tv_paper_count);
            this.downloadButton = itemView.findViewById(R.id.ib_download);
        }
    }
}

