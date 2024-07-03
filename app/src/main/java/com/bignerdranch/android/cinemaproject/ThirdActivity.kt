package com.bignerdranch.android.cinemaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.cinemaproject.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title = intent.getStringExtra("movie_title")
        var image = intent.getIntExtra("movieImage", 0)

        binding.tvResultTitle.text = title
        binding.ivResultImage.setImageResource(image)
    }
}