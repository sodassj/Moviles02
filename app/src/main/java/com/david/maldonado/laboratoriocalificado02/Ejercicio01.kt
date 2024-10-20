package com.david.maldonado.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)

        // Configuración del padding para compatibilidad con barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los componentes de la interfaz
        val textView = findViewById<TextView>(R.id.textView)
        val buttonMostrar = findViewById<Button>(R.id.buttonMostrar)
        val buttonOcultar = findViewById<Button>(R.id.buttonOcultar)

        // Funcionalidad del botón "Mostrar"
        buttonMostrar.setOnClickListener {
            textView.visibility = View.VISIBLE
        }

        // Funcionalidad del botón "Ocultar"
        buttonOcultar.setOnClickListener {
            textView.visibility = View.GONE
        }
    }
}
