package IT_subjectlists;

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

import Adapters.Mylistadapter;

public class It_eightsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int it_eightpapercount1,it_eightpapercount2,it_eightpapercount3,it_eightpapercount4,it_eightpapercount5,it_eightpapercount6,it_eightpapercount7,it_eightpapercount8,it_eightpapercount9;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_eightsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("IT");
        globalClass.setSemester(8);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/IT/08");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AA")) {
                    it_eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advance computer network and applications", it_eightpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("CI")) {
                    it_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Cryptography and information security", it_eightpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DW")) {
                    it_eightpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data warehouse and data mining", it_eightpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("MB")) {
                    it_eightpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mobile communication", it_eightpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("EI")) {
                    it_eightpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Embedded system", it_eightpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("IO")) {
                    it_eightpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Information technology applications", it_eightpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("AV")) {
                    it_eightpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advance database system", it_eightpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("ES")) {
                    it_eightpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Expert systems", it_eightpapercount8+""));
                }
                if(dataSnapshot.getKey().equals("CC")) {
                    it_eightpapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Cloud computing", it_eightpapercount9+""));
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
                    Intent intent=new Intent(It_eightsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/AA");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/AV");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/CC");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/EI");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/CI");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/DW");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/ES");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/IO");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==8) {
                    Intent intent=new Intent(It_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/08/MB");
                    startActivity(intent);
                    Toast.makeText(It_eightsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
