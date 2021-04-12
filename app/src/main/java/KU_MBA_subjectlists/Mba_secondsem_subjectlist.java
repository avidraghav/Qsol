package KU_MBA_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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

public class Mba_secondsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mb_twopapercount1,mb_twopapercount2,mb_twopapercount3,mb_twopapercount4,mb_twopapercount5,mb_twopapercount6,mb_twopapercount7,mb_twopapercount8,mb_twopapercount9,mb_twopapercount10;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba_secondsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBoard("KU");
        globalClass.setBranch("MB");
        globalClass.setSemester("02");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MB/02");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("BR")) {
                    mb_twopapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business research methodology", mb_twopapercount1+""));

                }
                if(dataSnapshot.getKey().equals("FM")) {
                    mb_twopapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Financial management", mb_twopapercount2+""));

                }
                if(dataSnapshot.getKey().equals("HR")) {
                    mb_twopapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Human resource management", mb_twopapercount3+""));

                }
                if(dataSnapshot.getKey().equals("MH")) {
                    mb_twopapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Management science", mb_twopapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MK")) {
                    mb_twopapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Marketing management", mb_twopapercount5+""));
                }
                if(dataSnapshot.getKey().equals("OB")) {
                    mb_twopapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Organisational behaviour ", mb_twopapercount6+""));
                }
                if(dataSnapshot.getKey().equals("FX")) {
                    mb_twopapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Foreign exchange management", mb_twopapercount7+""));
                }
                if(dataSnapshot.getKey().equals("CR")) {
                    mb_twopapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Corporate finance", mb_twopapercount8+""));
                }
                if(dataSnapshot.getKey().equals("LE")) {
                    mb_twopapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Legal environment", mb_twopapercount9+""));
                }
                if(dataSnapshot.getKey().equals("PI")) {
                    mb_twopapercount10 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Production and operations management", mb_twopapercount10+""));
                }


                Listadapter adapter = new Listadapter(Mba_secondsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/BR");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/CR");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/FM");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/FX");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/HR");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/LE");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/MH");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/MK");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==8) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/OB");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==9) {
                    Intent intent=new Intent(Mba_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/02/PI");
                    startActivity(intent);
                    Toast.makeText(Mba_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });
        
        
    }
}
