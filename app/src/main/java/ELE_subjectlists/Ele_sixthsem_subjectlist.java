package ELE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.GlobalClass;
import com.application.kurukshetrauniversitypapers.Listdata;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Mylistadapter;

public class Ele_sixthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_sixpapercount1,el_sixpapercount2,el_sixpapercount3,el_sixpapercount4,el_sixpapercount6,el_sixpapercount7,el_sixpapercount8,el_sixpapercount9;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_sixthsem_subjectlist);
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
        globalClass.setSemester(6);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AE")) {
                    el_sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced programming", el_sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DP")) {
                    el_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital signal processing", el_sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("EN")) {
                    el_sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical drives and traction", el_sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("EZ")) {
                    el_sixpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical machine design", el_sixpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MP")) {
                    el_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microcontrollers and applications", el_sixpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("MS")) {
                    el_sixpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microprocessors and interfacing", el_sixpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("PE")) {
                    el_sixpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power electronics", el_sixpapercount8+""));
                }
                if(dataSnapshot.getKey().equals("PN")) {
                    el_sixpapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power system analysis and protection", el_sixpapercount9+""));
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
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/AE");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/DP");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/EN");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/EZ");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/MP");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/MS");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/PE");
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/PN");
                    startActivity(intent);
                }

            }
        });
    }
}
