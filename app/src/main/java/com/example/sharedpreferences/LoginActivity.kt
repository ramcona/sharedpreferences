package com.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    var PREF_NAME = "MyPreference"
    var EMAIL_KEY = "email"
    var PASSWORD_KEY = "password"

    lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //memperkenalkan preferences
        preference = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        //mengecek data di preferences
        if ((preference.getString(EMAIL_KEY, "") ?: "").isNotEmpty()){
            //data sebelumnya masih tersimpan
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        login_btn_simpan.setOnClickListener {
            val email = login_edt_username.text.toString()
            val password = login_edt_password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                //inisialisasi editor preferences
                val editor = preference.edit()

                //menambahkan data kedalam editor preference
                editor.putString(EMAIL_KEY, email)
                editor.putString(PASSWORD_KEY, password)

                //mengeksekusi data yang ada di editor
                editor.apply()

                //pindah activity ke halaman utama
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            }else{
                Toast.makeText(this, "Lengkapi data anda", Toast.LENGTH_SHORT).show()
            }
        }
    }
}