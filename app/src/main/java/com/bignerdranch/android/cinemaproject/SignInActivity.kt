package com.bignerdranch.android.cinemaproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.cinemaproject.databinding.ActivityMainBinding
import com.bignerdranch.android.cinemaproject.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("sharPref", MODE_PRIVATE)

        binding.apply {
            val login = edLogin.text.toString()
            val password = edLogin.text.toString()
            btnRegistration.setOnClickListener{
                if(login.isNullOrEmpty() && password.isNullOrEmpty()){
                    Snackbar.make(binding.root, "Введите логин и пароль", Snackbar.LENGTH_SHORT).show()
                } else {
                    goToMainScreen()
                }
            }
            btnLogIn.setOnClickListener {
                val currentLogin = sharedPreferences.getString("login", null)
                val currentPassword = sharedPreferences.getString("password", null)

                if(currentLogin == null && currentPassword == null){
                    Snackbar.make(binding.root, "Пожалуйста зарегистрируйтесь", Snackbar.LENGTH_SHORT).show()
                } else if(currentLogin == login && currentPassword == password){
                    goToMainScreen()
                }
            }
        }




    }

    private fun saveData(login: String, password: String){
        val editor = sharedPreferences.edit()
        editor.putString("login", login)
        editor.putString("password", password)
        editor.apply()
    }
    private fun goToMainScreen(){
        val intent = Intent(this@SignInActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}