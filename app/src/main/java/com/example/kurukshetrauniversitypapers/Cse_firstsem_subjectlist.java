package com.example.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
 ListView listview;
 List<Listdata> subjectlist;
 Button downloadall;
 TextView subjectname;
 TextView papercount;
TextView textView;

 static int onepapercount1,onepapercount2,onepapercount3,onepapercount4,onepapercount5,onepapercount6,onepapercount7,onepapercount8,onepapercount9,onepapercount10,onepapercount11,onepapercount12,onepapercount13,onepapercount14,onepapercount15,onepapercount16,onepapercount17;
 DatabaseReference ref;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_firstsem_subjectlist);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        listview=findViewById(R.id.list);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);


        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AC")) {
                    onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied chemistry", onepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("AM")) {
                    onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied mathematics", onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("AP")) {
                    onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied physics", onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("BI")) {
                    onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Biology", onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("BT")) {
                    onepapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Biotechnology", onepapercount5+""));

                }
                if(dataSnapshot.getKey().equals("CU")) {
                    onepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Calculus linear algebra", onepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("CH")) {
                    onepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Chemistry", onepapercount7+""));
                }

                if(dataSnapshot.getKey().equals("EE")) {
                    onepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering", onepapercount8+""));
                }
                if(dataSnapshot.getKey().equals("ET")) {
                    onepapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical technology", onepapercount9+""));
                }


                if(dataSnapshot.getKey().equals("ED")) {
                    onepapercount10=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Engineering drawing", onepapercount10+""));
                }
                if(dataSnapshot.getKey().equals("EH")) {
                    onepapercount11 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("English", onepapercount11+""));
                }
                if(dataSnapshot.getKey().equals("FP")) {
                    onepapercount12 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fundamentals of computer programming", onepapercount12+""));
                }
                if(dataSnapshot.getKey().equals("MA")) {
                    onepapercount13 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics", onepapercount13+""));
                }
                if(dataSnapshot.getKey().equals("ML")) {
                    onepapercount14 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Multivariable calculus and linear algebra", onepapercount14+""));
                }
                if(dataSnapshot.getKey().equals("PH")) {
                    onepapercount15 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Physics", onepapercount15+""));
                }

                if(dataSnapshot.getKey().equals("PP")) {
                    onepapercount16 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming for problem solving", onepapercount16+""));
                }
                if(dataSnapshot.getKey().equals("SH")) {
                    onepapercount17 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Semiconductor physics", onepapercount17+""));
                }

                Mylistadapter adapter = new Mylistadapter(getBaseContext(), R.layout.row, subjectlist);
                listview.setAdapter(adapter);

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

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/AC");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/AM");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/AP");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/BI");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/BT");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/CH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/CU");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/ED");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

                if(position==8) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/EE");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==9) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/EH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==10) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/ET");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==11) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/FP");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==12) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/MA");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==13) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/ML");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==14) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/PH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==15) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/PP");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==16) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/SH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }

}
