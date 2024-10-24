package com.example.proyecto_tecno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantalla_configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_configuracion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recuperarpassword : Button = findViewById(R.id.edit_password)
        recuperarpassword.setOnClickListener{
            val intent: Intent = Intent(this, pantalla_recuperar_password::class.java)
            startActivity(intent)
        }

        val edituser: Button = findViewById(R.id.edit_user)
        edituser.setOnClickListener{
            val intent: Intent = Intent(this, pantalla_recuperar_password::class.java)
            startActivity(intent)
        }

    }
}