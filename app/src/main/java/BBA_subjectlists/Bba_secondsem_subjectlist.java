package BBA_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.application.kurukshetrauniversitypapers.GlobalClass;
import com.application.kurukshetrauniversitypapers.Listdata;
import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Mylistadapter;

public class Bba_secondsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int bb_twopapercount1,bb_twopapercount2,bb_twopapercount3,bb_twopapercount4,bb_twopapercount5,bb_twopapercount6,bb_twopapercount7,bb_twopapercount8;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bba_secondsem_subjectlist);

        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);
        listView=findViewById(R.id.list);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("BBA");
        globalClass.setSemester(2);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/BB/02");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("UH")) {
                    bb_twopapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Understanding human behaviour", bb_twopapercount1+""));

                }
                if(dataSnapshot.getKey().equals("MT")) {
                    bb_twopapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Micro business environment", bb_twopapercount2+""));

                }
                if(dataSnapshot.getKey().equals("BS")) {
                    bb_twopapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business statistics", bb_twopapercount3+""));

                }
                if(dataSnapshot.getKey().equals("MG")) {
                    bb_twopapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Management accounting", bb_twopapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MK")) {
                    bb_twopapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Marketing management", bb_twopapercount5+""));
                }
                if(dataSnapshot.getKey().equals("FM")) {
                    bb_twopapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Financial management", bb_twopapercount6+""));
                }
                if(dataSnapshot.getKey().equals("HB")) {
                    bb_twopapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Human behaviour at work", bb_twopapercount7+""));
                }
                if(dataSnapshot.getKey().equals("FD")) {
                    bb_twopapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fundamentals of DBMS and ORACLE", bb_twopapercount8+""));
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
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/BS");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/FD");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/FM");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/HB");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/MG");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/MK");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/MT");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/UH");
                    startActivity(intent);
                }
            }
        });
    }
}
