package com.example.calculadora_isr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtener información de botones que nos dirigen a las vistas
        val irCalculadora : Button = findViewById(R.id.irCalculadora)
        val irInformacion : Button = findViewById(R.id.irInformacion)


        //Nos lleva a la vista de la Calculadora
        irCalculadora.setOnClickListener{
            val intent = Intent(this, ResultadoCalculadora::class.java)
            startActivity(intent)
        }

        //Nos lleva a la vista sobre ISR
        irInformacion.setOnClickListener{
            val intent = Intent(this, ResultadoISR::class.java)
            startActivity(intent)
        }

    }
}