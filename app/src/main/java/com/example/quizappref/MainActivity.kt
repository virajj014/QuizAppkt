package com.example.quizappref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quizappref.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.logoutButton.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(
                Intent(this, LoginActivity::class.java)
            )
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()

        }
        binding.startquizButton.setOnClickListener{
            startActivity(
                Intent(this, QuizActivity::class.java)
            )
            Toast.makeText(this, "The Quiz has been started", Toast.LENGTH_SHORT).show()
        }





    }


}