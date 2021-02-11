package com.example.task_salary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_2: AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var edSalary: EditText
    private lateinit var next2: Button
    private lateinit var resultTV: TextView

    private val code = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)

        val thisIntent = intent
        textView = findViewById(R.id.text_view_name)
        edSalary = findViewById(R.id.edit_text_salary)
        next2 = findViewById(R.id.next2)
        resultTV = findViewById(R.id.result)

        val name = thisIntent.getStringExtra("name")
        val surname = thisIntent.getStringExtra("surname")

        textView.text = "$name $surname"
        next2.setOnClickListener(){
            next2_fn(edSalary.text.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null && requestCode == code) {
            val allSalary = data?.getIntExtra("result", 0)
            val countM = data?.getStringExtra("c_month")

            resultTV.text = "Вы заработали сумму за $countM месяц(ев) - $allSalary деняк"
        }
    }

    fun next2_fn(salary: String){
        if (salary.isNotEmpty()) {
            val intent = Intent(this, MainActivity_3::class.java)
            intent.putExtra("salary", salary.toInt())
            startActivityForResult(intent, code)
        } else {
            Toast.makeText(this, "Заполните все поля ввода", Toast.LENGTH_LONG).show()
        }
    }
}