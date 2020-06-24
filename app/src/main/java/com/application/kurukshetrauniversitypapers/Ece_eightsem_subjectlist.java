package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Ece_eightsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int ece_eightpapercount1,ece_eightpapercount2,ece_eightpapercount3,ece_eightpapercount6,ece_eightpapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_eightsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        subjectlist = new ArrayList<>();

        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("ECE");
        globalClass.setSemester(8);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/08");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("EI")) {
                    ece_eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Embedded system design", ece_eightpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("MU")) {
                    ece_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Multimedia communication", ece_eightpapercount2+""));

                }

                if(dataSnapshot.getKey().equals("RA")) {
                    ece_eightpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Radar engineering", ece_eightpapercount3+""));

                }

                if(dataSnapshot.getKey().equals("TA")) {
                    ece_eightpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Transducer and their applications", ece_eightpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("WI")) {
                    ece_eightpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Wireless and mobile communication", ece_eightpapercount7+""));
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
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/EI");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/MU");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/MY");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/RA");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/RE");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/TA");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ece_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/08/WI");
                    startActivity(intent);
                }

            }
        });

    }
}
