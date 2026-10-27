package com.example.kiemtra_laptrinhungdungdidong_2374802010074

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Trích xuất dữ liệu Email được truyền từ LoginActivity
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: ""
        tvEmail.text = "Email: $email"

        // Đăng xuất: đóng màn hình hiện tại, quay về LoginActivity
        btnLogout.setOnClickListener { finish() }
    }
}
