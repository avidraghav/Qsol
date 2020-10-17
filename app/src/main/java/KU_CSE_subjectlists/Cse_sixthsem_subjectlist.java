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

public class Cse_sixthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int sixpapercount1,sixpapercount2,sixpapercount3,sixpapercount4,sixpapercount5,sixpapercount6,sixpapercount7,sixpapercount8;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sixthsem_subjectlist);
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
        globalClass.setSemester("06");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AD")) {
                    sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced database systems", sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("CD")) {
                    sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Compiler design", sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CN")) {
                    sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer hardware technologies", sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("CT")) {
                    sixpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mobile computing", sixpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("MC")) {
                    sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Network management and security", sixpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("NM")) {
                    sixpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software engineering", sixpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("SE")) {
                    sixpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Web engineering", sixpapercount8+""));
                }
                if(dataSnapshot.getKey().equals("UL")) {
                    sixpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer networks", sixpapercount8+""));
                }
                if(dataSnapshot.getKey().equals("WE")) {
                    sixpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Unix and Linux programming", sixpapercount8+""));
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
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/AD");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/CD");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/CN");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/CT");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/MC");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/NM");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/SE");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Cse_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/06/WE");
                    startActivity(intent);
                    Toast.makeText(Cse_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
