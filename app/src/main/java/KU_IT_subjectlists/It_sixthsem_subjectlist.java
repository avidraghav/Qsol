package KU_IT_subjectlists;

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

public class It_sixthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int it_sixpapercount1,it_sixpapercount2,it_sixpapercount3,it_sixpapercount4,it_sixpapercount5,it_sixpapercount6,it_sixpapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_sixthsem_subjectlist);
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
        globalClass.setBranch("IT");
        globalClass.setSemester(6);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/IT/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("LX")) {
                    it_sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Linux", it_sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EC")) {
                    it_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("E commerce", it_sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DA")) {
                    it_sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Design and analysis of algorithm", it_sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("SE")) {
                    it_sixpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software engineering", it_sixpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("NC")) {
                    it_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Non conventional sources of energy", it_sixpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("DW")) {
                    it_sixpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data warehouse and data mining", it_sixpapercount7+""));
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
                    Intent intent=new Intent(It_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/06/DA");
                    startActivity(intent);
                    Toast.makeText(It_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(It_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/06/DW");
                    startActivity(intent);
                    Toast.makeText(It_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(It_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/06/EC");
                    startActivity(intent);
                    Toast.makeText(It_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(It_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/06/LX");
                    startActivity(intent);
                    Toast.makeText(It_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(It_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/06/NC");
                    startActivity(intent);
                    Toast.makeText(It_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(It_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/06/SE");
                    startActivity(intent);
                    Toast.makeText(It_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
