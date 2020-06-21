package com.example.kurukshetrauniversitypapers;


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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import com.google.firebase.storage.StorageReference;

import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static com.example.kurukshetrauniversitypapers.Btech_expendable_list.csem1;
import static com.example.kurukshetrauniversitypapers.Btech_expendable_list.csem3;
import static com.example.kurukshetrauniversitypapers.Btech_expendable_list.csem4;
import static com.example.kurukshetrauniversitypapers.Btech_expendable_list.csem5;
import static com.example.kurukshetrauniversitypapers.Btech_expendable_list.csem6;
import static com.example.kurukshetrauniversitypapers.Btech_expendable_list.csem7;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount7;
import static com.example.kurukshetrauniversitypapers.Cse_eightsem_subjectlist.eightpapercount8;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_fifthsem_subjectlist.fivepapercount7;

import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount10;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount11;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount12;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount13;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount14;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount15;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount16;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount7;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount8;
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.onepapercount9;



import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_fourthsem_subjectlist.fourpapercount7;

import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount10;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount11;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount12;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount13;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount14;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount15;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount16;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount17;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount7;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount8;
import static com.example.kurukshetrauniversitypapers.Cse_secondsem_subjectlist.twopapercount9;

import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount7;
import static com.example.kurukshetrauniversitypapers.Cse_seventhsem_subjectlist.sevenpapercount8;

import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount7;
import static com.example.kurukshetrauniversitypapers.Cse_sixthsem_subjectlist.sixpapercount8;

import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount1;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount2;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount3;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount4;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount5;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount6;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount7;
import static com.example.kurukshetrauniversitypapers.Cse_thirdesem_subjectlist.threepapercount8;
import static com.example.kurukshetrauniversitypapers.Ece_eightsem_subjectlist.ece_eightpapercount1;
import static com.example.kurukshetrauniversitypapers.Ece_eightsem_subjectlist.ece_eightpapercount2;
import static com.example.kurukshetrauniversitypapers.Ece_eightsem_subjectlist.ece_eightpapercount3;
import static com.example.kurukshetrauniversitypapers.Ece_eightsem_subjectlist.ece_eightpapercount6;
import static com.example.kurukshetrauniversitypapers.Ece_eightsem_subjectlist.ece_eightpapercount7;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount1;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount2;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount3;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount4;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount5;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount6;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount7;
import static com.example.kurukshetrauniversitypapers.Ece_fourthsem_subjectlist.ece_fourpapercount9;
import static com.example.kurukshetrauniversitypapers.Ece_seventhsem_subjectlist.ece_sevenpapercount1;
import static com.example.kurukshetrauniversitypapers.Ece_seventhsem_subjectlist.ece_sevenpapercount2;
import static com.example.kurukshetrauniversitypapers.Ece_seventhsem_subjectlist.ece_sevenpapercount3;
import static com.example.kurukshetrauniversitypapers.Ece_seventhsem_subjectlist.ece_sevenpapercount4;
import static com.example.kurukshetrauniversitypapers.Ece_seventhsem_subjectlist.ece_sevenpapercount5;
import static com.example.kurukshetrauniversitypapers.Ece_seventhsem_subjectlist.ece_sevenpapercount6;
import static com.example.kurukshetrauniversitypapers.Ece_sixthsem_subjectlist.ece_sixpapercount1;
import static com.example.kurukshetrauniversitypapers.Ece_sixthsem_subjectlist.ece_sixpapercount2;
import static com.example.kurukshetrauniversitypapers.Ece_sixthsem_subjectlist.ece_sixpapercount3;
import static com.example.kurukshetrauniversitypapers.Ece_sixthsem_subjectlist.ece_sixpapercount4;
import static com.example.kurukshetrauniversitypapers.Ece_sixthsem_subjectlist.ece_sixpapercount5;
import static com.example.kurukshetrauniversitypapers.Ece_sixthsem_subjectlist.ece_sixpapercount6;

public class Mylistadapter extends ArrayAdapter<Listdata> {

    List<Listdata> subjectlist;
    Context context;
    int resource;
    StorageReference storageReference,myref;
    FirebaseStorage firebaseStorage;
    DatabaseReference rootref;


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
        Button downloadall = view.findViewById(R.id.download_btn);


        Listdata listdata = subjectlist.get(position);

        subjectname.setText(listdata.getSubjectname());
        papercount.setText(listdata.getPapercount());

        downloadall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GlobalClass globalClass=new GlobalClass();

