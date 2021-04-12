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

public class Mba_firstsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mb_onepapercount1,mb_onepapercount2,mb_onepapercount3,mb_onepapercount4,mb_onepapercount5,mb_onepapercount6,mb_onepapercount7,mb_onepapercount8,mb_onepapercount9,mb_onepapercount10;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba_firstsem_subjectlist);
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
        globalClass.setSemester("01");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MB/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("PD")) {
                    mb_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Principles and practices of management", mb_onepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("BN")) {
                    mb_onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business communication ", mb_onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("BS")) {
                    mb_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business statistics", mb_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("CB")) {
                    mb_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer applications for business", mb_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("FA")) {
                    mb_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Financial accounting ", mb_onepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("FS")) {
                    mb_onepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Financial reporting statement and analysis ", mb_onepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("MQ")) {
                    mb_onepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Management processes and organisational behaviour ", mb_onepapercount7+""));
                }
                if(dataSnapshot.getKey().equals("SY")) {
                    mb_onepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Statistics and analysis of decision making ", mb_onepapercount8+""));
                }
                if(dataSnapshot.getKey().equals("MN")) {
                    mb_onepapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Managerial economics", mb_onepapercount9+""));
                }
                if(dataSnapshot.getKey().equals("BE")) {
                    mb_onepapercount10 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business environment ", mb_onepapercount10+""));
                }


                Listadapter adapter = new Listadapter(Mba_firstsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/BE");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/BN");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/BS");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/CB");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/FA");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/FS");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/MN");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/MQ");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==8) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/PD");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==9) {
                    Intent intent=new Intent(Mba_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/01/SY");
                    startActivity(intent);
                    Toast.makeText(Mba_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });
        
    }
}
