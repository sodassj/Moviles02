package com.david.maldonado.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.david.maldonado.laboratoriocalificado02.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentBinding

    private val NAME_KEY = "NAME_KEY"
    private val NUMBER_KEY = "NUMBER_KEY"
    private val PRODUCT_KEY = "PRODUCT_KEY"
    private val CITY_KEY = "CITY_KEY"
    private val ADDRESS_KEY = "ADDRESS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeButtons()
    }

    private fun observeButtons() {
        binding.btnRegistrar.setOnClickListener {
            goDetailActivity()
        }
    }

    private fun goDetailActivity() {
        val name = binding.etNombreCliente.text.toString()
        val number = binding.etNumeroCliente.text.toString()
        val product = binding.etProducto.text.toString()
        val city = binding.etCiudad.text.toString()
        val address = binding.etDireccion.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(NAME_KEY, name)
        intent.putExtra(NUMBER_KEY, number)
        intent.putExtra(PRODUCT_KEY, product)
        intent.putExtra(CITY_KEY, city)
        intent.putExtra(ADDRESS_KEY, address)

        startActivity(intent)
    }
}
