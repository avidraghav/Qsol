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


public class Ele_thirdsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_ele_thirdsem_subjectlist2);
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

        ref= FirebaseDatabase.getInstance().getReference("IN/HS/EL/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("EM")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical and electronics engineering materials", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EI")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical measurements and measuring instruments", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("EI")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electronics-1", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("H1")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering design and drawing-1", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("N1")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer programming and application-1", me_fourpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("FE")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fundamentals of electrical engineering", me_fourpapercount4+""));
                }

                Listadapter adapter = new Listadapter(Ele_thirdsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/03/EI");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/03/E1");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/03/EM");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/03/FE");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/HS/EL/03/N1");
                    startActivity(intent);
                }


            }
        });
    }
}