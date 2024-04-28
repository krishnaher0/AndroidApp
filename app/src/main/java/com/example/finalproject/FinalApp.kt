package com.example.finalproject

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalproject.R.id.textView5

class FinalApp : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var buttons: Button
    lateinit var textView1: TextView

    lateinit var radiomale: RadioButton
    lateinit var radiofemale: RadioButton
    lateinit var radioother: RadioButton

    lateinit var Spinner1: Spinner
    lateinit var textView: TextView
    var data = arrayOf("Gandaki", "Karnali", "Koshi", "Madhesh", "Bagmati", "Lumbini")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_app)

        buttons = findViewById(R.id.button2)
        textView1 = findViewById(textView5)
        buttons.setOnClickListener {
           loadCalendar() }


            radiomale = findViewById(R.id.radioButton1)
            radiofemale = findViewById(R.id.radioButton2)
            radioother = findViewById(R.id.radioButton3)

            textView = findViewById(R.id.textView22)
            Spinner1 = findViewById(R.id.spinner)

            var adapter = ArrayAdapter(this@FinalApp, android.R.layout.simple_spinner_item, data)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            Spinner1.adapter = adapter
            Spinner1.onItemSelectedListener = this

        }

    fun loadCalendar() {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val dayOfMonth = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                textView1.text = "SelectedDate:$dayOfMonth/${month + 1}/$year"
            }, year, month, dayOfMonth
        )
        datePickerDialog.show()
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            textView.text = parent?.getItemAtPosition(position).toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }




