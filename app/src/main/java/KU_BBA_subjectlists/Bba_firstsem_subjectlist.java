package KU_BBA_subjectlists;

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

public class Bba_firstsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int bb_onepapercount1,bb_onepapercount3,bb_onepapercount4,bb_onepapercount5,bb_onepapercount9;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bba_firstsem_subjectlist);

        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        listView=findViewById(R.id.list);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("BB");
        globalClass.setSemester("01");
        globalClass.setBoard("KU");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/BB/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("BA")) {
                    bb_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business accounting", bb_onepapercount1+""));

                }
//
                if(dataSnapshot.getKey().equals("MZ")) {
                    bb_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Managerial economics", bb_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("BM")) {
                    bb_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business mathematics", bb_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("HI")) {
                    bb_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Hindi", bb_onepapercount5+""));
                }

                if(dataSnapshot.getKey().equals("CF")) {
                    bb_onepapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer fundamentals", bb_onepapercount9+""));
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
                    Intent intent=new Intent(Bba_firstsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/01/BA");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Bba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/01/BM");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Bba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/01/CF");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Bba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/01/HI");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Bba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BB/01/MZ");
                }

            }
        });
    }
}
