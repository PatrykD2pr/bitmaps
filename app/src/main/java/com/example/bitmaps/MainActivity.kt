package com.example.bitmaps

import android.annotation.SuppressLint
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var img = findViewById<ImageView>(R.id.imageView)
        var next = findViewById<Button>(R.id.nastepny)
        var prev = findViewById<Button>(R.id.back)
        var red = findViewById<Button>(R.id.red)
        var green = findViewById<Button>(R.id.green)
        var obrazek = 1
        
        next.setOnClickListener {
            if (obrazek == 1)
            {
                img.setImageResource(R.drawable.sid2)
                obrazek = 2
            }
            else
            {
                img.setImageResource(R.drawable.sid1)
                obrazek = 1
            }
        }
        prev.setOnClickListener { 
            if (obrazek == 2)
            {
                img.setImageResource(R.drawable.sid1)
                obrazek = 1
            }
            else
            {
                img.setImageResource(R.drawable.sid2)
                obrazek = 2
            }
        }

        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.sid1)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.sid2)

        val bitmapCzerwony = BitmapFactory.decodeResource(resources, R.drawable.redimg)
        val filterBitmap1 = Bitmap.createBitmap(bitmap1.width, bitmap1.height, Bitmap.Config.ARGB_8888)
        val filterBitmap2 = Bitmap.createBitmap(bitmap2.width, bitmap2.height, Bitmap.Config.ARGB_8888)

        red.setOnClickListener {
            if (obrazek == 1)
            {
                val paint = Paint()
                paint.alpha = 100
                val canvas1 = Canvas(filterBitmap1)
                canvas1.drawARGB(0,0,0,0)
                canvas1.drawBitmap(bitmapCzerwony,null,RectF(0f,0f,bitmap1.width.toFloat(),bitmap1.height.toFloat()),paint)
                canvas1.drawBitmap(bitmap1,0f, 0f,paint)
                img.setImageBitmap(filterBitmap1)
            }
            else
            {
                val paint = Paint()
                paint.alpha = 100
                val canvas2 = Canvas(filterBitmap2)
                canvas2.drawARGB(0,0,0,0)
                canvas2.drawBitmap(bitmapCzerwony,null,RectF(0f,0f,bitmap2.width.toFloat(),bitmap2.height.toFloat()),paint)
                canvas2.drawBitmap(bitmap2,0f, 0f,paint)
                img.setImageBitmap(filterBitmap2)
            }
        }
        var czy_zielony = 0
        green.setOnClickListener {

            if (czy_zielony == 0)
            {
                img.setColorFilter(R.color.green)
                green.background = (ContextCompat.getDrawable(green.context, R.color.green))
                czy_zielony = 1
            }
            else {
                img.setColorFilter(null)
                green.background = (ContextCompat.getDrawable(green.context, R.color.dark_green))
                czy_zielony = 0
            }
        }
    }
}