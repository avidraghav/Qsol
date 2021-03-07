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

public class Ele_sixthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_sixpapercount1,el_sixpapercount2,el_sixpapercount6;
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
        globalClass.setBoard("KU");
        globalClass.setBranch("EL");
        globalClass.setSemester("06");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("EJ")) {
                    el_sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical measurements and measuring instruments", el_sixpapercount1+""));
                }
                if(dataSnapshot.getKey().equals("E4")) {
                    el_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering material", el_sixpapercount2+""));
                }
                if(dataSnapshot.getKey().equals("OB")) {
                    el_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Organisational behaviour", el_sixpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("PN")) {
                    el_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Power system analysis and protection", el_sixpapercount6+""));
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
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/E4");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/EJ");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/OB");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/06/PN");
                    startActivity(intent);
                }


            }
        });
    }
}
