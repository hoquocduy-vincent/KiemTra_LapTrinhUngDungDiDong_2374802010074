package com.example.kiemtra_laptrinhungdungdidong_2374802010074

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ View bằng findViewById (không dùng ViewBinding)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener { handleLogin() }
    }

    private fun handleLogin() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        val error = when {
            email.isEmpty() && password.isEmpty() -> "Lỗi: Vui lòng nhập Email và Mật khẩu!"
            email.isEmpty() -> "Lỗi: Email không được để trống!"
            password.isEmpty() -> "Lỗi: Mật khẩu không được để trống!"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Lỗi: Email không đúng định dạng!"
            password.length < 6 -> "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
            else -> null
        }

        if (error != null) {
            showStatus(error, isError = true)
            return
        }

        showStatus("Xác thực thành công!", isError = false)

        // Điều hướng Explicit Intent sang ProfileActivity, đóng gói Email bằng putExtra()
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra(EXTRA_EMAIL, email)
        startActivity(intent)
    }

    private fun showStatus(message: String, isError: Boolean) {
        tvStatus.text = message
        tvStatus.setTextColor(if (isError) Color.RED else Color.parseColor("#2E7D32"))
    }
}
