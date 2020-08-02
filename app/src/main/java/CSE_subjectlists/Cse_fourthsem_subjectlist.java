package CSE_subjectlists;

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

public class Cse_fourthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;

    static int fourpapercount1,fourpapercount2,fourpapercount3,fourpapercount4,fourpapercount5,fourpapercount6,fourpapercount7;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_fourthsem_subjectlist);

        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("CSE");
        globalClass.setSemester(4);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CA")) {
                    fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer architecture and organisation", fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("IF")) {
                    fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Internet Fundamental", fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("MI")) {
                    fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microprocessor and interfacing", fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("OP")) {
                    fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Object oriented programming", fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("OS")) {
                    fourpapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Operating systems", fourpapercount5+""));
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    fourpapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming language", fourpapercount6+""));
                }
                if(dataSnapshot.getKey().equals("DD")) {
                    fourpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital data communication", fourpapercount7+""));
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
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/CA");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/IF");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/MI");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/OP");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/OS");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/PL");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Cse_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/04/DD");
                    startActivity(intent);
                    Toast.makeText(Cse_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
               
            }
        });



    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
