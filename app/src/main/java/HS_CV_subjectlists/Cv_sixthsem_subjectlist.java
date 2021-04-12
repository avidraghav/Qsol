package HS_CV_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Cv_sixthsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_cv_sixthsem_sybjeclist);
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
        globalClass.setBranch("CV");
        globalClass.setSemester("06");

        Log.e("Bord",globalClass.getBoard());

        ref= FirebaseDatabase.getInstance().getReference("IN/HS/CV/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("EC")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Earthquake resistant building construction", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("RT")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Railways bridges and tunnels", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("QV")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Quantity surveying and valuation", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CD")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Construction management and accounts", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("CB")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Repair and maintenance of building", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("PC")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Prestressed concrete", me_fourpapercount4+""));
                }


                Listadapter adapter = new Listadapter(Cv_sixthsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/HS/CV/06/CB");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CV/06/CD");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CV/06/EC");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CV/06/PC");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CV/06/QV");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/CV/06/RT");
                    startActivity(intent);
                }
            }
        });
    }
}