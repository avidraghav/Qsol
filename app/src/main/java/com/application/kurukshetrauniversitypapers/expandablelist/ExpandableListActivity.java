package com.application.kurukshetrauniversitypapers.expandablelist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.MainActivity;
import com.application.kurukshetrauniversitypapers.R;

import java.util.ArrayList;
import java.util.List;

import model.Branch;
import model.Semester;

public class ExpandableListActivity extends AppCompatActivity {

    private TextView refreshTextView;
    private RecyclerView expandableRecyclerView;
    private ExpandableListAdapter adapter;

    private String board;
    private List<Branch> branches = new ArrayList<>();
//    private List<Semester> semesters = new ArrayList<>();

//    private FirebaseFirestore db;

//    private int cs01, cs02, cs03, cs04, cs05, cs06, cs07, cs08, ec03, ec04, ec05, ec06, ec07, ec08, it03, it04, it05, it06, it07, it08, el03, el05, el04, el06, el07, el08, me03, me04, me05, me06, me07, me08;
//    private int total_cse, total_ece, total_it, total_el, total_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        // TODO Replace with all necessary data from intent
        // board = "KU";

        refreshTextView = findViewById(R.id.tv_refresh);
        expandableRecyclerView = findViewById(R.id.rv_expandable_list);

//        db = FirebaseFirestore.getInstance();
        getData();

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

    private void getData() {
//        db.collection("branches")
//                .whereEqualTo("board", board).get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> branchTask) {
//                List<DocumentSnapshot> branchDocuments = branchTask.getResult().getDocuments();
//                for (DocumentSnapshot branchDoc : branchDocuments) {
//                    Branch branch = branchDoc.toObject(Branch.class);
//                     if (branch != null) {
//                        branches.add(branch);
//                        getSemesters(branch);
//                    }
//                    // TODO Notify data set changed
//                }
//            }
//        });
        branches.add(new Branch("Computer Science Engineering", null));
        branches.add(new Branch("Information Technology", null));
        branches.add(new Branch("Mechanical Engineering", null));
        branches.add(new Branch("Electronics and Communication Engineering", null));
        branches.add(new Branch("Electrical Engineering", null));

        for (Branch branch : branches) {
            getSemesters(branch);
        }
    }

    private void getSemesters(Branch branch) {
        // TODO Check database structure and update appropriately
//        db.collection("semesters")
//                .whereEqualTo("board", board)
//                .whereEqualTo("branch", branch.getId())
//                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        List<DocumentSnapshot> semesterDocs = task.getResult().getDocuments();
//                        for(DocumentSnapshot semesterDoc : semesterDocs) {
//                            Semester semester = semesterDoc.toObject(Semester.class);
//                            branch.addSemester(semester);
//                        }
//                        // TODO Notify data set changed
//                    }
//                });
        // TODO Replace dummy data with real data
        List<Semester> sems = new ArrayList<>();
        sems.add(new Semester("First Semester", null, 50));
        sems.add(new Semester("Second Semester", null, 62));
        sems.add(new Semester("Third Semester", null, 120));
        sems.add(new Semester("Fourth Semester", null, 77));
        sems.add(new Semester("Fifth Semester", null, 31));
        branch.setSemesters(sems);
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
