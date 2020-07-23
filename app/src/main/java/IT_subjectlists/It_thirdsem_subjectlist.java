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

public class It_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int it_sixpapercount1,it_sixpapercount2,it_sixpapercount3,it_sixpapercount4,it_sixpapercount5;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_thirdsem_subjectlist);
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
        globalClass.setSemester(3);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/IT/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("DM")) {
                    it_sixpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Database management system", it_sixpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DS")) {
                    it_sixpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data structures", it_sixpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("IF")) {
                    it_sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Internet Fundamental", it_sixpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("DE")) {
                    it_sixpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", it_sixpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("DC")) {
                    it_sixpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Discrete structure", it_sixpapercount5+""));
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
                    Intent intent=new Intent(It_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/03/DC");
                    startActivity(intent);
                    Toast.makeText(It_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(It_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/03/DE");
                    startActivity(intent);
                    Toast.makeText(It_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(It_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/03/DM");
                    startActivity(intent);
                    Toast.makeText(It_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(It_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/03/DS");
                    startActivity(intent);
                    Toast.makeText(It_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(It_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/03/IF");
                    startActivity(intent);
                    Toast.makeText(It_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}