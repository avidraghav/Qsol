package KU_CSE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import utils.GlobalClass;
import utils.Listdata;
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

public class Cse_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int threepapercount1,threepapercount2,threepapercount3,threepapercount4,threepapercount5,threepapercount6,threepapercount7,threepapercount8,threepapercount9;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_thirdesem_subjectlist);
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
        globalClass.setBranch("CS");
        globalClass.setSemester("03");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
//
                if(dataSnapshot.getKey().equals("BG")) {
                    threepapercount9=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Business intelligence and entrepreneurship", threepapercount9+""));
                }
                if(dataSnapshot.getKey().equals("M3")) {
                    threepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics 3", threepapercount2+""));
                }
//                if(dataSnapshot.getKey().equals("DM")) {
//                    threepapercount2=(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Database management system", threepapercount2+""));
//                }
                if(dataSnapshot.getKey().equals("DT")) {
                    threepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data structures and algorithms", threepapercount3+""));
                }
//                if(dataSnapshot.getKey().equals("DS")) {
//                    threepapercount4=(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Data structures", threepapercount4+""));
//
//                }
                if(dataSnapshot.getKey().equals("DE")) {
                    threepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", threepapercount5+""));
                }
//                if(dataSnapshot.getKey().equals("IF")) {
//                    threepapercount6 =(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Internet Fundamental", threepapercount6+""));
//                }
                if(dataSnapshot.getKey().equals("OP")) {
                    threepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Object oriented programming", threepapercount7+""));
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    threepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming language", threepapercount8+""));
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
                    Intent intent=new Intent(Cse_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/BG");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DE");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/DT");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/M3");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/OP");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/03/PL");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
//                if(position==2) {
//                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/03/DE");
//                    startActivity(intent);
//                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==6) {
//                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/03/IF");
//                    startActivity(intent);
//                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==7) {
//                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/03/OP");
//                    startActivity(intent);
//                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==8) {
//                    Intent intent=new Intent(Cse_thirdesem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/03/PL");
//                    startActivity(intent);
//                    Toast.makeText(Cse_thirdesem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
