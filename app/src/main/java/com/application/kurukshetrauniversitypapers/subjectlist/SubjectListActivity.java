package com.application.kurukshetrauniversitypapers.subjectlist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.R;

import java.util.ArrayList;
import java.util.List;

import model.Lecture;

import static com.application.kurukshetrauniversitypapers.Pdflist.KEY_BOARD;
import static com.application.kurukshetrauniversitypapers.Pdflist.KEY_BRANCH;
import static com.application.kurukshetrauniversitypapers.Pdflist.KEY_SEMESTER;
import static com.application.kurukshetrauniversitypapers.Pdflist.KEY_SUBJECT;

public class SubjectListActivity extends AppCompatActivity implements SubjectListAdapter.OnLectureItemClickListener {

    public static final String KEY_TITLE = "key";
    List<Lecture> subjectList;
    SubjectListAdapter adapter;
    private String boardId;
    private String branchId;
    private String semesterId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        loadMetaData();

        RecyclerView subjectsRecyclerView = findViewById(R.id.rv_subject_list);

        subjectList = new ArrayList<>();
        adapter = new SubjectListAdapter(this, boardId, branchId, semesterId, subjectList, this);
        subjectsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        subjectsRecyclerView.setAdapter(adapter);

        getData();
    }

    private void loadMetaData() {
        Intent intent = getIntent();
        String key = intent.getStringExtra(KEY_TITLE);
        ((TextView) findViewById(R.id.tv_title)).setText(key);

        boardId = intent.getStringExtra(KEY_BOARD);
        branchId = intent.getStringExtra(KEY_BRANCH);
        semesterId = intent.getStringExtra(KEY_SEMESTER);
    }

    private void getData() {
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("IN");
//        ref = ref.child(boardId).child(branchId).child(semesterId);
//        ref.addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
//                String id = dataSnapshot.getKey();
//                String subjectName = dataSnapshot.child("subject_name").getValue(String.class);
//                long paperCount = dataSnapshot.getChildrenCount();
//
//                subjectList.add(new Lecture(id, subjectName, paperCount));
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {
//                // TODO Update single child with notifyItemChanged(int position)
//                //  instead of notifyDataSetChanged()
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//                // TODO Remove single child with notifyItemRemoved(int position)
//                //  instead of notifyDataSetChanged()
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String s) {
//                // TODO Move child with notifyItemMoved(int startPosition, int endPosition)
//                //  instead of notifyDataSetChanged()
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // TODO Handle cancellation?
//            }
//        });

        subjectList.add(new Lecture("diuasbd", "Advanced web technology", 3));
        subjectList.add(new Lecture("23321313", "Cloud computing", 23));
        subjectList.add(new Lecture("236313", "Compiler design", 2));
        subjectList.add(new Lecture("23323413", "Computer architecture and parallel processing", 4));
        subjectList.add(new Lecture("23445313", "Computer graphics", 1));
        subjectList.add(new Lecture("2337913", "Mobile apps development", 7));
        subjectList.add(new Lecture("23283313", "Linux and shell programming", 8));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(Lecture lecture) {
        Intent intent = new Intent(SubjectListActivity.this, Pdflist.class);

        intent.putExtra(KEY_BOARD, boardId);
        intent.putExtra(KEY_BRANCH, branchId);
        intent.putExtra(KEY_SEMESTER, semesterId);
        intent.putExtra(KEY_SUBJECT, lecture.getId());
        startActivity(intent);
    }
}
