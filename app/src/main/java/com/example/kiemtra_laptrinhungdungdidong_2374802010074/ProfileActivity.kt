package com.example.kiemtra_laptrinhungdungdidong_2374802010074

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // Trích xuất dữ liệu Email được truyền từ LoginActivity
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: ""
        tvEmail.text = "Email: $email"

        // Đăng xuất: đóng màn hình hiện tại, quay về LoginActivity
        btnLogout.setOnClickListener { finish() }

        // Dữ liệu mẫu: danh sách môn học/kỹ năng
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android",
            "ListView và Adapter"
        )

        // Gắn ArrayAdapter với layout mẫu simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // Bắt sự kiện click item: hiển thị Toast tên phần tử đã chọn
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Bạn đã chọn: ${subjects[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}
