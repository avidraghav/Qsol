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

import Adapters.Listadapter;

public class Mba_fourthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mb_fourpapercount1,mb_fourpapercount2,mb_fourpapercount3,mb_fourpapercount4,mb_fourpapercount5,mb_fourpapercount6,mb_fourpapercount7,mb_fourpapercount8,mb_fourpapercount9,mb_fourpapercount10,mb_fourpapercount11,mb_fourpapercount12,mb_fourpapercount13,mb_fourpapercount14,mb_fourpapercount15;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba_fourthsem_subjectlist);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        listView=findViewById(R.id.list);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBoard("KU");
        globalClass.setBranch("MB");
        globalClass.setSemester("04");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MB/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CV")) {
                    mb_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Compensation management ", mb_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EL")) {
                    mb_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Entrepreneurship development", mb_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("IL")) {
                    mb_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Industrial marketing", mb_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("IT")) {
                    mb_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("International marketing", mb_fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MF")) {
                    mb_fourpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Management of financial services ", mb_fourpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("MO")) {
                    mb_fourpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Management of training and development", mb_fourpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("MR")) {
                    mb_fourpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Marketing communication stratergy", mb_fourpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("PT")) {
                    mb_fourpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Portfolio management ", mb_fourpapercount8+""));
                }
                if(dataSnapshot.getKey().equals("PB")) {
                    mb_fourpapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Principles of insurance and banking", mb_fourpapercount9+""));
                }
                if(dataSnapshot.getKey().equals("PJ")) {
                    mb_fourpapercount10 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Project management", mb_fourpapercount10+""));
                }
                if(dataSnapshot.getKey().equals("SG")) {
                    mb_fourpapercount11 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Service marketing", mb_fourpapercount11+""));
                }
                if(dataSnapshot.getKey().equals("MX")) {
                    mb_fourpapercount12 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Human resource planning and development", mb_fourpapercount12+""));
                }
                if(dataSnapshot.getKey().equals("FT")) {
                    mb_fourpapercount13 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Financial derivative ", mb_fourpapercount13+""));
                }
                if(dataSnapshot.getKey().equals("IA")) {
                    mb_fourpapercount14 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("International financial management ", mb_fourpapercount14+""));
                }
                if(dataSnapshot.getKey().equals("SI")) {
                    mb_fourpapercount15 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Strategies and systems", mb_fourpapercount15+""));
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
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/CV");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/EL");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/FT");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/IA");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/IL");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/IT");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

                if(position==6) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/MF");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/MO");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==8) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/MR");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==9) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/MX");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==10) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/PB");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==11) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/PJ");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==12) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/PT");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==13) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/SG");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==14) {
                    Intent intent=new Intent(Mba_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/04/SI");
                    startActivity(intent);
                    Toast.makeText(Mba_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
