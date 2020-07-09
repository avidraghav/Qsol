package ELE_subjectlists;

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

public class Ele_fourthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_fourpapercount1,el_fourpapercount2,el_fourpapercount3,el_fourpapercount4,el_fourpapercount5,el_fourpapercount6,el_fourpapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_fourthsem_subjectlist);
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
        globalClass.setBranch("EL");
        globalClass.setSemester(4);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CY")) {
                    el_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Communication system", el_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DE")) {
                    el_fourpapercount6=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", el_fourpapercount6+""));

                }
                if(dataSnapshot.getKey().equals("EA")) {
                    el_fourpapercount7=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical machines", el_fourpapercount7+""));

                }
                if(dataSnapshot.getKey().equals("EG")) {
                    el_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering material and processes", el_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("EM")) {
                    el_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electronic measurements and instruments", el_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("PG")) {
                    el_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power generation and control", el_fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("SS")) {
                    el_fourpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Signals and systems", el_fourpapercount5+""));
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
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/CY");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/DE");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/EA");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/EG");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/EM");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/PG");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ele_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/04/SS");
                    startActivity(intent);
                }

            }
        });

    }
}
