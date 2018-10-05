package com.example.luissancar.borrarrr

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View

import kotlinx.android.synthetic.main.activity_dos.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_dos.*

class Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos)
        setSupportActionBar(toolbar)

        val bundle:Bundle?=intent.extras
        if (bundle!=null) {
            textView.text=bundle.getString("textoEnviado")
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun uno(v:View){


            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

    }

}
