package com.example.test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println(11)
        val button = findViewById<TextView>(R.id.button2)
        val a = intent.getIntExtra("key",0)




        println(1234565)

        button.setOnClickListener {
            val context:Context = this
            val intent = Intent(context,MainActivity::class.java)
            val b = Bundle()
            b.putInt("key",20)

            intent.putExtras(b)
            startActivity(intent)
        }

        supportFragmentManager.beginTransaction().add(R.id.funFactLayout,BlankFragment()).commit()

    }

    override fun onStart() {
        super.onStart()
        println(12)
    }

    override fun onResume() {
        super.onResume()
        println(13)
    }

    override fun onPause() {
        super.onPause()
        println(14)
    }

    override fun onStop() {
        super.onStop()
        println(15)
    }

    override fun onDestroy() {
        super.onDestroy()
        println(16)
    }

    override fun onRestart() {
        super.onRestart()
        println(16)
    }
}