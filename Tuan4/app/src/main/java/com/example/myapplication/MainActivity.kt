package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetail.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("name", "Quách Nhật Phương")
            intent.putExtra("studentId", "2415053122336")
            intent.putExtra("major", "Information Technology")
            intent.putExtra("gpa", 3.7)

            startActivity(intent)
        }
    }
}