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

public class Ele_eightsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_eightpapercount1,el_eightpapercount2,el_eightpapercount3,el_eightpapercount4,el_eightpapercount5;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_eightsem_subjectlist);
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
        globalClass.setSemester(8);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EL/08");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CP")) {
                    el_eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer methods in power systems", el_eightpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EG")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering material and processes", el_eightpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("IF")) {
                    el_eightpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Internet Fundamental", el_eightpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("OR")) {
                    el_eightpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Operation research", el_eightpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("UT")) {
                    el_eightpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Utilisation of electrical energy", el_eightpapercount5+""));
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
                    Intent intent=new Intent(Ele_eightsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/08/CP");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ele_eightsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/08/EG");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ele_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/08/IF");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Ele_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/08/OR");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Ele_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EL/08/UT");
                    startActivity(intent);
                }

            }
        });
    }
}
