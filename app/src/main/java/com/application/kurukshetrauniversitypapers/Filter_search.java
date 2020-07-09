package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.Pdflistadapter;

public class Filter_search extends AppCompatActivity {
Spinner spinner1,spinner2,spinner3, spinner_country,spinner_university,spinner_course;
Button search;
ArrayList<String> branch,semester,country, university,course;
ArrayAdapter<String> adapter_branch,adapter_semester,adapter_subject,adapter_country,adapter_university,adapter_course;
    DatabaseReference db;
   ArrayList<String> dis;
   ListView listView;
    TextView textViewName;
    Button download_single;
    List<uploadPDF> uploadPDFS;
    String branch_code;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_search);

        spinner1 = findViewById(R.id.spinner1);
        spinner2= findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        spinner_university=findViewById(R.id.spinner_university);
        spinner_course=findViewById(R.id.spinner_course);
        search=findViewById(R.id.search);
        listView=findViewById(R.id.list);
        textViewName=findViewById(R.id.pdfname);
        download_single=findViewById(R.id.download_single);
        uploadPDFS= new ArrayList<>();
         dis=new ArrayList<>();


//         country=new ArrayList<>();
//         country.add("India");
//         adapter_country=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,country);
//         spinner_country.setAdapter(adapter_country);

        university=new ArrayList<>();
        university.add("Kurukshetra University");
        adapter_university=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,university);
        spinner_university.setAdapter(adapter_university);

        course=new ArrayList<>();
        course.add("B.Tech");
        adapter_course=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,course);
        spinner_course.setAdapter(adapter_course);


        branch=new ArrayList<>();
        branch.add("Computer Science Engineering");
        branch.add("Information Technology");
        branch.add("Mechanical Engineering");
        branch.add("Electronics and Communication Engineering");
        branch.add("Electrical Engineering");
      adapter_branch=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,branch);
        spinner1.setAdapter(adapter_branch);

        semester=new ArrayList<>();
        semester.add("01");
        semester.add("02");
        semester.add("03");
        semester.add("04");
        semester.add("05");
        semester.add("06");
        semester.add("07");
        semester.add("08");
        adapter_semester=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,semester);
        spinner2.setAdapter(adapter_semester);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner1.getSelectedItem().toString()) {
                    case "Computer Science Engineering":
                        branch_code="CS";
                        break;
                    case "Information Technology":
                        branch_code="IT";
                        break;
                    case "Mechanical Engineering":
                        branch_code="ME";
                        break;
                    case "Electronics and Communication Engineering":
                        branch_code="EC";
                        break;
                    case "Electrical Engineering":
                        branch_code="EL";
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(spinner1.getSelectedItem().equals("Information Technology")
                        || spinner1.getSelectedItem().equals("Mechanical Engineering")
                        || spinner1.getSelectedItem().equals("Electronics and Communication Engineering")
                        || spinner1.getSelectedItem().equals("Electrical Engineering"))
                {
                    if (spinner2.getSelectedItem().equals("03") || spinner2.getSelectedItem().equals("05"))
                    {
                        Toast.makeText(Filter_search.this, "No papers available for this combination", Toast.LENGTH_SHORT).show();
                        db = FirebaseDatabase.getInstance().getReference().child("EMP");
                        db.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    dis.clear();
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        String arr = ds.getValue(String.class);
                                        dis.add(arr);
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        adapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, dis);
                        spinner3.setAdapter(adapter_subject);
                    }
                    else
                        {
                            db = FirebaseDatabase.getInstance().getReference().child(branch_code + spinner2.getSelectedItem().toString());
                            db.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        dis.clear();
                                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                            String arr = ds.getValue(String.class);
                                            dis.add(arr);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            adapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, dis);
                            spinner3.setAdapter(adapter_subject);
                        }
                }

                if(spinner1.getSelectedItem().equals("Computer Science Engineering") )
                {
                    db = FirebaseDatabase.getInstance().getReference().child(branch_code + spinner2.getSelectedItem().toString());
                    db.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                dis.clear();
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    String arr = ds.getValue(String.class);
                                    dis.add(arr);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    adapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, dis);
                    spinner3.setAdapter(adapter_subject);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter_subject.notifyDataSetChanged();
                Log.e("val",spinner3.getSelectedItem()+"");
                Subjectcode subjectcode=new Subjectcode();
                subjectcode.setSubjectname(spinner3.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Subjectcode subjectcode=new Subjectcode();
                SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
                singleDownloadClass.setBranch(branch_code);
                singleDownloadClass.setSemester(spinner2.getSelectedItem().toString());
                singleDownloadClass.setCode(subjectcode.getcode());

                    databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + branch_code + "/" + spinner2.getSelectedItem().toString() + "/" + subjectcode.getcode());
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            uploadPDFS.clear();
                            for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                                uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                                uploadPDFS.add(uploadPDF);
                            }

                            Pdflistadapter adapter = new Pdflistadapter(Filter_search.this, uploadPDFS);
                            listView.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Pdflistadapter adapter = new Pdflistadapter(Filter_search.this, uploadPDFS);
                    listView.setAdapter(adapter);



            }
        });







    }



}
