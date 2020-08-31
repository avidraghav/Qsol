package KU_ELE_subjectlists;

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

public class Ele_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_threepapercount;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ele_thirdsem_subjectlist);
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
        globalClass.setBranch("ELE");
        globalClass.setSemester(3);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AN")) {
                    el_threepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Analog Electronics", el_threepapercount+""));

                }
                if(dataSnapshot.getKey().equals("CY")) {
                    el_threepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Communication system", el_threepapercount+""));

                }
                if(dataSnapshot.getKey().equals("EA")) {
                    el_threepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical machines", el_threepapercount+""));

                }
                if(dataSnapshot.getKey().equals("EJ")) {
                    el_threepapercount=(int)dataSnapshot.getChildrenCount();

                    subjectlist.add(new Listdata("Electrical measurements and measuring instruments", el_threepapercount+""));

                }
                if(dataSnapshot.getKey().equals("EK")) {
                    el_threepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electromechanical energy conversion", el_threepapercount+""));

                }
                if(dataSnapshot.getKey().equals("ER")) {
                    el_threepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electronic devices", el_threepapercount+""));

                }
                if(dataSnapshot.getKey().equals("EX")) {
                    el_threepapercount =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical power generation", el_threepapercount+""));
                }
                if(dataSnapshot.getKey().equals("NA")) {
                    el_threepapercount =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Network analysis and synthesis", el_threepapercount+""));
                }
                if(dataSnapshot.getKey().equals("PO")) {
                    el_threepapercount =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power transmission and distribution", el_threepapercount+""));
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
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/AN");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/CY");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/EA");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/EJ");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/EK");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/ER");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/EX");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/NA");
                    startActivity(intent);
                }
                if(position==8) {
                    Intent intent=new Intent(Ele_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/03/PO");
                    startActivity(intent);
                }

            }
        });

    }
}
