package com.example.luissancar.borrarrr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    var primeraVez=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerAdapter= ArrayAdapter.createFromResource(this,R.array.items,android.R.layout.simple_spinner_item)
        spinner01.adapter=spinnerAdapter


        spinner01.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (primeraVez.not()){
                    mostrarSpinner()}
                else
                    primeraVez=false
                    }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }



        }





        boton.setOnClickListener {
            val intent=Intent(this,Dos::class.java)
            intent.putExtra("textoEnviado", "contenido enviado")
            startActivity(intent)
        }

        botonSpinner.setOnClickListener {
            mostrarSpinner()
        }

        seekBar.setOnSeekBarChangeListener(this)

        seekBar2.setOnSeekBarChangeListener(this)



    }


    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        val se=p0?.equals(seekBar)
        if (se!=null)
            if (se)
                textViewSeek.text=p0?.progress.toString()
            else
                textViewSeek2.text=p1.toString()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
   }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        mostrar(seekBar.progress.toString())
    }

    fun botonCheckBox(v: View){
        var salidaCheckbox=""
        if (checkBox.isChecked)
            salidaCheckbox+= "checkbox 1 on "
        else
            salidaCheckbox+= "checkbox 1 off "
        if (checkBox2.isChecked)
            salidaCheckbox+= "checkbox 2 on "
        else
            salidaCheckbox+= "checkbox 2 off "

        mostrar(salidaCheckbox.toString())


    }



    fun botonRadio(v: View){
        var salidaCheckbox=""
        if (radioButton.isChecked)
            salidaCheckbox+= "radio 1 on "
        else
            salidaCheckbox+= "radio 1 off "
        if (radioButton2.isChecked)
            salidaCheckbox+= "radio 2 on "
        else
            salidaCheckbox+= "radio 2 off "

        mostrar(salidaCheckbox.toString())


    }
    fun mostrarSpinner(){
        mostrar( spinner01.getItemAtPosition(spinner01.selectedItemPosition).toString())


    }
    fun mostrar( cadena: String){
        Toast.makeText(this@MainActivity, cadena.toString(),Toast.LENGTH_LONG).show()


    }
}
