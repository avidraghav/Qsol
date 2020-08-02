package ME_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class Me_eightsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int me_eightpapercount1, me_eightpapercount2, me_eightpapercount3, me_eightpapercount4, me_eightpapercount5, me_eightpapercount6, me_eightpapercount7;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_eightsem_subjectlist);
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
        globalClass.setBranch("ME");
        globalClass.setSemester(7);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/ME/08");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("EP")) {
                    me_eightpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Entrepreneurship", me_eightpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("MM")) {
                    me_eightpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Management information system", me_eightpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("NG")) {
                    me_eightpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Non conventional manufacturing", me_eightpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("OR")) {
                    me_eightpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Operation research", me_eightpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("PI")) {
                    me_eightpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Powerplant engineering", me_eightpapercount5+""));

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
                    Intent intent=new Intent(Me_eightsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/08/EP");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Me_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/08/MM");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Me_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/08/NG");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Me_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/08/OR");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Me_eightsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/08/PI");
                    startActivity(intent);
                }

            }
        });
    }
}
