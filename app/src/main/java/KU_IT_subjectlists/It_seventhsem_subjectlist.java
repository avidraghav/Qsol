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

public class It_seventhsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int it_sevenpapercount1,it_sevenpapercount2,it_sevenpapercount3,it_sevenpapercount4,it_sevenpapercount5,it_sevenpapercount6;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_seventhsem_subjectlist);

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
        globalClass.setSemester("07");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/IT/07");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AL")) {
                    it_sevenpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Artificial intelligence ", it_sevenpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("BC")) {
                    it_sevenpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Broadband communication", it_sevenpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CD")) {
                    it_sevenpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Compiler design", it_sevenpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("EC")) {
                    it_sevenpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("E commerce", it_sevenpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("LS")) {
                    it_sevenpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Linux for security applications", it_sevenpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("FE")) {
                    it_sevenpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fundamentals of entrepreneurship \n", it_sevenpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("A9")) {
                    it_sevenpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced computer networks", it_sevenpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("SP")) {
                    it_sevenpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software project management", it_sevenpapercount6+""));
                }

                Listadapter adapter = new Listadapter(It_seventhsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(It_seventhsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/A9");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/AL");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/BC");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/CD");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/EC");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/FE");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/LS");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(It_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/IT/07/SP");
                    startActivity(intent);
                    Toast.makeText(It_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
