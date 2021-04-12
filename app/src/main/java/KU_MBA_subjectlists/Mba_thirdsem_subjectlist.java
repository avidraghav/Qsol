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

public class Mba_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mb_threepapercount1,mb_threepapercount2,mb_threepapercount3,mb_threepapercount4,mb_threepapercount5,mb_threepapercount6,mb_threepapercount7,mb_threepapercount8,mb_threepapercount9,mb_threepapercount10;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba_thirdsem_subjectlist);
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
        globalClass.setSemester("03");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MB/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("BL")) {
                    mb_threepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business legislation", mb_threepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("LF")) {
                    mb_threepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Legal framework governing human relations", mb_threepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("MJ")) {
                    mb_threepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Manpower development for technological change", mb_threepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("OI")) {
                    mb_threepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Organisation change and intervention strategies", mb_threepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("SD")) {
                    mb_threepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Sales and distribution management", mb_threepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("SR")) {
                    mb_threepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Strategic management", mb_threepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("WC")) {
                    mb_threepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Working capital management", mb_threepapercount7+""));
                }



                Listadapter adapter = new Listadapter(Mba_thirdsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/BL");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/LF");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/MJ");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/OI");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/SD");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/SR");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Mba_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MB/03/WC");
                    startActivity(intent);
                    Toast.makeText(Mba_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
