package com.example.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Cse_firstsem_subjectlist extends AppCompatActivity {
 ListView listView;
 List<Listdata> subjectlist;
 Button downloadall;
 TextView subjectname;
 static int papercount1,papercount2,papercount3,papercount4,papercount5;
 DatabaseReference ref;
 StorageReference storageReference,myref;
 FirebaseStorage firebaseStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_firstsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);

//        final ArrayList<String> subjects=new ArrayList<String >();
//        subjects.add("Physics");
//        subjects.add("Mathematics");
//        subjects.add("Foundation of computer programming");
//        subjects.add("Engineering drawing and graphics");
//        subjects.add("Biotechnology");
//
//        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subjects);
//        listView.setAdapter(adapter)
        subjectlist = new ArrayList<>();
           Log.e("info","11");
           ref=FirebaseDatabase.getInstance().getReference("IN/KU/CS/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("BI")) {
                    papercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Biotechnology", papercount5));
                    Log.e("papers", papercount5 + "");

                }
                if(dataSnapshot.getKey().equals("ED")) {
                    papercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Engineering drawing", papercount4));
                    Log.e("papers", papercount4 + "");

                }
                if(dataSnapshot.getKey().equals("FP")) {
                    papercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Foundation of computer programming", papercount3));
                    Log.e("papers", papercount3 + "");

                }
                if(dataSnapshot.getKey().equals("MA")) {
                    papercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics", papercount2));
                    Log.e("papers", papercount2 + "");

                }
                if(dataSnapshot.getKey().equals("PH")) {
                    papercount1 =(int)dataSnapshot.getChildrenCount();
                    Log.e("papers", papercount1 + "");
                    subjectlist.add(new Listdata("Physics", papercount1));
                }

                Mylistadapter adapter = new Mylistadapter(getBaseContext(), R.layout.row, subjectlist);
                listView.setAdapter(adapter);

            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(subjects.get(position).equals("Physics")) {
//                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
//                    intent1.putExtra("subject", "cse-firstsem-Physics");
//                    startActivity(intent1);
//                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(subjects.get(position).equals("Mathematics")) {
//                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
//                    intent1.putExtra("subject", "cse-firstsem-Mathematics");
//                    startActivity(intent1);
//                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(subjects.get(position).equals("Foundation of computer programming")) {
//                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
//                    intent1.putExtra("subject", "cse-firstsem-Foundation of computer programming");
//                    startActivity(intent1);
//                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(subjects.get(position).equals("Engineering drawing and graphics")) {
//                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
//                    intent1.putExtra("subject", "cse-firstsem-Engineering drawing and graphics");
//                    startActivity(intent1);
//                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(subjects.get(position).equals("Biotechnology")) {
//                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
//                    intent1.putExtra("subject", "cse-firstsem-Biotechnology");
//                    startActivity(intent1);
//                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

}
