package KU_ME_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.application.kurukshetrauniversitypapers.Pdflist;

import utils.GlobalClass;
import utils.Listdata;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Listadapter;

public class Me_seventhsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int me_sevenpapercount1, me_sevenpapercount2, me_sevenpapercount3, me_sevenpapercount4, me_sevenpapercount5, me_sevenpapercount6, me_sevenpapercount7;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_seventhsem_subjectlist);
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
        globalClass.setBranch("ME");
        globalClass.setSemester("07");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/ME/07");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AF")) {
                    me_sevenpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced manufacturing tech", me_sevenpapercount1+""));
                }
                if(dataSnapshot.getKey().equals("EP")) {
                    me_sevenpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Entrepreneurship", me_sevenpapercount1+""));
                }
                if(dataSnapshot.getKey().equals("CF")) {
                    me_sevenpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer aided design and manufacturing", me_sevenpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("PI")) {
                    me_sevenpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Powerplant engineering", me_sevenpapercount3+""));
                }
                if(dataSnapshot.getKey().equals("MR")) {
                    me_sevenpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Measurement and control", me_sevenpapercount4+""));
                }
                if(dataSnapshot.getKey().equals("SQ")) {
                    me_sevenpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Statistical quality control and reliability", me_sevenpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("M6")) {
                    me_sevenpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mechatronics", me_sevenpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("M4")) {
                    me_sevenpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Non conventional machining", me_sevenpapercount5+""));

                }


                Listadapter adapter = new Listadapter(Me_seventhsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/AF");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/CF");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/EP");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/M4");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/M6");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/MR");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/PI");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Me_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/07/SQ");
                    startActivity(intent);
                }


            }
        });
    }
}
