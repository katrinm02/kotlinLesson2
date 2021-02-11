package com.example.task_salary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity_1 : Activity() {

    private lateinit var edName: EditText
    private lateinit var edSurname: EditText
    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        edName = findViewById(R.id.edit_text_name)
        edSurname = findViewById(R.id.edit_text_surname)
        next = findViewById(R.id.next)

        next.setOnClickListener() {
            next_fn(edName.text.toString(), edSurname.text.toString())
        }
    }

    fun next_fn(name: String, surname: String) {
        if (name.isNotEmpty() && surname.isNotEmpty()) {
            val intent = Intent(this, MainActivity_2::class.java)
            intent.putExtra("name", name)
            intent.putExtra("surname", surname)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Заполните все поля ввода", Toast.LENGTH_LONG).show()
        }
    }
}