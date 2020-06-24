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

public class Cse_sixthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;

    static int sixpapercount1,sixpapercount2,sixpapercount3,sixpapercount4,sixpapercount5,sixpapercount6,sixpapercount7,sixpapercount8;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sixthsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("CSE");
        globalClass.setSemester(6);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AD")) {
                    sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced database systems", sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("CD")) {
                    sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Compiler design semester", sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CT")) {
                    sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer hardware technologies", sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("EO")) {
                    sixpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Essentials of information technology", sixpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MC")) {
                    sixpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mobile computing", sixpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("NM")) {
                    sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Network management and security", sixpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("SE")) {
                    sixpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software engineering", sixpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("WE")) {
                    sixpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Web engineering", sixpapercount8+""));
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
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/AD");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/CD");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/CT");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/EO");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/MC");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/NM");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/SE");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/WE");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
