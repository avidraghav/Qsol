package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;



public class Cse_eightsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    TextView downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;

    static int eightpapercount1,eightpapercount2,eightpapercount3,eightpapercount4,eightpapercount5,eightpapercount6,eightpapercount7,eightpapercount8;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_eightsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);


        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/08");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CC")) {
                    eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Cloud computing", eightpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DW")) {
                    eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data warehouse and data mining", eightpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("IC")) {
                    eightpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Interactive computer graphics", eightpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("MD")) {
                    eightpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mobile apps development", eightpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("NO")) {
                    eightpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Neural network and fuzzy lose", eightpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("NL")) {
                    eightpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Neural network and fuzzy logic", eightpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("ST")) {
                    eightpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software testing", eightpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("SV")) {
                    eightpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software verification validation and testing", eightpapercount8+""));
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/CC");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/DW");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/IC");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/MA");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/NL");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/NO");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/ST");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/SW");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
