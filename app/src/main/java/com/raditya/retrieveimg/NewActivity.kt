package com.raditya.retrieveimg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val plantIntent = intent
        val plantName = plantIntent.getStringExtra("name")
        val plantInfo = plantIntent.getStringExtra("info")
        val plantImg = plantIntent.getStringExtra("img")

        name.text = plantName
        info.text = plantInfo
        img.loadImage(plantImg, getProgessDrawable(this))
    }
}