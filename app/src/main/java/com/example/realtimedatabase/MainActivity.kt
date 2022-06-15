package com.example.realtimedatabase

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.realtimedatabase.R.color.cool
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class MainActivity : AppCompatActivity() {
    lateinit var relativeLayout: LinearLayout

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var edittext2:EditText=findViewById(R.id.edittext1)
        var database: FirebaseDatabase = FirebaseDatabase.getInstance()
        var button2:Button=findViewById(R.id.button1)
        var textView2:TextView=findViewById(R.id.textview1)
        var myRef = database.getReference("key1")


        button2.setOnClickListener {
            var data1 =edittext2.text.toString()
            myRef.setValue("$data1")
            if (data1=="green"){
                relativeLayout.setBackgroundColor(cool)
            }

        }
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                textView2.text=value

            }

            override fun onCancelled(error: DatabaseError) {

            }


    })
}
}