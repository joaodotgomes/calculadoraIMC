package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class result_Activity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
enableEdgeToEdge()
setContentView(R.layout.activity_result)
val resultado = intent.getFloatExtra(KEY_RESULT_IMC,0f)

    val Tvresult = findViewById<TextView>(R.id.result)
    val Tvclassificacao = findViewById<TextView>(R.id.classificacao)


Tvresult.text = resultado.toString()

    val classificacao : String = if (resultado <= 18.5f){
        "MAGREZA"
    } else if (resultado > 18.5f && resultado <=24.9f) {
        "NORMAL"
    } else if (resultado >25f && resultado <=29.9F){
        "SOBREPESO"
    } else if (resultado >30f && resultado <= 39.9f){
        "OBESIDADE"
    }else {
        "OBESIDADE GRAVE"
    }

Tvclassificacao.text = classificacao





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}