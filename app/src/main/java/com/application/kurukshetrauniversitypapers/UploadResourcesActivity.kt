package com.application.kurukshetrauniversitypapers


import Adapters.SelectedAttachmentsAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.kurukshetrauniversitypapers.databinding.ActivityUploadResourcesBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import utils.AttachedFile

class UploadResourcesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadResourcesBinding
    private var mAuth: FirebaseAuth? = null
    var storageReference: StorageReference? = null
    var databaseReference: DatabaseReference? = null
    private var attachmentList = ArrayList<AttachedFile>()
    private val adapter = SelectedAttachmentsAdapter(attachmentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadResourcesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        initRecyclerView()

        binding.addAttachments.setOnClickListener {
            addFile()
        }
        binding.uploadAttachments.setOnClickListener {
            if(attachmentList.size == 0){
                Toast.makeText(this,"Kindly add some files",Toast.LENGTH_SHORT).show()
            }
            else{
                uploadPDFFile(attachmentList)
            }
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

            val fileUrl = data.data
            fileUrl?.let { returnUri ->
                contentResolver.query(returnUri, null, null, null, null)
            }?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
               // val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
                cursor.moveToFirst()
                val name = cursor.getString(nameIndex)
               // size = cursor.getLong(sizeIndex)
                Log.e("info",name)
                val aFile = AttachedFile(name,fileUrl.toString())
                attachmentList.add(aFile)
                adapter.notifyDataSetChanged()
            }
        }
    }
    private fun uploadPDFFile(files: ArrayList<AttachedFile>) {
        binding.progressbar.visibility = View.VISIBLE
        storageReference = FirebaseStorage.getInstance().reference
        databaseReference = FirebaseDatabase.getInstance()
            .getReference("IN/Uploaded-Resources/${mAuth?.uid}"+"-"+"${mAuth?.currentUser?.displayName}")

        for (i in files){
            Toast.makeText(this,"Uploading ${i.name}",Toast.LENGTH_SHORT).show()
            val reference: StorageReference = storageReference!!.child("IN/Uploaded-Resources/${mAuth?.uid}"+"-"+"${mAuth?.currentUser?.displayName}/${i.name}")
            reference.putFile(Uri.parse(i.uri))
                .addOnSuccessListener {
                    val uri: Task<Uri> = it.storage.downloadUrl
                    while (!uri.isComplete);  // to make sure that the task is completed, ';' represents {} (do nothing)
                    val url  = uri.result
                    val upload_PDF = AttachedFile(i.name, url.toString())
                    databaseReference!!.child(databaseReference!!.push().key!!).setValue(upload_PDF)
                    binding.progressbar.visibility =View.GONE
                }.addOnFailureListener{
                    binding.progressbar.visibility =View.GONE
                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                }.addOnCompleteListener{
                    binding.progressbar.visibility =View.GONE
                    files.clear()
                    Toast.makeText(this,
                        "Thanks for contributing to Qsol! Your Files have been Uploaded. " +
                                "You will hear from us shortly regarding your details for Qsol's credit Board",Toast.LENGTH_LONG).show()
                }
        }

    }
    private fun initRecyclerView(){
        binding.filesSelectedRecyclerView.adapter = adapter
        binding.filesSelectedRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.filesSelectedRecyclerView.setHasFixedSize(true)
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