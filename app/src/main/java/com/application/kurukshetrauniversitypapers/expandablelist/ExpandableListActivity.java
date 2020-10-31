package com.application.kurukshetrauniversitypapers.expandablelist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.MainActivity;
import com.application.kurukshetrauniversitypapers.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import model.Branch;
import model.Semester;

public class ExpandableListActivity extends AppCompatActivity {

    private static final String TAG = "ExpandableListActivity";

    private TextView refreshTextView;
    private RecyclerView expandableRecyclerView;
    private ExpandableListAdapter adapter;

    private String boardId;
    private List<Branch> branches = new ArrayList<>();

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        Log.d(TAG, "onCreate: Started");

        // TODO Replace with all necessary data from intent
        boardId = "CfWBxI3tij0D2Mfwh6na";

        refreshTextView = findViewById(R.id.tv_refresh);
        expandableRecyclerView = findViewById(R.id.rv_expandable_list);

        db = FirebaseFirestore.getInstance();
        getBranches();

        adapter = new ExpandableListAdapter(this, branches);
        expandableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        expandableRecyclerView.setAdapter(adapter);

        // TODO See what to do with the refresh
//        refreshTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ExpandableListActivity.this, Expendable_loader.class);
//                intent.putExtra("reference", "btech");
//                startActivity(intent);
//            }
//        });
    }

    private void getBranches() {
        Log.d(TAG, "getBranches: called.");
        // TODO Replace strings of collections with constants
        DocumentReference boardRef = db.collection("boards").document(boardId);
        db.collection("branches").whereEqualTo("board", boardRef).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot snapshots) {
                        Log.d(TAG, "onSuccess: successfully.");
                        List<Branch> dbBranches = snapshots.toObjects(Branch.class);
                        for (Branch branch : dbBranches) {
                            if (branch != null) {
                                branches.add(branch);
                                getSemesters(branch);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure: failed.", e);
            }
        });
    }

    private void getSemesters(@NonNull Branch branch) {
        // TODO Replace strings of collections with constants
        DocumentReference branchRef = db.collection("branches").document(branch.getId());
        db.collection("semesters")
                .whereEqualTo("branch", branchRef)
                .whereEqualTo("isSyllabus", false)
                .orderBy("key").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot snapshots) {
                        List<Semester> dbSemesters = snapshots.toObjects(Semester.class);
                        branch.getSemesters().clear();
                        branch.getSemesters().addAll(dbSemesters);
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ExpandableListActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter", "no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}
