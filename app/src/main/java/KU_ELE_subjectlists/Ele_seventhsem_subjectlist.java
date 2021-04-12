package KU_ELE_subjectlists;

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

public class Ele_seventhsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_sevenpapercount1,el_sevenpapercount2,el_sevenpapercount3,el_sevenpapercount4,el_sevenpapercount5;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_seventhsem_subjectlist);
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
        globalClass.setBranch("EL");
        globalClass.setSemester("07");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/07");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("DN")) {
                    el_sevenpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Discrete data non linear control system", el_sevenpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EZ")) {
                    el_sevenpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical machine design", el_sevenpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("HV")) {
                    el_sevenpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("High voltage engineering", el_sevenpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("NC")) {
                    el_sevenpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Non conventional sources of energy and management", el_sevenpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("TA")) {
                    el_sevenpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Transducer and their applications", el_sevenpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("P5")) {
                    el_sevenpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power systems operation and control", el_sevenpapercount5+""));
                }

                Listadapter adapter = new Listadapter(Ele_seventhsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Ele_seventhsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/07/DN");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/07/EZ");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/07/HV");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/07/NC");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/07/P5");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ele_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/07/TA");
                    startActivity(intent);
                }

            }
        });
    }
}
