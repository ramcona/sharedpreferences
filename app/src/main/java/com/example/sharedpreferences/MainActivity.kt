package com.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preference = getSharedPreferences(LoginActivity().PREF_NAME, MODE_PRIVATE)

        //menampilkan data dari preferences
        main_tv_username.text = "Username : ${preference.getString(LoginActivity().EMAIL_KEY, "")}"
        main_tv_password.text = "Password : ${preference.getString(LoginActivity().PASSWORD_KEY, "")}"

        main_btn_logout.setOnClickListener {
            val editor = preference.edit()

            //menghapus semua data di preferences
            editor.clear()
            editor.apply()

            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}