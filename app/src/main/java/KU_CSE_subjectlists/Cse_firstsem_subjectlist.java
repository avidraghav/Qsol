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

import Adapters.Listadapter;

public class Cse_firstsem_subjectlist extends AppCompatActivity {
 ListView listview;
 List<Listdata> subjectlist;
 Button downloadall;
 TextView subjectname;
 TextView papercount;
TextView textView;
static String semester;
String key;

 static int onepapercount1,onepapercount2,onepapercount3,onepapercount4,onepapercount5,onepapercount6,onepapercount7,onepapercount8,onepapercount9,onepapercount10,onepapercount11,onepapercount12,onepapercount13,onepapercount14,onepapercount15,onepapercount16,onepapercount17;
 DatabaseReference ref;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_firstsem_subjectlist);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        listview=findViewById(R.id.list);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

         semester=textView.getText().toString();

         GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBoard("KU");
        globalClass.setBranch("CS");
        globalClass.setSemester("01");


        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
//
                if(dataSnapshot.getKey().equals("BI")) {
                    onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Biology", onepapercount4+""));

                }
//
                if(dataSnapshot.getKey().equals("CU")) {
                    onepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Calculus and linear algebra", onepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("CH")) {
                    onepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Chemistry", onepapercount7+""));
                }

                if(dataSnapshot.getKey().equals("EE")) {
                    onepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electrical engineering", onepapercount8+""));
                }
//

                if(dataSnapshot.getKey().equals("ED")) {
                    onepapercount10=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Engineering drawing", onepapercount10+""));
                }
                if(dataSnapshot.getKey().equals("EH")) {
                    onepapercount11 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("English", onepapercount11+""));
                }
//

                if(dataSnapshot.getKey().equals("PP")) {
                    onepapercount16 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming for problem solving", onepapercount16+""));
                }
                if(dataSnapshot.getKey().equals("SH")) {
                    onepapercount17 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Semiconductor physics", onepapercount17+""));
                }

                Listadapter adapter = new Listadapter(getBaseContext(), R.layout.row, subjectlist);
                listview.setAdapter(adapter);

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

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/BI");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/CH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/CU");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/ED");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/EE");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/EH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/PP");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Cse_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/01/SH");
                    startActivity(intent);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }


            }
        });






    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
