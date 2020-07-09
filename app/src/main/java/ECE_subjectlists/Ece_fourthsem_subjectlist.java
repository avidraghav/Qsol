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

public class Ece_fourthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int ece_fourpapercount1,ece_fourpapercount2,ece_fourpapercount3,ece_fourpapercount4,ece_fourpapercount5,ece_fourpapercount6,ece_fourpapercount7,ece_fourpapercount8,ece_fourpapercount9;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_fourthsem_subjectlist);

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
        globalClass.setSemester(4);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AN")) {
                    ece_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Analog Electronics", ece_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("CA")) {
                    ece_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer architecture and organisation", ece_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DE")) {
                    ece_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", ece_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("DT")) {
                    ece_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data structures and algorithms", ece_fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("EM")) {
                    ece_fourpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electronic measurements and instruments", ece_fourpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("EY")) {
                    ece_fourpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electromagnetic theory", ece_fourpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("FW")) {
                    ece_fourpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Field and waves", ece_fourpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("MS")) {
                    ece_fourpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microprocessors and interfacing", ece_fourpapercount8+""));
                }
                if(dataSnapshot.getKey().equals("TA")) {
                    ece_fourpapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Transducer and their applications", ece_fourpapercount9+""));
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
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/AN");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/CA");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/DE");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/DT");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/EM");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/EY");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/FW");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/MS");
                    startActivity(intent);
                }
                if(position==8) {
                    Intent intent=new Intent(Ece_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/04/TA");
                    startActivity(intent);
                }
            }
        });

    }
}
