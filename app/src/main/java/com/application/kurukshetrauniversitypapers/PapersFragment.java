package com.application.kurukshetrauniversitypapers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.Pdflistadapter;


public class PapersFragment extends Fragment {
    Button cse,it,me,ee,ec,mb,bb,bc,mc,first,second,third,fourth,fifth,sixth,seventh,eight;
    String selected_branch,selected_semester;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    DatabaseReference db,databaseReference;
    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
    ListView listView;
    ValueEventListener listener;

    public PapersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_papers, container, false);
        cse=v.findViewById(R.id.cse);
        it=v.findViewById(R.id.it);
        me=v.findViewById(R.id.me);
        ee=v.findViewById(R.id.ee);
        ec=v.findViewById(R.id.ec);
        mb=v.findViewById(R.id.mb);
        bb=v.findViewById(R.id.bb);
        bc=v.findViewById(R.id.bc);
        mc=v.findViewById(R.id.mc);
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
        listView=v.findViewById(R.id.list);
        spinner=v.findViewById(R.id.spinner);

        setDefaultList();
        cse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="CS";
                setList();
                cse.setBackgroundResource(R.drawable.button_pressed);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
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
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_pressed);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
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
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_pressed);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
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
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_pressed);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
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
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_pressed);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(false);
                fifth.setEnabled(false);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="MB";
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_pressed);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(false);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="BB";
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_pressed);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(false);
                fifth.setEnabled(false);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="BC";
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_pressed);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(false);
                fifth.setEnabled(false);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
            }
        });
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="MC";
                setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_pressed);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(true);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="01";
                setList();
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
                setList();
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
                setList();
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
                setList();
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
                setList();
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
                setList();
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
                setList();
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
                setList();
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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter.notifyDataSetChanged();
                Log.e("val", spinner.getSelectedItem() + "");
                Subjectcode subjectcode = new Subjectcode();
                subjectcode.setSubjectname(spinner.getSelectedItem().toString());
                displayResults();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        return v;
    }

    public void setList()
    {
        db = FirebaseDatabase.getInstance().getReference().child(selected_branch + selected_semester);
        listener=db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                subjects.clear();
                for(DataSnapshot item: dataSnapshot.getChildren())
                {
                    subjects.add(item.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, subjects);
        spinner.setAdapter(adapter);
        inflate();

    }

    public void setDefaultList()
    {
        selected_branch="CS";
        selected_semester="01";
        cse.setBackgroundResource(R.drawable.button_pressed);
        first.setBackgroundResource(R.drawable.button_pressed);
        db = FirebaseDatabase.getInstance().getReference().child(selected_branch+selected_semester);
        listener=db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot item: dataSnapshot.getChildren())
                {
                    subjects.add(item.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, subjects);
        spinner.setAdapter(adapter);
        inflate();
    }

    public void inflate()
    { spinner.performClick();}
//    public void inflate()
//    {
//        findViewById(android.R.id.content).post(new Runnable() {
//        @Override
//        public void run() {
//            spinner.performClick();
//        }
//    });
//    }

    public void displayResults()
    {
        if(selected_branch.equals("IT")|| selected_branch.equals("ME")|| selected_branch.equals("EC")|| selected_branch.equals("EL"))
        {
            if(selected_semester.equals("01") || selected_semester.equals("02"))
            {
                selected_branch = "CS";
                Subjectcode subjectcode = new Subjectcode();
                SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
                singleDownloadClass.setBranch(selected_branch);
                singleDownloadClass.setSemester(selected_semester);
                singleDownloadClass.setCode(subjectcode.getcode());
                databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + subjectcode.getcode());
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        uploadPDFS.clear();
                        for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                            uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                            uploadPDFS.add(uploadPDF);
                        }

                        Pdflistadapter adapter = new Pdflistadapter(getActivity(), uploadPDFS);
                        listView.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            else {
                Subjectcode subjectcode = new Subjectcode();
                SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
                singleDownloadClass.setBranch(selected_branch);
                singleDownloadClass.setSemester(selected_semester);
                singleDownloadClass.setCode(subjectcode.getcode());
                databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + subjectcode.getcode());
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        uploadPDFS.clear();
                        for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                            uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                            uploadPDFS.add(uploadPDF);
                        }

                        Pdflistadapter adapter = new Pdflistadapter(getActivity(), uploadPDFS);
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        }
        else {
            Subjectcode subjectcode = new Subjectcode();
            SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
            singleDownloadClass.setBranch(selected_branch);
            singleDownloadClass.setSemester(selected_semester);
            singleDownloadClass.setCode(subjectcode.getcode());
            databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + subjectcode.getcode());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    uploadPDFS.clear();
                    for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                        uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                        uploadPDFS.add(uploadPDF);
                    }

                    Pdflistadapter adapter = new Pdflistadapter(getActivity(), uploadPDFS);
                    listView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}