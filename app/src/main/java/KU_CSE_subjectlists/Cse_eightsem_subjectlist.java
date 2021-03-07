package KU_CSE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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


public class Cse_eightsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    TextView downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int eightpapercount1,eightpapercount2,eightpapercount3,eightpapercount4,eightpapercount5,eightpapercount6,eightpapercount7,eightpapercount8;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_eightsem_subjectlist);
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
        globalClass.setSemester("08");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/08");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CC")) {
                    eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Cloud computing", eightpapercount1+""));

                }

                if(dataSnapshot.getKey().equals("MD")) {
                    eightpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mobile apps development", eightpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("NL")) {
                    eightpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Neural network and fuzzy logic", eightpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("ST")) {
                    eightpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software testing", eightpapercount7+""));
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
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/CC");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/MD");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/NL");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/08/ST");
                    startActivity(intent);
                    Toast.makeText(Cse_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
