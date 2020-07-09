package ECE_subjectlists;

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

import Adapters.Mylistadapter;

public class Ece_sixthsem_subjectlist extends AppCompatActivity {

    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int ece_sixpapercount1,ece_sixpapercount2,ece_sixpapercount3,ece_sixpapercount4,ece_sixpapercount6,ece_sixpapercount5;
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
        globalClass.setBranch("ECE");
        globalClass.setSemester(6);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CE")) {
                    ece_sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer communication network", ece_sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("CS")) {
                    ece_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Control system engineering", ece_sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DI")) {
                    ece_sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital design using verilog", ece_sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("DO")) {
                    ece_sixpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital communication", ece_sixpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("DP")) {
                    ece_sixpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital signal processing", ece_sixpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("VD")) {
                    ece_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("VHDL and digital systems", ece_sixpapercount6+""));
                }

                Mylistadapter adapter = new Mylistadapter(getBaseContext(), R.layout.row, subjectlist);
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
                    intent.putExtra("subject","IN/KU/EC/06/CE");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/CS");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/DI");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/DO");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/DP");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ece_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/06/VD");
                    startActivity(intent);
                }

            }
        });

    }
}
