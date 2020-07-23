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

public class It_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int it_sixpapercount1,it_sixpapercount2,it_sixpapercount3,it_sixpapercount4,it_sixpapercount5,it_sixpapercount6,it_sixpapercount7,it_sixpapercount8;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_fifthsem_subjectlist);
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
        globalClass.setSemester(5);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/IT/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("LI")) {
                    it_sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Linux operating system", it_sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("IU")) {
                    it_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Introduction to digital data communication", it_sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("MY")) {
                    it_sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Multimedia and virtual reality", it_sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("CM")) {
                    it_sixpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer graphics", it_sixpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("WD")) {
                    it_sixpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Web design", it_sixpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("NN")) {
                    it_sixpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Network programming", it_sixpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("OS")) {
                    it_sixpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Operating systems", it_sixpapercount7+""));
                }
                if(dataSnapshot.getKey().equals("JP")) {
                    it_sixpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Java programming", it_sixpapercount8+""));
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
                    Intent intent=new Intent(It_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/CM");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/IU");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/JP");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/LI");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/MY");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/NN");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/OS");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(It_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/05/WD");
                    startActivity(intent);
                    Toast.makeText(It_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}