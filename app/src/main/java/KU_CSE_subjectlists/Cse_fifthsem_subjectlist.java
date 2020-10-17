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

public class Cse_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int fivepapercount1,fivepapercount2,fivepapercount3,fivepapercount4,fivepapercount5,fivepapercount6;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_fifthsem_subjectlist);
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
        globalClass.setSemester("05");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AT")) {
                    fivepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Formal Language and automata theory", fivepapercount1+""));
                }
                if(dataSnapshot.getKey().equals("EO")) {
                    fivepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Essentials of information technology", fivepapercount2+""));
                }
                if(dataSnapshot.getKey().equals("DM")) {
                    fivepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Database management system", fivepapercount3+""));
                }
                if(dataSnapshot.getKey().equals("CO")) {
                    fivepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer organisation and architecture", fivepapercount4+""));
                }
                if(dataSnapshot.getKey().equals("MS")) {
                    fivepapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Microprocessors and interfacing", fivepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("SS")) {
                    fivepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Signals and systems", fivepapercount6+""));
                }
//

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
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/AT");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/CO");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/DM");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/EO");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/MS");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cse_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/05/SS");
                    startActivity(intent);
                    Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
//
            }
        });


    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
