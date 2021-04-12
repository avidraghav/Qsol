package HS_ELE_subjectlists;

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

public class Ele_fourthsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_ele_fourthsem_subjectlist);
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
        globalClass.setBranch("EL");
        globalClass.setSemester("04");

        Log.e("Bord",globalClass.getBoard());

        ref= FirebaseDatabase.getInstance().getReference("IN/HS/EL/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("B1")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical machines-1", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("ES")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Energy sources and management of electrical energy", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("E2")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electronics-2", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("H2")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering design and drawing-2", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("IN")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Instrumentation", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("K1")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Estimating and costing in electrical engineering-1", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("U1")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Utilization if electrical energy-1", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("N2")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer programming and application-2", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", me_fourpapercount4+""));
                }

                Listadapter adapter = new Listadapter(Ele_fourthsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/B1");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/DE");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/E2");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/ES");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/H2");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/IN");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/K1");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/04/N2");
                    startActivity(intent);
                }



            }
        });
    }
}