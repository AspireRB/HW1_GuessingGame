package com.example.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import com.example.hw1_guessinggame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var numero : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        valorAleatorio()

        val Play = binding.btnPlay
        val respuesta = binding.respuesta
        Play.setOnClickListener {
            var numeroSugerido = binding.findNum as EditText
            var num = numeroSugerido.text.toString()
            var con = Integer.parseInt(num)
            if (con > numero) {
                respuesta.text = "El numero es menor"
            } else if (con < numero) {
                respuesta.text = "El numero es mayor"
            } else {
                respuesta.text = "Adivino el numero"
                Toast.makeText(this, "Adivino el numero", Toast.LENGTH_LONG).show()
            }

        }

        val Again = binding.btnAgain
        Again.setOnClickListener {
            respuesta.text = "Adivina el numero!"
            valorAleatorio()
        }
    }

    fun valorAleatorio() {
        numero = Random.nextInt(0,1000)
    }
}