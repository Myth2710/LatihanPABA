package com.example.latihan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnEmail: Button
    private lateinit var btnPhone: Button
    private lateinit var btnRole: Button

    private val roleLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val role = result.data?.getStringExtra("ROLE")

                if (role != null) {
                    btnRole.text = role
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnEmail = findViewById(R.id.btnEmail)
        btnPhone = findViewById(R.id.btnPhone)
        btnRole = findViewById(R.id.btnRole)

        btnEmail.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("mailto:kent@example.com")
            )

            startActivity(intent)
        }

        btnPhone.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:+628123456789")
            )

            startActivity(intent)
        }

        btnRole.setOnClickListener {

            val intent = Intent(
                this,
                RoleActivity::class.java
            )

            roleLauncher.launch(intent)
        }
    }
}