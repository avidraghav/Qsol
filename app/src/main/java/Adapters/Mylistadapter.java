package Adapters;


import android.app.DownloadManager;
import android.content.Context;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.application.kurukshetrauniversitypapers.GlobalClass;
import com.application.kurukshetrauniversitypapers.Listdata;
import com.application.kurukshetrauniversitypapers.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import com.google.firebase.storage.StorageReference;

import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Mylistadapter extends ArrayAdapter<Listdata> {

    List<Listdata> subjectlist;
    Context context;
    int resource;
    StorageReference storageReference,myref;
    FirebaseStorage firebaseStorage;
    DatabaseReference rootref;
    FirebaseAuth mAuth;


    public Mylistadapter(Context context, int resource, List<Listdata> subjectlist) {
        super(context, resource, subjectlist);
        this.context = context;
        this.resource = resource;
        this.subjectlist = subjectlist;
    }




    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        final TextView subjectname = view.findViewById(R.id.subjectname);
        final TextView papercount = view.findViewById(R.id.papercount);
        final Button downloadall = view.findViewById(R.id.download_btn);

        Listdata listdata = subjectlist.get(position);
        subjectname.setText(listdata.getSubjectname());
        papercount.setText(listdata.getPapercount());

        mAuth=FirebaseAuth.getInstance();

        downloadall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                GlobalClass globalClass=new GlobalClass();

                    if (subjectname.getText() == ("Applied chemistry")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/AC");
                        else {
                            download("IN/KU/CS/02/AC");
                        }
                    }
                    if (subjectname.getText() == ("Applied mathematics")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/AM");
                        else {
                            download("IN/KU/CS/02/AM");
                        }
                    }
                    if (subjectname.getText() == ("Applied Physics")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/AP");
                        else {
                            download("IN/KU/CS/02/AP");
                        }
                    }
                    if (subjectname.getText() == ("Biology")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/BI");
                        else
                            download("IN/KU/CS/02/BI");
                    }
                    if (subjectname.getText() == ("Biotechnology")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/BT");
                        else {
                            download("IN/KU/CS/02/BT");
                        }
                    }
                    if (subjectname.getText() == ("Calculus and linear algebra")) {
                        toast();
                        download("IN/KU/CS/01/CU");
                    }
                    if (subjectname.getText() == ("Chemistry")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/CH");
                        else {
                            download("IN/KU/CS/02/AP");
                        }
                    }
                    if (subjectname.getText() == ("Electrical engineering")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/EE");
                        else {
                            download("IN/KU/CS/02/EE");
                        }
                    }
                    if (subjectname.getText() == ("Electrical technology")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/ET");
                        else {
                            download("IN/KU/CS/02/ET");
                        }
                    }
                    if (subjectname.getText() == ("Engineering drawing")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/ED");
                        else {
                            download("IN/KU/CS/02/ED");
                        }
                    }
                    if (subjectname.getText() == ("English")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE")) {
                            if (globalClass.getSemester() == 1)
                                download("IN/KU/CS/01/EH");
                            else {
                                download("IN/KU/CS/02/EH");
                            }
                        }
                        else if(globalClass.getBranch().equals("BCA"))
                                download("IN/KU/BC/01/EH");
                    }
                    if (subjectname.getText() == ("Fundamentals of computer programming")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/FP");
                        else {
                            download("IN/KU/CS/02/FP");
                        }
                    }

                if (subjectname.getText() == ("Mathematics 3")) {
                    toast();
                    if(globalClass.getBranch().equals("CSE")) {
                        download("IN/KU/CS/03/M3");
                    }
                    if(globalClass.getBranch().equals("ME"))
                        download("IN/KU/ME/03/M3");
                    if(globalClass.getBranch().equals("IT"))
                        download("IN/KU/IT/03/M3");
                }
                    if (subjectname.getText() == ("Mathematics")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE")) {
                            if (globalClass.getSemester() == 1)
                                download("IN/KU/CS/01/MA");
                            else {
                                download("IN/KU/CS/02/MA");
                            }
                        }
                        else
                            download("IN/KU/BC/01/MA");
                    }
                    if (subjectname.getText() == ("Multivariable calculus and linear algebra")) {
                        toast();
                        download("IN/KU/CS/01/MA");
                    }
                    if (subjectname.getText() == ("Physics")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/PH");
                        else
                            download("IN/KU/CS/02/PH");
                    }
                    if (subjectname.getText() == ("Programming for problem solving")) {
                        toast();
                        if (globalClass.getSemester() == 1)
                            download("IN/KU/CS/01/PP");
                        else
                            download("IN/KU/CS/02/PP");
                    }
                    if (subjectname.getText() == ("Semiconductor physics")) {
                        toast();
                        download("IN/KU/CS/01/PH");
                    }
                if (subjectname.getText() == ("Business intelligence and entrepreneurship")) {
                    toast();
                    download("IN/KU/CS/03/BG");
                }
                    if (subjectname.getText() == ("Calculus and ordinary differential equation")) {
                        toast();
                        download("IN/KU/CS/02/CL");
                    }
                    if (subjectname.getText() == ("Electrical technology fundamentals")) {
                        toast();
                        download("IN/KU/CS/02/EF");
                    }
                    if (subjectname.getText() == ("Probability and statistics")) {
                        toast();
                        download("IN/KU/CS/02/PS");
                    }
                    if (subjectname.getText() == ("Discrete structure")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE"))
                        download("IN/KU/CS/03/DC");
                        else
                            download("IN/KU/IT/03/DC");
                    }
                    if (subjectname.getText() == ("Database management system")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE")) {
                            if(globalClass.getSemester()==1)
                            download("IN/KU/CS/01/DM");
                            if(globalClass.getSemester()==5)
                                download("IN/KU/CS/05/DM");
                        }
                        if(globalClass.getBranch().equals("IT"))
                        {
                            download("IN/KU/IT/03/DM");
                        }
                            if(globalClass.getBranch().equals("MC"))
                                download("IN/KU/MC/03/DM");

                    }
                    if (subjectname.getText() == ("Data structures and algorithms")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 4)
                            download("IN/KU/CS/01/DT");
                        if (globalClass.getBranch().equals("ECE") && globalClass.getSemester() == 4)
                            download("IN/KU/EC/04/DT");
                    }
                    if (subjectname.getText() == ("Data structures")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE")) {
                            if(globalClass.getSemester()==1)
                            download("IN/KU/CS/01/DS");
                            else
                            download("IN/KU/MC/02/DS");
                        }
                        else download("IN/KU/IT/03/DS");

                    }
                    if (subjectname.getText() == ("Digital electronics")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 4)
                            download("IN/KU/CS/01/DE");
                        if (globalClass.getBranch().equals("ECE") && globalClass.getSemester() == 4)
                            download("IN/KU/EC/04/DE");
                        if (globalClass.getBranch().equals("ECE") && globalClass.getSemester() == 3)
                            download("IN/KU/EC/03/DE");
                        if (globalClass.getBranch().equals("ELE") && globalClass.getSemester() == 4)
                            download("IN/KU/El/04/DE");
                        if(globalClass.getBranch().equals("IT"))
                            download("IN/KU/IT/03/DE");
                    }
                    if (subjectname.getText() == ("Internet Fundamental")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE")) {
                            if(globalClass.getSemester()==3)
                            download("IN/KU/CS/03/IF");
                            else
                            download("IN/KU/CS/04/IF");
                        }
                        if (globalClass.getBranch().equals("ELE") && globalClass.getSemester() == 8)
                            download("IN/KU/EL/08/IF");
                        if(globalClass.getBranch().equals("IT"))
                            download("IN/KU/IT/03/IF");
                    }

                    if(subjectname.getText() == ("Linux operating system"))
                        download("IN/KU/IT/05/LI");
                if(subjectname.getText() == ("Introduction to digital data communication"))
                    download("IN/KU/IT/05/IU");
                if(subjectname.getText() == ("Multimedia and virtual reality"))
                    download("IN/KU/IT/05/MY");
                    if (subjectname.getText() == ("Programming language")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 3)
                            download("IN/KU/CS/03/PL");
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 4)
                            download("IN/KU/CS/04/PL");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 4)
                            download("IN/KU/IT/04/PL");
                    }
                    if (subjectname.getText() == ("Object oriented programming")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 3)
                            download("IN/KU/CS/03/OP");
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 4)
                            download("IN/KU/CS/04/OP");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 3)
                            download("IN/KU/IT/03/OP");
                        if (globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/02/OP");
                    }
                    if (subjectname.getText() == ("Computer architecture and organisation")) {
                        toast();
                        if (globalClass.getSemester() == 4 && globalClass.getBranch().equals("CSE"))
                            download("IN/KU/CS/04/CA");
                        if (globalClass.getSemester() == 4 && globalClass.getBranch().equals("ECE"))
                            download("IN/KU/EC/04/CA");

                    }
                    if (subjectname.getText() == ("Microprocessors and interfacing")) {
                        toast();
                        if (globalClass.getSemester() == 4 && globalClass.getBranch().equals("CSE"))
                            download("IN/KU/CS/04/MS");
                        if (globalClass.getSemester() == 6 && globalClass.getBranch().equals("ELE"))
                            download("IN/KU/EL/06/MS");
                        if(globalClass.getBranch().equals("ECE")){
                            if(globalClass.getSemester()==4)
                                download("IN/KU/EC/04/MS");
                            if(globalClass.getSemester()==5)
                                download("IN/KU/EL/05/MS");
                        }
                    }
                    if (subjectname.getText() == ("Digital data communication")) {
                        toast();
                        download("IN/KU/CS/04/DD");
                    }
                    if (subjectname.getText() == ("Operating systems")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 4)
                            download("IN/KU/CS/04/OS");
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 5)
                            download("IN/KU/CS/05/OS");
                        if (globalClass.getBranch().equals("IT")) {
                            if (globalClass.getSemester() == 4)
                                download("IN/KU/IT/04/OS");
                            else
                                download("IN/KU/IT/05/OS");
                        }
                    }
                    if (subjectname.getText() == ("Formal Language and automata theory")) {
                        toast();
                        download("IN/KU/CS/05/AT");
                    }
                    if (subjectname.getText() == ("Computer networks")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 5)
                            download("IN/KU/CS/05/CN");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 6)
                            download("IN/KU/IT/06/CN");
                    }
                    if (subjectname.getText() == ("Computer organisation and architecture")) {
                        toast();
                        if (globalClass.getSemester() == 5 && globalClass.getBranch().equals("CSE"))
                            download("IN/KU/CS/05/CO");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 4)
                            download("IN/KU/IT/04/CO");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 5)
                            download("IN/KU/IT/05/CO");
                        if (globalClass.getBranch().equals("EC") && globalClass.getSemester() == 5)
                            download("IN/KU/EC/05/CO");
                    }
                    if (subjectname.getText() == ("Design and analysis of algorithm")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 5)
                            download("IN/KU/CS/05/DA");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 6)
                            download("IN/KU/IT/05/DA");
                        if(globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/03/DA");

                    }
                    if (subjectname.getText() == ("Simulation and modelling")) {
                        toast();
                        download("IN/KU/CS/05/SA");
                    }
                    if (subjectname.getText() == ("Essentials of information technology")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE"))
                        {
                            if (globalClass.getSemester() == 5)
                                download("IN/KU/CS/05/EO");
                            else
                                download("IN/KU/CS/06/EO");
                        }
                        else if(globalClass.getBranch().equals("ECE"))
                            download("IN/KU/EC/03/EO");
                    }
                    if (subjectname.getText() == ("Advanced database systems")) {
                        toast();
                        download("IN/KU/CS/06/AD");
                    }
                    if (subjectname.getText() == ("Computer hardware technologies")) {
                        toast();
                        download("IN/KU/CS/06/CT");
                    }
                    if (subjectname.getText() == ("Mobile computing")) {
                        toast();
                        download("IN/KU/CS/06/MC");
                    }
                    if (subjectname.getText() == ("Network management and security")) {
                        toast();
                        download("IN/KU/CS/06/NM");
                    }
                    if (subjectname.getText() == ("Software engineering")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 6)
                            download("IN/KU/CS/06/SE");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 6)
                            download("IN/KU/IT/06/SE");
                        if(globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/01/SE");
                    }
                    if (subjectname.getText() == ("Compiler design")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 6)
                            download("IN/KU/CS/06/CD");
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 7)
                            download("IN/KU/CS/07/CD");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 7)
                            download("IN/KU/IT/07/CD");
                        if(globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/05/CD");
                    }
                    if (subjectname.getText() == ("Web engineering")) {
                        toast();
                        if (globalClass.getSemester() == 6)
                            download("IN/KU/CS/06/WE");
                        else
                            download("IN/KU/CS/07/WE");
                    }
                    if (subjectname.getText() == ("Computer graphics and animation")) {
                        toast();
                        download("IN/KU/CS/07/CG");
                    }
                    if (subjectname.getText() == ("Cryptography and information security")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 7)
                            download("IN/KU/CS/07/CI");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 8)
                            download("IN/KU/IT/08/CI");
                    }
                    if (subjectname.getText() == ("Expert systems")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 7)
                            download("IN/KU/CS/07/ES");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 8)
                            download("IN/KU/IT/08/ES");
                    }
                    if (subjectname.getText() == ("Security and cryptography")) {
                        toast();
                        download("IN/KU/CS/07/SC");
                    }
                    if (subjectname.getText() == ("Software project management")) {
                        toast();
                        download("IN/KU/CS/07/SP");
                    }
                    if (subjectname.getText() == ("Statistical models for computer science")) {
                        toast();
                        download("IN/KU/CS/07/SM");
                    }
                    if (subjectname.getText() == ("Unix and Linux prog")) {
                        toast();
                        download("IN/KU/CS/07/UL");
                    }
                    if (subjectname.getText() == ("Cloud computing")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 8)
                            download("IN/KU/CS/08/CC");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 8)
                            download("IN/KU/IT/08/CC");
                        if(globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/05/CC");
                    }
                    if (subjectname.getText() == ("Data warehouse and data mining")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 8)
                            download("IN/KU/CS/08/DW");
                        if (globalClass.getBranch().equals("IT")) {
                            if(globalClass.getSemester()==8)
                            download("IN/KU/IT/08/DW");
                            else
                            download("IN/KU/IT/06/DW");
                        }
                        if(globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/04/DW");
                    }
                    if (subjectname.getText() == ("Interactive computer graphics")) {
                        toast();
                        download("IN/KU/CS/08/IC");
                    }
                    if (subjectname.getText() == ("Mobile apps development")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE"))
                        download("IN/KU/CS/08/MD");
                        else
                            download("IN/KU/MC/05/MD");
                    }
                    if (subjectname.getText() == ("Neural network and fuzzy lose")) {
                        toast();
                        download("IN/KU/CS/08/NO");
                    }
                    if (subjectname.getText() == ("Neural network and fuzzy logic")) {
                        download("IN/KU/CS/08/NL");
                    }
                    if (subjectname.getText() == ("Software testing")) {
                        toast();
                        download("IN/KU/CS/08/ST");
                    }
                    if (subjectname.getText() == ("Software verification validation and testing")) {
                        toast();
                        download("IN/KU/CS/08/SV");
                    }
                    //ECE SUBJECTS
                    if (subjectname.getText() == ("Analog Electronics")) {
                        toast();
                        download("IN/KU/EC/04/AN");
                    }
                    if (subjectname.getText() == ("Electromagnetic theory")) {
                        toast();
                        download("IN/KU/EC/04/EY");
                    }
                if (subjectname.getText() == ("Electronic devices")) {
                    toast();
                    download("IN/KU/EC/03/ER");
                }
                if (subjectname.getText() == ("Semiconductor devices and circuits")) {
                    toast();
                    download("IN/KU/EC/03/SN");
                }
                    if (subjectname.getText() == ("Electronic measurements and instruments")) {
                        toast();
                        if (globalClass.getBranch().equals("ECE") && globalClass.getSemester() == 4)
                            download("IN/KU/EC/04/EM");
                        if (globalClass.getBranch().equals("ELE") && globalClass.getSemester() == 4)
                            download("IN/KU/El/04/EM");
                    }
                    if (subjectname.getText() == ("Field and waves")) {
                        toast();
                        download("IN/KU/EC/04/FW");
                    }
                    if (subjectname.getText() == ("Transducer and their applications")) {
                        toast();
                        if (globalClass.getSemester() == 4)
                            download("IN/KU/EC/04/TA");
                        if (globalClass.getSemester() == 8)
                            download("IN/KU/EC/08/TA");
                        if (globalClass.getBranch().equals("ELE") && globalClass.getSemester() == 7)
                            download("IN/KU/El/07/TA");
                    }
                    if (subjectname.getText() == ("Computer communication network")) {
                        toast();
                        download("IN/KU/EC/06/CE");
                    }
                    if (subjectname.getText() == ("Control system engineering")) {
                        toast();
                        download("IN/KU/EC/06/CS");
                    }
                    if (subjectname.getText() == ("Digital communication")) {
                        toast();
                        download("IN/KU/EC/06/DO");
                    }
                if (subjectname.getText() == ("Electromagnetic waves")) {
                    toast();
                    download("IN/KU/EC/05/EW");
                }
                if (subjectname.getText() == ("Information theory and coding")) {
                    toast();
                    download("IN/KU/EC/05/II");
                }
                    if (subjectname.getText() == ("Digital design using verilog")) {
                        toast();
                        download("IN/KU/EC/06/DI");
                    }
                    if (subjectname.getText() == ("Digital signal processing")) {
                        toast();
                        if (globalClass.getBranch().equals("ECE")) {
                            if (globalClass.getSemester() == 6)
                                download("IN/KU/EC/06/DP");
                            if (globalClass.getSemester() == 5)
                                download("IN/KU/EC/05/DP");
                        }
                        if (globalClass.getBranch().equals("ELE") && globalClass.getSemester() == 6)
                            download("IN/KU/EL/06/DP");
                    }
                    if (subjectname.getText() == ("Vhdl and digital systems")) {
                        toast();
                        download("IN/KU/EC/06/VD");
                    }
                    if (subjectname.getText() == ("Optical communication")) {
                        toast();
                        download("IN/KU/EC/07/OC");
                    }
                    if (subjectname.getText() == ("Reliability")) {
                        toast();
                        download("IN/KU/EC/07/RE");
                    }
                    if (subjectname.getText() == ("Television engineering")) {
                        toast();
                        download("IN/KU/EC/07/TE");
                    }
                    if (subjectname.getText() == ("Artificial intelligence and expert systems")) {
                        toast();
                        download("IN/KU/EC/07/AI");
                    }
                    if (subjectname.getText() == ("Microwave engineering")) {
                        toast();
                        download("IN/KU/EC/07/ME");
                    }
                if (subjectname.getText() == ("Thermodynamics")) {
                    toast();
                    download("IN/KU/ME/03/TD");
                }
                if (subjectname.getText() == ("Theory of machines")) {
                    toast();
                    download("IN/KU/ME/03/TM");
                }
                if (subjectname.getText() == ("Basic electronics engineering")) {
                    toast();
                    download("IN/KU/ME/03/BF");
                }
                if (subjectname.getText() == ("Optics and waves")) {
                    toast();
                    if(globalClass.getBranch().equals("ME"))
                    download("IN/KU/ME/03/OW");
                    if(globalClass.getBranch().equals("ECE"))
                        download("IN/KU/EC/03/OW");
                }
                if (subjectname.getText() == ("Kinematics of machine")) {
                    toast();
                    download("IN/KU/ME/03/KM");
                }
                if (subjectname.getText() == ("Basics of economics and management")) {
                    toast();
                    download("IN/KU/ME/03/BZ");
                }
                if (subjectname.getText() == ("IC engine and gas turbine")) {
                    toast();
                    download("IN/KU/ME/05/GE");
                }
                if (subjectname.getText() == ("Heat transfer")) {
                    toast();
                    download("IN/KU/ME/05/HT");
                }
                if (subjectname.getText() == ("Industrial engineering")) {
                    toast();
                    download("IN/KU/ME/05/IE");
                }
                    if (subjectname.getText() == ("VLSI design")) {
                        toast();
                        download("IN/KU/EC/07/VL");
                    }

                    if (subjectname.getText() == ("Embedded system design")) {
                        toast();
                        if (globalClass.getBranch().equals("CSE") && globalClass.getSemester() == 8)
                            download("IN/KU/EC/08/EI");
                        if (globalClass.getBranch().equals("IT") && globalClass.getSemester() == 8)
                            download("IN/KU/IT/08/EI");
                    }
                    if (subjectname.getText() == ("Radar engineering")) {
                        toast();
                        download("IN/KU/EC/08/RA");
                    }
                    if (subjectname.getText() == ("Multimedia communication")) {
                        toast();
                        download("IN/KU/EC/08/MU");
                    }
                    if (subjectname.getText() == ("Wireless and mobile communication")) {
                        toast();
                        download("IN/KU/EC/08/WI");
                    }
                    //IT SUBJECTS
                    if (subjectname.getText() == ("Fundamentals of up interfacing")) {
                        toast();
                        download("IN/KU/IT/04/FI");
                    }
                    if (subjectname.getText() == ("Fundamentals of microprocessor interfacing and application")) {
                        toast();
                        download("IN/KU/IT/04/FR");
                    }
                    if (subjectname.getText() == ("Fundamentals of entrepreneurship")) {
                        toast();
                        download("IN/KU/IT/07/FE");
                    }
                    if (subjectname.getText() == ("Advance database system")) {
                        toast();
                        download("IN/KU/IT/08/AV");
                    }
                    if (subjectname.getText() == ("Information security")) {
                        toast();
                        download("IN/KU/IT/08/IS");
                    }
                    if (subjectname.getText() == ("Computer graphics")) {
                        toast();
                        if (globalClass.getBranch().equals("IT")) {
                            if (globalClass.getSemester() == 6)
                                download("IN/KU/IT/06/CM");
                            else download("IN/KU/IT/05/CM");
                        }
                        if(globalClass.getBranch().equals("MCA")) {
                            if(globalClass.getSemester()==4)
                            download("IN/KU/MC/04/CM");
                            else
                                download("IN/KU/MC/05/CM");
                        }
                    }
                if (subjectname.getText() == ("Web design")) {
                    toast();
                        download("IN/KU/IT/05/WD");
                }
                if (subjectname.getText() == ("Network programming")) {
                    toast();
                    download("IN/KU/IT/05/NN");
                }
                if (subjectname.getText() == ("Java programming")) {
                    toast();
                    download("IN/KU/IT/05/JP");
                }
                if (subjectname.getText() == ("Fundamentals of management")) {
                    toast();
                    download("IN/KU/IT/03/FN");
                }
                    if (subjectname.getText() == ("Management information system")) {
                        toast();
                        if (globalClass.getBranch().equals("IT"))
                            download("IN/KU/IT/06/MM");
                        if (globalClass.getBranch().equals("ME"))
                            download("IN/KU/ME/08/MM");
                    }
                    if (subjectname.getText() == ("Introduction to microcontroller")) {
                        toast();
                        download("IN/KU/IT/06/IM");
                    }
                    if (subjectname.getText() == ("Artificial intelligence")) {
                        toast();
                        if(globalClass.getBranch().equals("IT"))
                        download("IN/KU/IT/07/AL");
                        else
                            download("IN/KU/MC/04/AL");
                    }
                    if (subjectname.getText() == ("Broadband communication")) {
                        toast();
                        download("IN/KU/IT/07/BC");
                    }
                    if (subjectname.getText() == ("E commerce")) {
                        toast();
                        download("IN/KU/IT/07/EC");
                    }
                    if (subjectname.getText() == ("Linux for security applications")) {
                        toast();
                        download("IN/KU/IT/07/LS");
                    }
                    if (subjectname.getText() == ("Advance computer network and applications")) {
                        toast();
                        download("IN/KU/IT/08/AA");
                    }
                    if (subjectname.getText() == ("Mobile communication")) {
                        toast();
                        download("IN/KU/IT/08/MB");
                    }
                    if (subjectname.getText() == ("Information technology applications")) {
                        toast();
                        download("IN/KU/IT/08/IO");
                    }
                    // ELE subjects
                    if (subjectname.getText() == ("Communication system")) {
                        toast();
                        download("IN/KU/EL/04/CY");
                    }
                    if (subjectname.getText() == ("Electrical engineering material and processes")) {
                        toast();
                        if (globalClass.getSemester() == 4)
                            download("IN/KU/EL/04/EG");
                        if (globalClass.getSemester() == 8)
                            download("IN/KU/EL/08/EG");
                    }
                    if (subjectname.getText() == ("Electrical machines")) {
                        toast();
                        download("IN/KU/EL/04/EA");
                    }
                    if (subjectname.getText() == ("Power generation and control")) {
                        toast();
                        download("IN/KU/EL/04/PG");
                    }
                    if (subjectname.getText() == ("Signals and systems")) {
                        toast();
                        if(globalClass.getBranch().equals("CSE"))
                            download("IN/KU/CS/05/SS");
                        if(globalClass.getBranch().equals("ECE"))
                        download("IN/KU/EC/03/SS");
                    }
                    if (subjectname.getText() == ("Advanced programming")) {
                        toast();
                        download("IN/KU/EL/06/AE");
                    }
                    if (subjectname.getText() == ("Electrical drives and traction")) {
                        toast();
                        download("IN/KU/EL/06/EN");
                    }
                    if (subjectname.getText() == ("Microcontrollers and applications")) {
                        toast();
                        download("IN/KU/EL/06/EN");
                    }
                    if (subjectname.getText() == ("Power electronics")) {
                        toast();
                        download("IN/KU/EL/06/PE");
                    }
                    if (subjectname.getText() == ("Power system analysis and protection")) {
                        toast();
                        download("IN/KU/EL/06/PN");
                    }
                    if (subjectname.getText() == ("Discrete data non linear control system")) {
                        toast();
                        download("IN/KU/EL/07/DN");
                    }
                    if (subjectname.getText() == ("Electrical machine design")) {
                        toast();
                        download("IN/KU/EL/07/EZ");
                    }
                    if (subjectname.getText() == ("Non conventional sources of energy and management")) {
                        toast();
                        download("IN/KU/EL/07/NC");
                    }
                    if (subjectname.getText() == ("High voltage engineering")) {
                        toast();
                        download("IN/KU/EL/07/HV");
                    }
                    if (subjectname.getText() == ("Computer methods in power systems")) {
                        toast();
                        download("IN/KU/EL/08/CP");
                    }
                    if (subjectname.getText() == ("Electrical engineering material and processes")) {
                        toast();
                        download("IN/KU/EL/08/EG");
                    }
                    if (subjectname.getText() == ("Operation research")) {
                        toast();
                        if (globalClass.getBranch().equals("ELE"))
                            download("IN/KU/EL/08/OR");
                        if (globalClass.getBranch().equals("ME") && globalClass.getSemester() == 6)
                            download("IN/KU/ME/06/OR");
                        if (globalClass.getBranch().equals("ME") && globalClass.getSemester() == 8)
                            download("IN/KU/ME/08/OR");
                        if(globalClass.getBranch().equals("MCA"))
                            download("IN/KU/MC/03/OR");

                    }
                    if (subjectname.getText() == ("Utilisation of electrical energy")) {
                        toast();
                        download("IN/KU/EL/08/UT");
                    }
                    // ME SUBJECTS
                    if (subjectname.getText() == ("Dynamics of machine")) {
                        toast();
                        download("IN/KU/ME/04/DY");
                    }
                    if (subjectname.getText() == ("Fluid mechanics")) {
                        toast();
                        if(globalClass.getSemester()==4)
                        download("IN/KU/ME/04/FM");
                        else download("IN/KU/ME/05/FM");
                    }

                    if (subjectname.getText() == ("Material science")) {
                        toast();
                        if(globalClass.getSemester()==4)
                        download("IN/KU/ME/04/MT");
                        else
                            download("IN/KU/ME/03/MT");
                    }
                    if (subjectname.getText() == ("Mechanics of solids")) {
                        toast();
                        if(globalClass.getSemester()==4)
                        download("IN/KU/ME/04/MO");
                        else download("IN/KU/ME/03/MO");
                    }
                    if (subjectname.getText() == ("Production technology")) {
                        toast();
                        if(globalClass.getSemester()==4) download("IN/KU/ME/04/PT");
                        if(globalClass.getSemester()==3) download("IN/KU/ME/03/PT");
                        if(globalClass.getSemester()==5) download("IN/KU/ME/05/PT");
                    }
                    if (subjectname.getText() == ("Strength of materials")) {
                        toast();
                        if(globalClass.getSemester()==4)
                        download("IN/KU/ME/04/SL");
                        else download("IN/KU/ME/03/SL");
                    }
                    if (subjectname.getText() == ("Steam generator and power")) {
                        toast();
                        if(globalClass.getSemester()==4)
                        download("IN/KU/ME/04/SG");
                        else download("IN/KU/ME/05/SG");
                    }
                    if (subjectname.getText() == ("Computer aided design and manufacturing")) {
                        toast();
                        download("IN/KU/ME/07/CF");
                    }
                    if (subjectname.getText() == ("Machine design")) {
                        toast();
                        if(globalClass.getSemester()==6)
                        download("IN/KU/ME/06/MN");
                        if(globalClass.getSemester()==3) download("IN/KU/ME/03/MN");
                        if(globalClass.getSemester()==5) download("IN/KU/ME/05/MN");
                    }
                    if (subjectname.getText() == ("Mechanical vibrations")) {
                        toast();
                        download("IN/KU/ME/06/MV");
                    }
                    if (subjectname.getText() == ("Refrigeration and air conditioning")) {
                        toast();
                        download("IN/KU/ME/06/RC");
                    }
                    if (subjectname.getText() == ("Tribology")) {
                        toast();
                        download("IN/KU/ME/06/TY");
                    }

                    if (subjectname.getText() == ("Tribology and mechanical vibration")) {
                        toast();
                        download("IN/KU/ME/05/TV");
                    }
                    if (subjectname.getText() == ("Advanced manufacturing tech")) {
                        toast();
                        download("IN/KU/ME/07/AF");
                    }
                    if (subjectname.getText() == ("Automobile engineering ")) {
                        toast();
                        download("IN/KU/ME/07/AG");
                    }
                    if (subjectname.getText() == ("Maintenance engineering")) {
                        toast();
                        download("IN/KU/ME/07/MG");
                    }
                    if (subjectname.getText() == ("Measurement and control")) {
                        toast();
                        download("IN/KU/ME/07/MR");
                    }
                    if (subjectname.getText() == ("Statistical quality control and reliability")) {
                        toast();
                        download("IN/KU/ME/07/SQ");
                    }
                    if (subjectname.getText() == ("Entrepreneurship")) {
                        toast();
                        download("IN/KU/ME/05/EP");
                    }

                    if (subjectname.getText() == ("Non conventional manufacturing")) {
                        toast();
                        download("IN/KU/ME/08/NG");
                    }
                    if (subjectname.getText() == ("Powerplant engineering")) {
                        toast();
                        download("IN/KU/ME/07/PI");
                    }
                    // MBA subjects
                    if (subjectname.getText() == ("Principles and practices of management")) {
                        toast();
                        download("IN/KU/MB/01/PD");
                    }
                    if (subjectname.getText() == ("Business communication")) {
                        toast();
                        download("IN/KU/MB/01/BN");
                    }
                    if (subjectname.getText() == ("Business statistics")) {
                        toast();
                        if (globalClass.getBranch().equals("MBA"))
                            download("IN/KU/MB/01/BS");
                        else
                            download("IN/KU/BB/02/BS");
                    }
                    if (subjectname.getText() == ("Computer applications for business")) {
                        toast();
                        download("IN/KU/MB/01/CB");
                    }
                    if (subjectname.getText() == ("Financial accounting ")) {
                        toast();
                        download("IN/KU/MB/01/FA");
                    }
                    if (subjectname.getText() == ("Financial reporting statement and analysis ")) {
                        toast();
                        download("IN/KU/MB/01/FS");
                    }
                    if (subjectname.getText() == ("Management processes and organisational behaviour ")) {
                        toast();
                        download("IN/KU/MB/01/MQ");
                    }
                    if (subjectname.getText() == ("Statistics and analysis of decision making ")) {
                        toast();
                        download("IN/KU/MB/01/SY");
                    }
                    if (subjectname.getText() == ("Managerial economics")) {
                        toast();
                        if (globalClass.getBranch().equals("MBA"))
                            download("IN/KU/MB/01/MN");
                        if (globalClass.getBranch().equals("BBA"))
                            download("IN/KU/BB/01/MN");
                    }
                    if (subjectname.getText() == ("Business environment ")) {
                        toast();
                        download("IN/KU/MB/01/BE");
                    }
                    if (subjectname.getText() == ("Business research methodology ")) {
                        toast();
                        download("IN/KU/MB/02/BR");
                    }
                    if (subjectname.getText() == ("Financial management ")) {
                        toast();
                        if (globalClass.getBranch().equals("MBA"))
                            download("IN/KU/MB/02/FM");
                        else
                            download("IN/KU/BB/02/FM");

                    }
                    if (subjectname.getText() == ("Human resource management")) {
                        toast();
                        download("IN/KU/MB/02/HR");
                    }
                    if (subjectname.getText() == ("Management science")) {
                        toast();
                        download("IN/KU/MB/02/MH");
                    }
                    if (subjectname.getText() == ("Marketing management")) {
                        toast();
                        if (globalClass.getBranch().equals("MBA"))
                            download("IN/KU/MB/02/MK");
                        else
                            download("IN/KU/BB/02/MK");
                    }
                    if (subjectname.getText() == ("Organisational behaviour ")) {
                        toast();
                        download("IN/KU/MB/02/OB");
                    }
                    if (subjectname.getText() == ("Foreign exchange management")) {
                        toast();
                        download("IN/KU/MB/02/FX");
                    }
                    if (subjectname.getText() == ("Corporate finance ")) {
                        toast();
                        download("IN/KU/MB/02/CR");
                    }
                    if (subjectname.getText() == ("Legal environment")) {
                        toast();
                        download("IN/KU/MB/02/LE");
                    }
                    if (subjectname.getText() == ("Production and operations management")) {
                        toast();
                        download("IN/KU/MB/02/PI");
                    }
                    if (subjectname.getText() == ("Compensation management ")) {
                        toast();
                        download("IN/KU/MB/04/CV");
                    }
                    if (subjectname.getText() == ("Entrepreneurship development")) {
                        toast();
                        download("IN/KU/MB/04/EL");
                    }
                    if (subjectname.getText() == ("Industrial marketing")) {
                        toast();
                        download("IN/KU/MB/04/IL");
                    }
                    if (subjectname.getText() == ("International marketing")) {
                        toast();
                        download("IN/KU/MB/04/IT");
                    }
                    if (subjectname.getText() == ("Management of financial services ")) {
                        toast();
                        download("IN/KU/MB/04/MF");
                    }
                    if (subjectname.getText() == ("Management of training and development")) {
                        toast();
                        download("IN/KU/MB/04/MO");
                    }
                    if (subjectname.getText() == ("Marketing communication strategy")) {
                        toast();
                        download("IN/KU/MB/04/MR");
                    }
                    if (subjectname.getText() == ("Portfolio management ")) {
                        toast();
                        download("IN/KU/MB/04/PT");
                    }
                    if (subjectname.getText() == ("Principles of insurance and banking")) {
                        toast();
                        download("IN/KU/MB/04/PB");
                    }
                    if (subjectname.getText() == ("Project management")) {
                        toast();
                        download("IN/KU/MB/04/PJ");
                    }
                    if (subjectname.getText() == ("Service marketing")) {
                        toast();
                        download("IN/KU/MB/04/SG");
                    }
                    if (subjectname.getText() == ("Human resource planning and development")) {
                        toast();
                        download("IN/KU/MB/04/MX");
                    }
                    if (subjectname.getText() == ("Financial derivative ")) {
                        toast();
                        download("IN/KU/MB/04/FT");
                    }
                    if (subjectname.getText() == ("International financial management ")) {
                        toast();
                        download("IN/KU/MB/04/IA");
                    }
                    if (subjectname.getText() == ("Strategies and systems")) {
                        toast();
                        download("IN/KU/MB/04/SI");
                    }
                    if (subjectname.getText() == ("Business legislation")) {
                        toast();
                        download("IN/KU/MB/03/BL");
                    }
                    if (subjectname.getText() == ("Legal framework governing human relations")) {
                        toast();
                        download("IN/KU/MB/03/LF");
                    }
                    if (subjectname.getText() == ("Manpower development for technological change")) {
                        toast();
                        download("IN/KU/MB/03/MJ");
                    }
                    if (subjectname.getText() == ("Organisation change and intervention strategies")) {
                        toast();
                        download("IN/KU/MB/03/OI");
                    }
                    if (subjectname.getText() == ("Sales and distribution management")) {
                        toast();
                        download("IN/KU/MB/03/SD");
                    }
                    if (subjectname.getText() == ("Strategic management")) {
                        toast();
                        download("IN/KU/MB/03/SR");
                    }
                    if (subjectname.getText() == ("Working capital management")) {
                        toast();
                        download("IN/KU/MB/03/WC");
                    }

                    if (subjectname.getText() == ("Business accounting")) {
                        toast();
                        download("IN/KU/BB/01/BA");
                    }
                    if (subjectname.getText() == ("Analysis of financial statements")) {
                        toast();
                        download("IN/KU/BB/01/AY");
                    }
                    if (subjectname.getText() == ("Business mathematics")) {
                        toast();
                        download("IN/KU/BB/01/BM");
                    }
                    if (subjectname.getText() == ("Hindi")) {
                        toast();
                        download("IN/KU/BB/01/HI");
                    }
                    if (subjectname.getText() == ("Business communication")) {
                        toast();
                        download("IN/KU/BB/01/BU");
                    }
                    if (subjectname.getText() == ("Business organisation")) {
                        toast();
                        download("IN/KU/BB/01/BO");
                    }
                    if (subjectname.getText() == ("Principles of management")) {
                        toast();
                        download("IN/KU/BB/01/PM");
                    }
                    if (subjectname.getText() == ("Computer fundamentals")) {
                        toast();
                        download("IN/KU/BB/01/CF");
                    }
                    if (subjectname.getText() == ("Understanding human behaviour")) {
                        toast();
                        download("IN/KU/BB/02/UH");
                    }
                    if (subjectname.getText() == ("Fundamentals of DBMS and ORACLE")) {
                        toast();
                        download("IN/KU/BB/02/FD");
                    }
                    if (subjectname.getText() == ("Micro business environment")) {
                        toast();
                        download("IN/KU/BB/02/MT");
                    }
                    if (subjectname.getText() == ("Management accounting")) {
                        toast();
                        download("IN/KU/BB/02/MG");
                    }
                    if (subjectname.getText() == ("Human behaviour at work")) {
                        toast();
                        download("IN/KU/BB/02/HB");
                    }
                    if (subjectname.getText() == ("Understanding social behaviour")) {
                        toast();
                        download("IN/KU/BB/03/US");
                    }
                    // BCA subjects
                    if (subjectname.getText() == ("Logical organization of computer")) {
                        toast();
                        download("IN/KU/BC/01/LR");
                    }
                    if (subjectname.getText() == ("Programming in c")) {
                        toast();
                        if(globalClass.getBranch().equals("BCA"))
                        download("IN/KU/BC/01/PC");
                        else
                            download("IN/KU/MC/01/PC");
                    }
                    if (subjectname.getText() == ("Windows and pc software")) {
                        toast();
                        download("IN/KU/BC/01/WR");
                    }
                    if (subjectname.getText() == ("Advanced programming in c")) {
                        toast();
                        download("IN/KU/BC/01/AG");
                    }
                    if (subjectname.getText() == ("Office automation tools")) {
                        toast();
                        download("IN/KU/BC/01/OA");
                    }
                    if (subjectname.getText() == ("Personality development")) {
                        toast();
                        download("IN/KU/BC/01/PY");
                    }
                    if (subjectname.getText() == ("Structured system analysis and design")) {
                        toast();
                        download("IN/KU/BC/01/SX");
                    }
                    if (subjectname.getText() == ("Relational database management system")) {
                        toast();
                        download("IN/KU/BC/02/RD");
                    }
                    if (subjectname.getText() == ("Computer and programming fundamentals")) {
                        toast();
                        download("IN/KU/BC/03/CX");
                    }
                    // MCA subjects

                    if (subjectname.getText() == ("Computer organization")) {
                        toast();
                        download("IN/KU/MC/01/CZ");
                    }
                    if (subjectname.getText() == ("Discrete mathematical structures")) {
                        toast();
                        download("IN/KU/MC/01/DU");
                    }
                    if (subjectname.getText() == ("Numerical and statistical methods")) {
                        toast();
                        download("IN/KU/MC/01/NS");
                    }
                    if (subjectname.getText() == ("Web technology")) {
                        toast();
                        download("IN/KU/MC/02/WT");
                    }
                    if (subjectname.getText() == ("System programming")) {
                        toast();
                        download("IN/KU/MC/02/SO");
                    }
                    if (subjectname.getText() == ("Principles of programming language"))
                    if (subjectname.getText() == ("Computer networks and data communication")) {
                        toast();
                        download("IN/KU/MC/03/CW");
                    }
                    if (subjectname.getText() == ("Object oriented design using uml")) {
                        toast();
                        download("IN/KU/MC/03/OU");
                    }
                    if (subjectname.getText() == ("Visual programming")) {
                        toast();
                        download("IN/KU/MC/03/VP");
                    }
                    if (subjectname.getText() == ("Advanced computer architecture")) {
                        toast();
                        download("IN/KU/MC/04/AH");
                    }
                    if (subjectname.getText() == ("Programming in java")) {
                        toast();
                        download("IN/KU/MC/04/PV");
                    }
                    if (subjectname.getText() == ("Advanced web technology ")) {
                        toast();
                        download("IN/KU/MC/05/AW");
                    }
                    if (subjectname.getText() == ("Computer architecture and parallel processing")) {
                        toast();
                        download("IN/KU/MC/05/CQ");
                    }
                    if (subjectname.getText() == ("Linux and shell programming")) {
                        toast();
                        download("IN/KU/MC/05/LP");
                    }


            }
        });

        return view;
    }

    public void download(final String directory) {


            storageReference = firebaseStorage.getInstance().getReference(directory);

            rootref= FirebaseDatabase.getInstance().getReference(directory);

               rootref.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       for(final DataSnapshot paper:dataSnapshot.getChildren()) {
                           Log.e("papername",paper.child("name").getValue().toString());
                             Log.e("info",paper.child("name").getValue().toString());
                           myref = storageReference.child(paper.child("name").getValue().toString()+".pdf");
                           myref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                               @Override
                               public void onSuccess(Uri uri) {
                                   String url = uri.toString();
                                   downloadfiles(getContext(),paper.child("name").getValue().toString(), ".pdf", DIRECTORY_DOWNLOADS, url);
                                   Log.e("inside onSucces","");
                               }
                           }).addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Log.e("inside onfailure", "");
                               }
                           });

                       }

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });


    }

    public void toast(){Toast.makeText(context, "downloading", Toast.LENGTH_LONG).show();}

    public void downloadfiles(Context context, String file, String fileExtension, String destinationDirectory, String url)
    {
        DownloadManager downloadmanager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request =new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, file+fileExtension);
        downloadmanager.enqueue(request);

    }


}

