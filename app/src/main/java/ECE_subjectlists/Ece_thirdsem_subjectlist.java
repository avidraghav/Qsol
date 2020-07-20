package ECE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
import ELE_subjectlists.Ele_eightsem_subjectlist;

public class Ece_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_eightpapercount1,el_eightpapercount2,el_eightpapercount3;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_thirdsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        subjectlist = new ArrayList<>();

        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("EC");
        globalClass.setSemester(3);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/EC/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("ER")) {
                    el_eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital electronics", el_eightpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DE")) {
                    el_eightpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Semiconductor devices and circuits", el_eightpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("SN")) {
                    el_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Semiconductor devices and circuits", el_eightpapercount2+""));

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
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/DE");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/ER");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Ece_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/EC/03/SN");
                    startActivity(intent);
                }
               
            }
        });
    }
}
