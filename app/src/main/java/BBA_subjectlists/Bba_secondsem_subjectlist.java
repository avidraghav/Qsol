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
    static int bb_onepapercount1,bb_onepapercount2,bb_onepapercount3,bb_onepapercount4,bb_onepapercount6,bb_onepapercount8;
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
                if(dataSnapshot.getKey().equals("AY")) {
                    bb_onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Analysis of financial statements", bb_onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("PM")) {
                    bb_onepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Principles of management", bb_onepapercount8+""));
                }
                if(dataSnapshot.getKey().equals("MZ")) {
                    bb_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Managerial economics", bb_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("US"))
                {
                    bb_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Understanding social behaviour", bb_onepapercount1+""));
                }
                if(dataSnapshot.getKey().equals("BM")) {
                    bb_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business mathematics", bb_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("BU")) {
                    bb_onepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business communication", bb_onepapercount6+""));
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
                    intent.putExtra("subject","IN/KU/BB/02/AY");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/BM");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/BU");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/MZ");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Bba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/02/PM");
                    startActivity(intent);
                }

            }
        });
    }
}
