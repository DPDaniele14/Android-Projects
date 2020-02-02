package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var rollButton: Button
    lateinit var throwResultImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Search for the button in the view and attach a click listener
        this.rollButton = findViewById(R.id.roll_button)
        // rollButton.text = "LOL"
        // Search for the result in the view to change its text

        this.rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        // My Version
        // val rollValue: Int = ceil(Math.random() * 6).toInt()
        // Pro's Version
        // This one is for text
         // val throwResultText: TextView = findViewById(R.id.throw_result_text)

        // This one is for images
        this.throwResultImg = findViewById(R.id.throw_result_img)

        // Noob method
        // val rollValue: Int = Random().nextInt(6) + 1

        // This one is for text
         /*throwResultText.text = rollValue.toString()
         Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()*/

        // This one is for images
        val resultImage = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        throwResultImg.setImageResource(resultImage)
        // In one line:
        // findViewById<TextView>(R.id.throw_result_text).text = (Random().nextInt(6) + 1).toString()
    }
}
