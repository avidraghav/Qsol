package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.Pdflistadapter;

public class Pdflist extends AppCompatActivity  {
     ListView listView;
     DatabaseReference databaseReference;
     List<uploadPDF> uploadPDFS;
     TextView textViewName;
     Button download_single;
     FirebaseAuth mAuth;

     String key;
     String br,sm,cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdflist);
        mAuth=FirebaseAuth.getInstance();
        listView=findViewById(R.id.pdflist);
        textViewName=findViewById(R.id.pdfname);
        download_single=findViewById(R.id.download_single);
        uploadPDFS= new ArrayList<>();


        Intent intent1=getIntent();
        key=intent1.getStringExtra("subject");
        br=key.substring(6,8);
        sm=key.substring(9,11);
        cd=key.substring(12);


        SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
          singleDownloadClass.setBranch(br);
          singleDownloadClass.setSemester(sm);
          singleDownloadClass.setCode(cd);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uploadPDF uploadPDF=uploadPDFS.get(position);
                Intent intent=new Intent();
                intent.setType(Intent.ACTION_VIEW);
                Uri uri=Uri.parse(uploadPDF.getUrl());
                if(uri.toString().contains(".pdf")) {
                    intent.setDataAndType(uri,"application/pdf");
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

//
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=getIntent();
        key=intent.getStringExtra("subject");
        databaseReference= FirebaseDatabase.getInstance().getReference(key);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                uploadPDFS.clear();
                for(DataSnapshot pdfSnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=pdfSnapshot.getValue(uploadPDF.class);
                    uploadPDFS.add(uploadPDF);
                }

                 Pdflistadapter adapter= new Pdflistadapter(Pdflist.this,uploadPDFS);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}