                if(subjectname.getText()==("Applied chemistry")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/AC", subjectname.getText().toString(),onepapercount1);
                    else
                      {
                        download("IN/KU/CS/02/AC", subjectname.getText().toString(),twopapercount1);
                      }
                }
                if(subjectname.getText()==("Applied mathematics")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/AM", subjectname.getText().toString(),onepapercount2);
                    else {
                        download("IN/KU/CS/02/AM", subjectname.getText().toString(),twopapercount2);
                    }
                }
                if(subjectname.getText()==("Applied Physics")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/AP", subjectname.getText().toString(),onepapercount3);
                    else {
                        download("IN/KU/CS/02/AP", subjectname.getText().toString(),twopapercount3);
                    }
                }
                if(subjectname.getText()==("Biology")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/BI", subjectname.getText().toString(),onepapercount4);
                    else
                        download("IN/KU/CS/02/BI", subjectname.getText().toString(), twopapercount4);
                }
                if(subjectname.getText()==("Biotechnology")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/BT", subjectname.getText().toString(),onepapercount5);
                    else {
                        download("IN/KU/CS/02/BT", subjectname.getText().toString(),twopapercount5);
                    }
                }
                if(subjectname.getText()==("Calculus and linear algebra")) {
                    toast();
                        download("IN/KU/CS/01/CU", subjectname.getText().toString(),onepapercount6);
                }

                if(subjectname.getText()==("Chemistry")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/CH", subjectname.getText().toString(),onepapercount7);
                    else {
                        download("IN/KU/CS/02/AP", subjectname.getText().toString(),twopapercount7);
                    }
                }

                if(subjectname.getText()==("Electrical engineering")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/EE", subjectname.getText().toString(),onepapercount8);
                    else {
                        download("IN/KU/CS/02/EE", subjectname.getText().toString(),twopapercount8);
                    }
                }
                if(subjectname.getText()==("Electrical technology")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/ET", subjectname.getText().toString(),onepapercount9);
                    else {
                        download("IN/KU/CS/02/ET", subjectname.getText().toString(),twopapercount9);
                    }
                }
                if(subjectname.getText()==("Engineering drawing")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/ED", subjectname.getText().toString(),onepapercount10);
                    else {
                        download("IN/KU/CS/02/ED", subjectname.getText().toString(),twopapercount11);
                    }
                }
                if(subjectname.getText()==("English")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/EH", subjectname.getText().toString(),onepapercount11);
                    else {
                        download("IN/KU/CS/02/EH", subjectname.getText().toString(),twopapercount12);
                    }
                }
                if(subjectname.getText()==("Fundamentals of computer programming")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/FP", subjectname.getText().toString(),onepapercount12);
                    else {
                        download("IN/KU/CS/02/FP", subjectname.getText().toString(),twopapercount13);
                    }
                }
                if(subjectname.getText()==("Mathematics")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/MA", subjectname.getText().toString(),onepapercount13);
                    else {
                        download("IN/KU/CS/02/MA", subjectname.getText().toString(),twopapercount14);
                    }
                }
                if(subjectname.getText()==("Multivariable calculus and linear algebra")) {
                    toast();
                        download("IN/KU/CS/01/MA", subjectname.getText().toString(),onepapercount14);
                }
                if(subjectname.getText()==("Physics")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/PH", subjectname.getText().toString(),onepapercount15);
                    else
                        download("IN/KU/CS/02/PH", subjectname.getText().toString(), twopapercount15);
                }
                if(subjectname.getText()==("Programming for problem solving")) {
                    toast();
                    if(globalClass.getSemester()==1)
                        download("IN/KU/CS/01/PP", subjectname.getText().toString(),onepapercount16);
                    else
                        download("IN/KU/CS/02/PP", subjectname.getText().toString(),twopapercount17);
                }
                if(subjectname.getText()==("Semiconductor physics")) {
                    toast();
                        download("IN/KU/CS/01/PH", subjectname.getText().toString(),onepapercount16);
                }
                if(subjectname.getText()==("Calculus and ordinary differential equation")) {
                    toast();
                    download("IN/KU/CS/02/CL", subjectname.getText().toString(),twopapercount6);
                }
                if(subjectname.getText()==("Electrical technology fundamentals")) {
                    toast();
                    download("IN/KU/CS/02/EF", subjectname.getText().toString(),twopapercount10);
                }
                if(subjectname.getText()==("Probability and statistics")) {
                    toast();
                    download("IN/KU/CS/02/PS", subjectname.getText().toString(),twopapercount16);
                }


