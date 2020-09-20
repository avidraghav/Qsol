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

public class Ele_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_fivepapercount;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ele_fifthsem_subjectlist);
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
        globalClass.setSemester("05");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AN")) {
                    el_fivepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Analog Electronics", el_fivepapercount+""));

                }
                if(dataSnapshot.getKey().equals("CS")) {
                    el_fivepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Control system engineering", el_fivepapercount+""));

                }
                if(dataSnapshot.getKey().equals("CY")) {
                    el_fivepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Communication system", el_fivepapercount+""));

                }
                if(dataSnapshot.getKey().equals("EJ")) {
                    el_fivepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical measurements and measuring instruments", el_fivepapercount+""));

                }
                if(dataSnapshot.getKey().equals("FW")) {
                    el_fivepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Field and waves", el_fivepapercount+""));

                }
                if(dataSnapshot.getKey().equals("NC")) {
                    el_fivepapercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Non conventional sources of energy and management", el_fivepapercount+""));

                }
                if(dataSnapshot.getKey().equals("PE")) {
                    el_fivepapercount =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power electronics", el_fivepapercount+""));
                }

                if(dataSnapshot.getKey().equals("PO")) {
                    el_fivepapercount =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power transmission and distribution", el_fivepapercount+""));
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
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/AN");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/CS");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/CY");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/EJ");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/FW");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/NC");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/PE");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Ele_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/05/PO");
                    startActivity(intent);
                }

            }
        });

    }
}

