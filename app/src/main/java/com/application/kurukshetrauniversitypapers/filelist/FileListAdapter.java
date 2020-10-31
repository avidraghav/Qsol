package com.application.kurukshetrauniversitypapers.filelist;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.LoginActivity;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import model.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.FileViewHolder> {

    private static final String TAG = "FileListAdapter";

    private Context context;
    private List<File> files;

    public FileListAdapter(Context context, List<File> files) {
        this.context = context;
        this.files = files;
    }

    private void view(File file) {
        Intent intent = new Intent();
        intent.setType(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(file.getUrl());

        if (file.getFileName().endsWith(".pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void download(File file) {

        // TODO Handle gs:// links different here
        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(file.getUrl());
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        // TODO Add complete file name to database to avoid using hardcoded .pdf extension
        request.setDestinationInExternalFilesDir(context, DIRECTORY_DOWNLOADS, file.getFileName());
        downloadmanager.enqueue(request);
    }

    private void share(File file) {
        // TODO Remove this attributes if possible
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if ((mAuth.getCurrentUser() == null)) {
            String[] items = {"Yes", "No"};
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle("To share you need to login");
            dialog.setItems(items, (dialog1, which) -> {
                if (which == 0) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            dialog.create().show();
        } else {
            Uri uri = Uri.parse(file.getUrl());
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareBody = uri.toString();
            String shareSubject = "Paper Link";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
            context.startActivity(Intent.createChooser(shareIntent, "Share Using"));
        }
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_file, parent, false);
        return new FileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
        File file = files.get(position);
        Log.d(TAG, "onBindViewHolder: File name is " + file.getName());
        holder.fileNameTextView.setText(file.getName());
        holder.itemView.setOnClickListener(v -> view(file));
        holder.downloadButton.setOnClickListener(v -> download(file));
        holder.shareButton.setOnClickListener(v -> share(file));
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    public static class FileViewHolder extends RecyclerView.ViewHolder {

        TextView fileNameTextView;
        ImageButton downloadButton;
        ImageButton shareButton;

        public FileViewHolder(@NonNull View itemView) {
            super(itemView);
            fileNameTextView = itemView.findViewById(R.id.tv_file_name);
            downloadButton = itemView.findViewById(R.id.ib_file_download);
            shareButton = itemView.findViewById(R.id.ib_file_share);
        }
    }
}
