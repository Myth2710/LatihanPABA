package com.example.latihan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RoleActivity : AppCompatActivity() {

    private lateinit var btnAdmin: Button
    private lateinit var btnUser: Button
    private lateinit var btnGuest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_role)

        btnAdmin = findViewById(R.id.btnAdmin)
        btnUser = findViewById(R.id.btnUser)
        btnGuest = findViewById(R.id.btnGuest)

        btnAdmin.setOnClickListener {
            pilihRole("Admin")
        }

        btnUser.setOnClickListener {
            pilihRole("User")
        }

        btnGuest.setOnClickListener {
            pilihRole("Guest")
        }
    }

    private fun pilihRole(role: String) {

        val intent = Intent()

        intent.putExtra("ROLE", role)

        setResult(RESULT_OK, intent)

        finish()
    }
}