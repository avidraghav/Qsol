package com.application.kurukshetrauniversitypapers.subjectlist;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Locale;

import model.File;
import model.Subject;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.SubjectViewHolder> {

    private static final String TAG = "SubjectListAdapter";

    private Context context;
    private List<Subject> subjectList;
    private String semester;
    private OnSubjectItemClickListener listener;
    private FirebaseFirestore db;

    public SubjectListAdapter(Context context, List<Subject> subjectList, OnSubjectItemClickListener listener) {
        this.context = context;
        this.subjectList = subjectList;
        this.listener = listener;
        db = FirebaseFirestore.getInstance();
    }

    /**
     * Downloads all files from the given subject.
     * TODO This method needs to be updated to work properly
     *
     * @param subject the subject from which to download the files
     */
    private void download(final Subject subject) {

        // TODO Replace strings of collections with constants
        DocumentReference subjectRef = db.collection("subjects").document(subject.getId());
        db.collection("files").whereEqualTo("subject", subjectRef).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot snapshots) {
                        List<File> files = snapshots.toObjects(File.class);
                        for (File file : files) {
                            String fileName = file.getName() + ".pdf";
                            downloadFile(fileName, file.getUrl());
                        }
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
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_subject, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.itemView.setOnClickListener(v -> {
            listener.onClick(subject);
        });
        holder.subjectNameTextView.setText(subject.getName());
        holder.paperCountTextView.setText(String.format(Locale.getDefault(), "%d", subject.getPapersCount()));
        holder.downloadButton.setOnClickListener(v -> {
            download(subjectList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    // TODO Unify all recyclerview item click listeners with a java generic
    public interface OnSubjectItemClickListener {
        void onClick(Subject subject);
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {

        TextView subjectNameTextView;
        TextView paperCountTextView;
        ImageButton downloadButton;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            this.subjectNameTextView = itemView.findViewById(R.id.tv_subject_name);
            this.paperCountTextView = itemView.findViewById(R.id.tv_paper_count);
            this.downloadButton = itemView.findViewById(R.id.ib_download);
        }
    }
}