                if(subjectname.getText()==("Discrete structure")) {
                    toast();
                    download("IN/KU/CS/01/DC", subjectname.getText().toString(),threepapercount1);
                }
                if(subjectname.getText()==("Database management system")) {
                    toast();
                    download("IN/KU/CS/01/DM", subjectname.getText().toString(),threepapercount2);
                }
                if(subjectname.getText()==("Data structures and algorithms")) {
                    toast();
                    if(globalClass.getBranch().equals("CSE") && globalClass.getSemester()==4)
                    download("IN/KU/CS/01/DT", subjectname.getText().toString(),threepapercount3);
                    if(globalClass.getBranch().equals("ECE") && globalClass.getSemester()==4)
                        download("IN/KU/EC/04/DT", subjectname.getText().toString(),ece_fourpapercount4);
                }
                if(subjectname.getText()==("Data structures")) {
                    toast();
                    download("IN/KU/CS/01/DS", subjectname.getText().toString(),threepapercount4);
                }
                if(subjectname.getText()==("Digital electronics")) {
                    toast();
                    if(globalClass.getBranch().equals("CSE") && globalClass.getSemester()==4)
                    download("IN/KU/CS/01/DE", subjectname.getText().toString(),threepapercount5);
                    if(globalClass.getBranch().equals("ECE") && globalClass.getSemester()==4)
                        download("IN/KU/EC/04/DE", subjectname.getText().toString(),ece_fourpapercount3);

                }


                if(subjectname.getText()==("Internet Fundamental")) {
                    toast();
                    if(globalClass.getSemester()==3)
                        download("IN/KU/CS/03/IF", subjectname.getText().toString(),threepapercount6);
                    else
                        download("IN/KU/CS/04/IF", subjectname.getText().toString(),fourpapercount2);
                }
                if(subjectname.getText()==("Programming language")) {
                    toast();
                    if(globalClass.getSemester()==3)
                        download("IN/KU/CS/03/PL", subjectname.getText().toString(),threepapercount8);
                    else
                        download("IN/KU/CS/04/PL", subjectname.getText().toString(),fourpapercount6);
                }
                if(subjectname.getText()==("Object oriented programming")) {
                    toast();
                    if(globalClass.getSemester()==3)
                        download("IN/KU/CS/03/OP", subjectname.getText().toString(),threepapercount7);
                    else
                        download("IN/KU/CS/04/OP", subjectname.getText().toString(),fourpapercount4);
                }

                if(subjectname.getText()==("Computer architecture and organisation")) {
                    toast();
                    if(globalClass.getSemester()==4 && globalClass.getBranch().equals("CSE"))
                    download("IN/KU/CS/04/CA", subjectname.getText().toString(),fourpapercount1);
                    if(globalClass.getSemester()==4 && globalClass.getBranch().equals("ECE"))
                        download("IN/KU/EC/04/CA", subjectname.getText().toString(),ece_fourpapercount2);

                }
                if(subjectname.getText()==("Microprocessor and interfacing")) {
                    toast();
                    download("IN/KU/CS/04/MI", subjectname.getText().toString(),fourpapercount3);
                }
                if(subjectname.getText()==("Digital data communication")) {
                    toast();
                    download("IN/KU/CS/04/DD", subjectname.getText().toString(),fourpapercount7);
                }

                if(subjectname.getText()==("Operating systems")) {
                    toast();
                    if(globalClass.getSemester()==4)
                        download("IN/KU/CS/04/OS", subjectname.getText().toString(),fourpapercount5);
                    else
                        download("IN/KU/CS/05/OS", subjectname.getText().toString(),fivepapercount7);
                }
                if(subjectname.getText()==("Automata theory")) {
                    toast();
                    download("IN/KU/CS/05/AT", subjectname.getText().toString(),fivepapercount1);
                }
                if(subjectname.getText()==("Computer networks")) {
                    toast();
                    download("IN/KU/CS/05/CN", subjectname.getText().toString(),fivepapercount3);
                }
                if(subjectname.getText()==("Computer organisation and architecture")) {
                    toast();
                    download("IN/KU/CS/05/CO", subjectname.getText().toString(),fivepapercount4);
                }
                if(subjectname.getText()==("Design and analysis of algorithm")) {
                    toast();
                    download("IN/KU/CS/05/DA", subjectname.getText().toString(),fivepapercount5);
                }
                if(subjectname.getText()==("Simulation and modelling")) {
                    toast();
                    download("IN/KU/CS/05/SA", subjectname.getText().toString(),fivepapercount6);
                }
                if(subjectname.getText()==("Essentials of information technology")) {
                    toast();
                    if(csem5==5)
                        download("IN/KU/CS/05/EO", subjectname.getText().toString(),fivepapercount2);
                    else
                        download("IN/KU/CS/06/EO", subjectname.getText().toString(),sixpapercount4);
                }
                if(subjectname.getText()==("Advanced database systems")) {
                    toast();
                    download("IN/KU/CS/06/AD", subjectname.getText().toString(),sixpapercount1);
                }

