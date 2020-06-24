package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Cse_thirdesem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    static int threepapercount1,threepapercount2,threepapercount3,threepapercount4,threepapercount5,threepapercount6,threepapercount7,threepapercount8;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_thirdesem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);


        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("CSE");
        globalClass.setSemester(3);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("DC")) {
                    threepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Discrete structure", threepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DM")) {
                    threepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Database management system", threepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DT")) {
                    threepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data structures and algorithms", threepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("DS")) {
                    threepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data structures", threepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("DE")) {
                    threepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", threepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("IF")) {
                    threepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Internet Fundamental", threepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("OP")) {
                    threepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Object oriented programming", threepapercount7+""));
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    threepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming language", threepapercount8+""));
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
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DC");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DM");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DT");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DS");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DE");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/IF");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/OP");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/PL");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
