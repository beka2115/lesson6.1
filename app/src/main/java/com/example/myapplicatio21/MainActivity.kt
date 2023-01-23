package com.example.myapplicatio21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplicatio21.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imgList = arrayListOf(
        "https://i.pinimg.com/236x/57/5c/54/575c547ea49a78dbb28cb53f4448d3d9.jpg",
        "https://i.pinimg.com/236x/07/cb/55/07cb55e4c3831d4e8db376c45b7fdc56.jpg",
        "https://i.pinimg.com/236x/9e/1b/56/9e1b567a5445db392298cd5affa4239e.jpg",
        "https://i.pinimg.com/236x/af/5a/33/af5a33cd0caaec862960469ec82d9749.jpg",
        "https://i.pinimg.com/236x/33/a2/b2/33a2b29cded421347489e4d81fa91191.jpg",
        "https://i.pinimg.com/236x/eb/5f/11/eb5f11e6a94754f4b358330c09af1cc3.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnSubmit.setOnClickListener {
                if (Patterns.WEB_URL.matcher(editUrl.text.toString()).matches()) {
                    imgList.add(editUrl.text.toString())
                    editUrl.text.clear()
                    Toast.makeText(this@MainActivity, "Url have saved", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this@MainActivity, "Wrong Url", Toast.LENGTH_LONG).show()
                }
            }
            btnRandom.setOnClickListener {
                peactures.loadImage(imgList[Random.nextInt(imgList.size)])
            }
        }
    }
    
    private fun View.loadImage(url:String){
        Glide.with(this).load(url).circleCrop().into(this as ImageView)
    }
}