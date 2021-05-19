package com.example.test1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    companion object{
        private const val CONSTANT = "Test"
        fun intent(context: Context,text:String):Intent{
            val a = Intent(context,MainActivity2::class.java)
            val b = Bundle()
            b.putString(CONSTANT,text)
            a.putExtras(b)
            return a
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val a:String = intent.getStringExtra(CONSTANT).toString()

        val aa = findViewById<TextView>(R.id.textView4)

        aa.text = a

        aa.setOnClickListener {
            val intent = MainActivity.intent(this)
            startActivity(intent)
        }

    }

}