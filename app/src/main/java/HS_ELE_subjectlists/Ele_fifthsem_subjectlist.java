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

public class Ele_fifthsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_ele_fifthsem_subjectlist2);
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
        globalClass.setSemester("03");

        Log.e("Bord",globalClass.getBoard());

        ref= FirebaseDatabase.getInstance().getReference("IN/HS/EL/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("B2")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical machines-2", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("L1")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical power-1", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("EN")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Industrial electronics and control of drives", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DM")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics and microprocessors", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("K2")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Estimating and costing in electrical engineering-2", me_fourpapercount4+""));
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
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/05/B2");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/05/DM");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/05/EN");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/05/K2");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/05/L1");
                    startActivity(intent);
                }


            }
        });
    }
}