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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import utils.AttachedFile

class UploadResourcesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadResourcesBinding
    private var mAuth: FirebaseAuth? = null
    var storageReference: StorageReference? = null
    var databaseReference1: DatabaseReference? = null
    var db:DatabaseReference? = null
  //  private lateinit var name : String
    private var fileUrl : Uri? = null
    private var attachmentList = ArrayList<AttachedFile>()
    private val adapter = SelectedAttachmentsAdapter(attachmentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadResourcesBinding.inflate(layoutInflater)
        setContentView(binding.root)
         Log.e("info",attachmentList.size.toString())
        mAuth = FirebaseAuth.getInstance()
        binding.addAttachments.setOnClickListener {
            addFile()
        }
        binding.uploadAttachments.setOnClickListener {
            if(attachmentList.size == 0){
                Toast.makeText(this,"Kindly add some files",Toast.LENGTH_SHORT).show()
            }
            else{
                val description = binding.attachmentsDescription.text.toString()
                uploadPDFFile(attachmentList,description)
            }

            //fileUrl?.let { uploadPDFFile(it,description) }
        }
        initRecyclerView()
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

            fileUrl = data.data
            Log.e("info",fileUrl.toString())
            fileUrl?.let { returnUri ->
                contentResolver.query(returnUri, null, null, null, null)
            }?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
               // val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
                cursor.moveToFirst()
                val name = cursor.getString(nameIndex)
               // size = cursor.getLong(sizeIndex)
                Log.e("info",name)
                val aFile = AttachedFile(name,fileUrl!!)
                attachmentList.add(aFile)
                adapter.notifyDataSetChanged()
               // binding.filesSelectedListview.text = ("$name  $size")
            }
        }
    }
    private fun uploadPDFFile(files: ArrayList<AttachedFile>, description : String) {
        binding.progressbar.visibility = View.VISIBLE
        storageReference = FirebaseStorage.getInstance().reference
        for (i in files){
            val reference: StorageReference = storageReference!!.child("IN/${mAuth?.currentUser?.email}/${i.name}")
            reference.putFile(i.uri)
                .addOnSuccessListener {
                    binding.progressbar.visibility =View.GONE
                    Toast.makeText(this,"Uploaded",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    binding.progressbar.visibility =View.GONE
                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                }.addOnCompleteListener{
                    files.clear()
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