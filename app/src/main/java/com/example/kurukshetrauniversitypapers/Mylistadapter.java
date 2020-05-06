package com.example.kurukshetrauniversitypapers;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

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
import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.papercount5;

public class Mylistadapter extends ArrayAdapter<Listdata> {
    //the list values in the List of type hero
    List<Listdata> subjectlist;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;
    StorageReference storageReference,myref;
    FirebaseStorage firebaseStorage;
    int year=2019; // for downloader loop, year is initialized to 2019 as a starting year, than it will be decremneted
    //static int count;
    //constructor initializing the values
    public Mylistadapter(Context context, int resource, List<Listdata> subjectlist) {
        super(context, resource, subjectlist);
        this.context = context;
        this.resource = resource;
        this.subjectlist = subjectlist;
    }

    //this will return the ListView Item as a View
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        //ImageView imageView = view.findViewById(R.id.imageView);
        final TextView subjectname = view.findViewById(R.id.subjectname);
        final TextView papercount = view.findViewById(R.id.papercount);
        Button downloadall = view.findViewById(R.id.download_btn);
        // Button buttonDelete = view.findViewById(R.id.buttonDelete);

        //getting the hero of the specified position
        Listdata listdata = subjectlist.get(position);

        //adding values to the list item
        //imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        subjectname.setText(listdata.getSubjectname());
        //papercount.setText(listdata.getPapercount());
        papercount.setText(Integer.toString(listdata.getPapercount()));

        downloadall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("Are you sure you want to download all files?");
                if(subjectname.getText().equals("Biotechnology")) {
                    download("cse-firstsem-Biotechnology", subjectname.getText().toString(), papercount5);
                }
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//
//            }
//        });
//                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });

//        AlertDialog alertDialog = builder.create();
//                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY);
//        alertDialog.show();

            }
        });


        //adding a click listener to the button to remove item from the list
//        buttonDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //we will call this method to remove the selected value from the list
//                //we are passing the position which is to be removed in the method
//                removeHero(position);
//            }
//        });

        //finally returning the view
        return view;
    }
    public void download(final String directory, final String filename,  int count) {
        storageReference = firebaseStorage.getInstance().getReference();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        for (int i = 0; i < count; i++) {


            rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
               public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.hasChild(directory + "/" + filename+" "+year+".pdf")) {
                        // run some code
                        myref = storageReference.child(directory + "/" + filename+" "+year+".pdf");
                        myref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String url = uri.toString();
                                class Example {
                                    protected Context context;

                                    public Example(Context context){
                                        this.context = context.getApplicationContext();
                                    }
                                }
                                downloadfiles(context.getApplicationContext(), directory + "/" + filename+" "+year, ".pdf", DIRECTORY_DOWNLOADS, url);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                    }
                    else {
                        year--;
                        count++;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }


    public void downloadfiles(Context context, String filename, String fileExtension, String destinationDirectory, String url)
    {
        DownloadManager downloadmanager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request =new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, filename+fileExtension);
        downloadmanager.enqueue(request);
        year--;
    }
    //this method will remove the item from the list
//    private void removeHero(final int position) {
//        //Creating an alert dialog to confirm the deletion
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Are you sure you want to delete this?");            // Can be used when download image is clicked
//
//        //if the response is positive in the alert
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                //removing the item
//                heroList.remove(position);
//
//                //reloading the list
//                notifyDataSetChanged();
//            }
//        });
//
//        //if response is negative nothing is being done
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//
//        //creating and displaying the alert dialog
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

}

