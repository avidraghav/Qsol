package KU_ECE_subjectlists;

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

public class Ece_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_eightpapercount2;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_thirdsem_subjectlist);
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
        globalClass.setBranch("EC");
        globalClass.setSemester("03");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("ER")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electronic devices", el_eightpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DE")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", el_eightpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("OW")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Optics and waves", el_eightpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("SS")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Signals and systems", el_eightpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("EO")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Essentials of information technology", el_eightpapercount2+""));
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
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/DE");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/EO");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/ER");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/OW");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/SS");
                    startActivity(intent);
                }
               
            }
        });
    }
}
