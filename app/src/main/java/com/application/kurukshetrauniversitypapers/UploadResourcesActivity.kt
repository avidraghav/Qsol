package com.application.kurukshetrauniversitypapers

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.application.kurukshetrauniversitypapers.databinding.ActivityUploadResourcesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import utils.PDFupload

class UploadResourcesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadResourcesBinding
    private var mAuth: FirebaseAuth? = null
    var storageReference: StorageReference? = null
    var databaseReference1: DatabaseReference? = null
    var db:DatabaseReference? = null
    private lateinit var name : String
   // var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadResourcesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        binding.addAttachments.setOnClickListener {
            addFile()
        }
    }
    fun addFile(){
            val intent = Intent()
            intent.type = "application/pdf"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select pdf file"), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.data != null) {

            Log.e("info",data.data.toString())
            //val myFile = File(data.data.toString())
            data.data?.let { returnUri ->
                contentResolver.query(returnUri, null, null, null, null)
            }?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
                cursor.moveToFirst()
                name = cursor.getString(nameIndex)
                Log.e("info",name)
                binding.filesSelectedTextview.text = name
            }
           uploadPDFFile1(data.data!!)
        }
    }
    private fun uploadPDFFile1(data: Uri) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Uploading...")
        progressDialog.show()
        storageReference = FirebaseStorage.getInstance().reference
//        databaseReference1 = FirebaseDatabase.getInstance()
//            .getReference("IN/" + MainActivity.board + "/" + MainActivity.branch + "/" + MainActivity.semester + "/" + MainActivity.subject)
        val reference: StorageReference = storageReference!!.child("IN/User/abc.pdf")
        reference.putFile(data)
            .addOnSuccessListener { taskSnapshot ->
                val uri = taskSnapshot.storage.downloadUrl
               while (!uri.isComplete);
                val url = uri.result
                val upload_PDF = PDFupload(
                    name,
                    "",
                    url.toString(),
                    ""
                )

//                databaseReference1!!.child(databaseReference1.push().getKey()).setValue(upload_PDF)
//                Toast.makeText(this@MainActivity, "File Uploaded", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }.addOnProgressListener { taskSnapshot ->
                val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                progressDialog.setMessage("uploaded: " + progress.toInt() + "%")
            }
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("run counter", "no")
        intent.putExtra("EXIT", true)
        startActivity(intent)
        finish()
    }
}