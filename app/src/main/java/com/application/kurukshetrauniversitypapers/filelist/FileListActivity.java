package com.application.kurukshetrauniversitypapers.filelist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import model.File;

public class FileListActivity extends AppCompatActivity {

    public static final String KEY_BOARD = "board";
    public static final String KEY_BRANCH = "branch";
    public static final String KEY_SEMESTER = "semester";
    public static final String KEY_SUBJECT = "subject";

    private RecyclerView fileListRecyclerView;
    private FirebaseFirestore db;
    private FileListAdapter adapter;
    private List<File> files = new ArrayList<>();
    private FirebaseAuth mAuth;

    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filelist);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        fileListRecyclerView = findViewById(R.id.rv_file_list);

        adapter = new FileListAdapter(this, files);
        fileListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fileListRecyclerView.setAdapter(adapter);

        // TODO Replace hardcoded string with constant
        String subjectId = getIntent().getStringExtra("subject");
        getFiles(subjectId);
    }

    private void getFiles(String subjectId) {
        // TODO Replace collection strings with constants
        DocumentReference subjectRef = db.collection("subjects").document(subjectId);
        db.collection("files").whereEqualTo("subject", subjectRef).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot snapshots) {
                        List<File> dbFiles = snapshots.toObjects(File.class);
                        files.addAll(dbFiles);
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