                if(subjectname.getText()==("Computer hardware technologies")) {
                    toast();
                    download("IN/KU/CS/06/CT", subjectname.getText().toString(),sixpapercount3);
                }
                if(subjectname.getText()==("Mobile computing")) {
                    toast();
                    download("IN/KU/CS/06/MC", subjectname.getText().toString(),sixpapercount5);
                }
                if(subjectname.getText()==("Network management and security")) {
                    toast();
                    download("IN/KU/CS/06/NM", subjectname.getText().toString(),sixpapercount6);
                }
                if(subjectname.getText()==("Software engineering")) {
                    toast();
                    download("IN/KU/CS/06/SE", subjectname.getText().toString(),sixpapercount7);
                }
                if(subjectname.getText()==("Compiler design")) {
                    toast();
                    if(globalClass.getSemester()==6)
                        download("IN/KU/CS/06/CD", subjectname.getText().toString(),sixpapercount2);
                    if(globalClass.getSemester()==7)
                        download("IN/KU/CS/07/CD", subjectname.getText().toString(),sevenpapercount1);
                }
                if(subjectname.getText()==("Web engineering")) {
                    toast();
                    if(globalClass.getSemester()==6)
                        download("IN/KU/CS/06/WE", subjectname.getText().toString(),sixpapercount8);
                    else
                        download("IN/KU/CS/07/WE", subjectname.getText().toString(),sevenpapercount8);
                }

                if(subjectname.getText()==("Computer graphics and animation")) {
                    toast();
                    download("IN/KU/CS/07/CG", subjectname.getText().toString(),sevenpapercount2);
                }
                if(subjectname.getText()==("Cryptography and information security")) {
                    toast();
                    download("IN/KU/CS/07/CI", subjectname.getText().toString(),sevenpapercount3);
                }
                if(subjectname.getText()==("Expert systems")) {
                    toast();
                    download("IN/KU/CS/07/ES", subjectname.getText().toString(),sevenpapercount4);
                }
                if(subjectname.getText()==("Security and cryptography")) {
                    toast();
                    download("IN/KU/CS/07/SC", subjectname.getText().toString(),sevenpapercount5);
                }
                if(subjectname.getText()==("Software project management")) {
                    toast();
                    download("IN/KU/CS/07/SP", subjectname.getText().toString(),sevenpapercount6);
                }
                if(subjectname.getText()==("Statistical models for computer science")) {
                    toast();
                    download("IN/KU/CS/07/SM", subjectname.getText().toString(),sevenpapercount7);
                }
                if(subjectname.getText()==("Unix and Linux prog")) {
                    toast();
                    download("IN/KU/CS/07/UL", subjectname.getText().toString(),sevenpapercount8);
                }

                if(subjectname.getText()==("Cloud computing")) {
                    toast();
                    download("IN/KU/CS/08/CC", subjectname.getText().toString(),eightpapercount1);
                }
                if(subjectname.getText()==("Data warehouse and data mining")) {
                    toast();
                    download("IN/KU/CS/08/DW", subjectname.getText().toString(),eightpapercount2);
                }
                if(subjectname.getText()==("Interactive computer graphics")) {
                    toast();
                    download("IN/KU/CS/08/IC", subjectname.getText().toString(),eightpapercount3);
                }
                if(subjectname.getText()==("Mobile apps development")) {
                    toast();
                    download("IN/KU/CS/08/MD", subjectname.getText().toString(),eightpapercount4);
                }
                if(subjectname.getText()==("Neural network and fuzzy lose")) {
                    toast();
                    download("IN/KU/CS/08/NO", subjectname.getText().toString(),eightpapercount5);
                }
                if(subjectname.getText()==("Neural network and fuzzy logic")) {
                    download("IN/KU/CS/08/NL", subjectname.getText().toString(),eightpapercount6);
                }
                if(subjectname.getText()==("Software testing")) {
                    toast();
                    download("IN/KU/CS/08/ST", subjectname.getText().toString(),eightpapercount7);
                }
                if(subjectname.getText()==("Software verification validation and testing")) {
                    toast();
                    download("IN/KU/CS/08/SV", subjectname.getText().toString(),eightpapercount8);
                }
                //ECE SUBJECTS

