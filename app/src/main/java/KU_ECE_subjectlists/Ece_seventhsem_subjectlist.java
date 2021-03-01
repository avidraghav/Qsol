package KU_ECE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import utils.GlobalClass;
import utils.Listdata;
import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Listadapter;

public class Ece_seventhsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int ece_sevenpapercount1,ece_sevenpapercount2,ece_sevenpapercount3,ece_sevenpapercount4,ece_sevenpapercount6,ece_sevenpapercount5,ece_sevenpapercount7;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_seventhsem_subjectlist);
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
        globalClass.setBoard("KU");
        globalClass.setBranch("EC");
        globalClass.setSemester("07");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/07");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AI")) {
                    ece_sevenpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Artificial intelligence and expert systems", ece_sevenpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("ME")) {
                    ece_sevenpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microwave engineering", ece_sevenpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("OC")) {
                    ece_sevenpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Optical communication", ece_sevenpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("RE")) {
                    ece_sevenpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Reliability", ece_sevenpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("TE")) {
                    ece_sevenpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Television engineering", ece_sevenpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("VL")) {
                    ece_sevenpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("VLSI design", ece_sevenpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("MP")) {
                    ece_sevenpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microcontrollers and applications", ece_sevenpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("NC")) {
                    ece_sevenpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Non conventional sources of energy and management", ece_sevenpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("D9")) {
                    ece_sevenpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital image processing", ece_sevenpapercount7+""));
                }

                Listadapter adapter = new Listadapter(getBaseContext(), R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/AI");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/D9");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/ME");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/MP");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/NC");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/OC");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/RE");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/TE");
                    startActivity(intent);
                }
                if(position==8) {
                    Intent intent=new Intent(Ece_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/07/VL");
                    startActivity(intent);
                }

            }
        });

    }
}
