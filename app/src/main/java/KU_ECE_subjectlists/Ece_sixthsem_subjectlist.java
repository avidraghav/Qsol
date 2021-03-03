package KU_ECE_subjectlists;

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

public class Ece_sixthsem_subjectlist extends AppCompatActivity {

    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int ece_sixpapercount2,ece_sixpapercount6;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_sixthsem_subjectlist);
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
        globalClass.setSemester("06");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {

                if(dataSnapshot.getKey().equals("CS")) {
                    ece_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Control system engineering", ece_sixpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("OB")) {
                    ece_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Organisational behaviour", ece_sixpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("TA")) {
                    ece_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Transducer and their applications", ece_sixpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("VD")) {
                    ece_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("VHDL and digital systems", ece_sixpapercount6+""));
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
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/CS");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/OB");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/TA");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/VD");
                    startActivity(intent);
                }

            }
        });

    }
}
