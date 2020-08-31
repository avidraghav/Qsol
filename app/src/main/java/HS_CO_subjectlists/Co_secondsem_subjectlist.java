package HS_CO_subjectlists;

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

import Adapters.Listadapter;

public class Co_secondsem_subjectlist extends AppCompatActivity {

    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int me_fourpapercount1, me_fourpapercount2, me_fourpapercount3, me_fourpapercount4, me_fourpapercount5;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_secondsem_subjectlist);
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
        globalClass.setBoard("HS");
        globalClass.setBranch("CO");
        globalClass.setSemester(2);

        ref= FirebaseDatabase.getInstance().getReference("IN/HS/CO/02");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("S2")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Communication skills-2", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("M2")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied mathematics-2", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("P2")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied physics-2", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("C2")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied chemistry-2", me_fourpapercount3+""));
                }
                if(dataSnapshot.getKey().equals("D2")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Engineering drawing-2", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("AM")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Applied mechanics", me_fourpapercount4+""));
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
                    Intent intent=new Intent(Co_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/HS/CO/02/AM");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CO/02/C2");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CO/02/D2");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CO/02/M2");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CO/02/P2");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CO/02/S2");
                    startActivity(intent);
                }


            }
        });
    }
}