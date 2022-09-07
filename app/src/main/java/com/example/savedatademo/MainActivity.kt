package com.example.savedatademo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtInput:EditText = findViewById(R.id.txtInput)
        val btnSave: Button = findViewById(R.id.btnSave)
        val tvResult:TextView = findViewById(R.id.textView2)
        val name = getPref("Name")

        if(name!=""){
            tvResult.text = name
        }


        btnSave.setOnClickListener (){
            val a = txtInput.toString()
            savePref("Name",a)
        }




    }

    private fun savePref(key:String, data:String){
        val pref = getPreferences(Context.MODE_PRIVATE)

        val editor = pref.edit()
        editor.putString(key, data)
        editor.commit()
    }


    private fun getPref(key:String): String{
        val pref = getPreferences(Context.MODE_PRIVATE)
        val data:String? = pref.getString(key, "")
        return data!!
    }


    private fun clearPref(){
        val pref = getPreferences(Context.MODE_PRIVATE)

        val editor = pref.edit()

        editor.clear()
        editor.commit()
    }


}