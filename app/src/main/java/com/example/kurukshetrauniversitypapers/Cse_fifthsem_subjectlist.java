package com.example.kurukshetrauniversitypapers;

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

public class Cse_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;

    static int fivepapercount1,fivepapercount2,fivepapercount3,fivepapercount4,fivepapercount5,fivepapercount6,fivepapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_fifthsem_subjectlist);

        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("CSE");
        globalClass.setSemester(5);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AT")) {
                    fivepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Automata Theory", fivepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EO")) {
                    fivepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Essentials of information technology", fivepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CN")) {
                    fivepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer networks", fivepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("CO")) {
                    fivepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer organisation and architecture", fivepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("DA")) {
                    fivepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Design and analysis of algorithm", fivepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("SA")) {
                    fivepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Simulation and modelling", fivepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("OS")) {
                    fivepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Operating systems", fivepapercount7+""));
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
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/AT");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/EO");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/CN");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/CO");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/DA");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/SA");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/OS");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
