package com.bignerdranch.android.cinemaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.bignerdranch.android.cinemaproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieImages: List<Int>
    private lateinit var movieTitles: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieImages = listOf(R.drawable.avengers, R.drawable.capitan_marvel, R.drawable.iron_man)
        movieTitles = listOf("Мстители", "Капитан Марвел", "Железный человек")

        binding.viewPagerMovie.adapter = MovieAdapter(this, movieImages, movieTitles)
        binding.viewPagerMovie.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                binding.tvmovieTitle.text = movieTitles[position]
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        binding.bottomMenuId.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_selection -> {
                    val resultTitle = binding.tvmovieTitle.text.toString()
                    val intent = Intent(this@MainActivity, ThirdActivity::class.java)
                    intent.putExtra("movie_title", resultTitle)
                    intent.putExtra("movieImage", movieImages[binding.viewPagerMovie.currentItem])
                    startActivity(intent)
                }
            }
            true
        }

    }
}