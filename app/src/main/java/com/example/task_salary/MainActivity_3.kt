package com.example.task_salary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity_3:Activity() {
    private lateinit var edMonth: EditText
    private lateinit var count: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity3)

        val thisIntent = intent
        edMonth = findViewById(R.id.edit_text_month)
        count = findViewById(R.id.count)

        val salary = thisIntent.getIntExtra("salary", 0)
        count.setOnClickListener(){
            countFn(salary, edMonth.text.toString())
        }
    }
    fun countFn(salary: Int, month: String){
        if (month.isNotEmpty()) {
            val resultIntent = Intent()
            resultIntent.putExtra("result", month.toInt() * salary)
            resultIntent.putExtra("c_month", month)
            setResult(RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this, "Заполните все поля ввода", Toast.LENGTH_LONG).show()
        }
    }
}