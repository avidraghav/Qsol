package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class Pdflist extends AppCompatActivity  {
     ListView listView;
     DatabaseReference databaseReference;
     List<uploadPDF> uploadPDFS;
     TextView textViewName,textViewSol;
     FirebaseAuth mAuth;

     String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdflist);
        mAuth=FirebaseAuth.getInstance();
        listView=findViewById(R.id.pdflist);
        textViewName=findViewById(R.id.pdfname);
        textViewSol=findViewById(R.id.solution);
        uploadPDFS= new ArrayList<>();
        //pdfView=findViewById(R.id.pdfView);


       // viewAllFiles1();

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

//         textViewSol.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 String[] items = {"Yes", "No"};
//                 AlertDialog.Builder dialog= new AlertDialog.Builder(Pdflist.this);
//                 dialog.setTitle("Signup first");
//                 dialog.setItems(items, new DialogInterface.OnClickListener() {
//                     @Override
//                     public void onClick(DialogInterface dialog, int which) {
//                         if(which==0){
//                             Intent intent=new Intent(Pdflist.this,RegisterActivity.class);
//                             startActivity(intent);
//                         }
//                         if(which ==1){
//
//                         }
//                     }
//                 });
//                 dialog.create().show();
//             }
//         });
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
