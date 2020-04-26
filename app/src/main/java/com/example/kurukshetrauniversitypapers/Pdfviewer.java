package com.example.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Pdfviewer extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
        pdfView=findViewById(R.id.pdfView);

        uploadPDF uploadPDF=new uploadPDF();
        pdfView.fromUri(Uri.parse(uploadPDF.getUrl()));
    }

}
