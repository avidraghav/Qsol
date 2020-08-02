package com.application.kurukshetrauniversitypapers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.SyllabusAdapter;
import Adapters.SyllabusAdapter;

public class SyllabusFragment extends Fragment {
    Button cse,it,me,ee,ec,mb,bb,bc,mc,first,second,third,fourth,fifth,sixth,seventh,eight;
    String selected_branch,selected_semester;
    DatabaseReference db,databaseReference;
    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
    ListView listView;
    
    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_syllabus, container, false);
        cse=v.findViewById(R.id.cse);
        it=v.findViewById(R.id.it);
        me=v.findViewById(R.id.me);
        ee=v.findViewById(R.id.ee);
        ec=v.findViewById(R.id.ec);
        first=v.findViewById(R.id.first);
        second=v.findViewById(R.id.second);
        third=v.findViewById(R.id.third);
        fourth=v.findViewById(R.id.fourth);
        fifth=v.findViewById(R.id.fifth);
        sixth=v.findViewById(R.id.sixth);
        seventh=v.findViewById(R.id.seventh);
        eight=v.findViewById(R.id.eight);
        uploadPDFS= new ArrayList<>();
        subjects=new ArrayList<>();
        listView=v.findViewById(R.id.list_syllabus);

       displayDefaultResults();
        cse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="CS";
             displayResults();
                cse.setBackgroundResource(R.drawable.button_pressed);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);

            }
        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="IT";
             displayResults();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_pressed);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="ME";
             displayResults();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_pressed);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="EC";
             displayResults();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_pressed);
                ee.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
            }
        });
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="EL";
             displayResults();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_pressed);
                third.setEnabled(false);
                fifth.setEnabled(false);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
            }
        });


        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="01";
             displayResults();
                first.setBackgroundResource(R.drawable.button_pressed);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="02";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_pressed);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="03";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_pressed);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="04";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_pressed);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);

            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="05";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_pressed);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="06";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_pressed);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="07";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_pressed);
                eight.setBackgroundResource(R.drawable.button_default);

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="08";
             displayResults();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_pressed);
            }
        });
        
        return v;
    }
   
    
    public void displayResults()
    {
        Subjectcode subjectcode = new Subjectcode();
        SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
        singleDownloadClass.setBranch(selected_branch);
        singleDownloadClass.setSemester(selected_semester);
        singleDownloadClass.setCode(subjectcode.getcode());
        databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + "Syllabus");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                uploadPDFS.clear();
                for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                    uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                    uploadPDFS.add(uploadPDF);
                }

                SyllabusAdapter adapter = new SyllabusAdapter(getActivity(), uploadPDFS);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void displayDefaultResults()
    {
        selected_branch="CS";
        selected_semester="01";
        cse.setBackgroundResource(R.drawable.button_pressed);
        first.setBackgroundResource(R.drawable.button_pressed);

        SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
        singleDownloadClass.setBranch(selected_branch);
        singleDownloadClass.setSemester(selected_semester);
        databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + "Syllabus");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                uploadPDFS.clear();
                for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                    uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                    uploadPDFS.add(uploadPDF);
                }

                SyllabusAdapter adapter = new SyllabusAdapter(getActivity(), uploadPDFS);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}