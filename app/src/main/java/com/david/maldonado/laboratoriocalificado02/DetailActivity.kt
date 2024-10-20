package com.david.maldonado.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.david.maldonado.laboratoriocalificado02.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val NAME_KEY = "NAME_KEY"
    private val NUMBER_KEY = "NUMBER_KEY"
    private val PRODUCT_KEY = "PRODUCT_KEY"
    private val CITY_KEY = "CITY_KEY"
    private val ADDRESS_KEY = "ADDRESS_KEY"
    private val PHONE_KEY = "PHONE_KEY"
    private val MAPS_LOCATION = "Av Arequipa 122, Lima, Peru"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showInformation(intent.extras)
        observeButtons(intent.extras)
    }

    private fun showInformation(bundle: Bundle?) {
        if (bundle != null) {
            val name = bundle.getString(NAME_KEY)
            val number = bundle.getString(NUMBER_KEY)
            val product = bundle.getString(PRODUCT_KEY)
            val city = bundle.getString(CITY_KEY)
            val address = bundle.getString(ADDRESS_KEY)

            binding.tvName.text = "Nombre del Cliente: $name"
            binding.tvNumber.text = "Número del Cliente: $number"
            binding.tvProduct.text = "Producto: $product"
            binding.tvCity.text = "Ciudad: $city"
            binding.tvAddress.text = "Dirección: $address"
        }
    }

    private fun observeButtons(bundle: Bundle?) {
        binding.btnCall.setOnClickListener {
            goDial(bundle)
        }

        binding.btnWhatsApp.setOnClickListener {
            goWsp(bundle)
        }

        binding.btnMaps.setOnClickListener {
            goMaps()
        }
    }

    private fun goDial(bundle: Bundle?) {
        val phone = bundle?.getString(PHONE_KEY)
        if (!phone.isNullOrEmpty()) {
            val intentDial = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            startActivity(intentDial)
        }
    }

    private fun goWsp(bundle: Bundle?) {
        val phone = "+51${bundle?.getString(PHONE_KEY)}" // Asegúrate de que el número de teléfono esté en el formato correcto
        val message = "Hola, te he agregado a mi lista de contactos"

        val intentWsp = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/$phone?text=${Uri.encode(message)}")
        }
        startActivity(intentWsp)
    }

    private fun goMaps() {
        val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode(MAPS_LOCATION)}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
            setPackage("com.google.android.apps.maps")
        }
        startActivity(mapIntent)
    }
}