                if(subjectname.getText()==("Analog Electronics")) {
                    toast();
                    download("IN/KU/EC/04/AN", subjectname.getText().toString(),ece_fourpapercount1);
                }
                if(subjectname.getText()==("Electromagnetic theory")) {
                    toast();
                    download("IN/KU/EC/04/EY", subjectname.getText().toString(),ece_fourpapercount6);
                }
                if(subjectname.getText()==("Electronic measurements and instruments")) {
                    toast();
                    download("IN/KU/EC/04/EM", subjectname.getText().toString(),ece_fourpapercount5);
                }
                if(subjectname.getText()==("Field and waves")) {
                    toast();
                    download("IN/KU/EC/04/FW", subjectname.getText().toString(),ece_fourpapercount7);
                }
                if(subjectname.getText()==("Transducer and their applications")) {
                    toast();
                    if(globalClass.getSemester()==4)
                    download("IN/KU/EC/04/TA", subjectname.getText().toString(),ece_fourpapercount9);
                    if(globalClass.getSemester()==8)
                        download("IN/KU/EC/08/TA", subjectname.getText().toString(),ece_eightpapercount6);
                }
                if(subjectname.getText()==("Computer communication network")) {
                    toast();
                    download("IN/KU/EC/06/CE", subjectname.getText().toString(),ece_sixpapercount1);
                }
                if(subjectname.getText()==("Control system engineering")) {
                    toast();
                    download("IN/KU/EC/06/CS", subjectname.getText().toString(),ece_sixpapercount2);
                }
                if(subjectname.getText()==("Digital communication")) {
                    toast();
                    download("IN/KU/EC/06/DO", subjectname.getText().toString(),ece_sixpapercount4);
                }
                if(subjectname.getText()==("Digital design using verilog")) {
                    toast();
                    download("IN/KU/EC/06/DI", subjectname.getText().toString(),ece_sixpapercount3);
                }
                if(subjectname.getText()==("Digital signal processing")) {
                    toast();
                    download("IN/KU/EC/06/DP", subjectname.getText().toString(),ece_sixpapercount5);
                }
                if(subjectname.getText()==("Vhdl and digital systems")) {
                    toast();
                    download("IN/KU/EC/06/VD", subjectname.getText().toString(),ece_sixpapercount6);
                }
                if(subjectname.getText()==("Optical communication")) {
                    toast();
                    download("IN/KU/EC/07/OC", subjectname.getText().toString(),ece_sevenpapercount3);
                }
                if(subjectname.getText()==("Reliability")) {
                    toast();
                    download("IN/KU/EC/07/RE", subjectname.getText().toString(),ece_sevenpapercount4);
                }
                if(subjectname.getText()==("Television engineering")) {
                    toast();
                    download("IN/KU/EC/07/TE", subjectname.getText().toString(),ece_sevenpapercount5);
                }
                if(subjectname.getText()==("Artificial intelligence and expert systems")) {
                    toast();
                    download("IN/KU/EC/07/AI", subjectname.getText().toString(),ece_sevenpapercount1);
                }
                if(subjectname.getText()==("Microwave engineering")) {
                    toast();
                    download("IN/KU/EC/07/ME", subjectname.getText().toString(),ece_sevenpapercount2);
                }
                if(subjectname.getText()==("VLSI design")) {
                    toast();
                    download("IN/KU/EC/07/VL", subjectname.getText().toString(),ece_sevenpapercount6);
                }

                if(subjectname.getText()==("Embedded system design")) {
                    toast();
                    download("IN/KU/EC/08/EI", subjectname.getText().toString(),ece_eightpapercount1);
                }
                if(subjectname.getText()==("Radar engineering")) {
                    toast();
                    download("IN/KU/EC/08/RA", subjectname.getText().toString(),ece_eightpapercount3);
                }
                if(subjectname.getText()==("Multimedia communication")) {
                    toast();
                    download("IN/KU/EC/08/MU", subjectname.getText().toString(),ece_eightpapercount2);
                }
                if(subjectname.getText()==("Wireless and mobile communication")) {
                    toast();
                    download("IN/KU/EC/08/WI", subjectname.getText().toString(),ece_eightpapercount7);
                }





            }
        });

        return view;
    }

    public void download(final String directory, final String filename, final int count) {


            storageReference = firebaseStorage.getInstance().getReference(directory);

            rootref= FirebaseDatabase.getInstance().getReference(directory);

               rootref.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       for(final DataSnapshot paper:dataSnapshot.getChildren()) {

                           Log.e("papername",paper.child("name").getValue().toString());
                          // Listdata details=new Listdata(filename,count);
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

