package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
// Tran Bach Luu Duc - 20200180
/**
 * This activity allows the user to roll a dice and view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Roll a dice randomly when starting the app
        rollDice()

    }

    /**
     * Roll the dice and update the screen with the result
      */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        // Show the total number of 2 dices
        showTotal(diceRoll, diceRoll2)

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = findNum(diceRoll)
        val drawableResource2 =  findNum(diceRoll2)

        // Update the ImageView with the correct drawble resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        // Update the content description of Dice image
        diceImage.contentDescription  = diceRoll.toString()
        diceImage2.contentDescription  = diceRoll2.toString()

    }

    /**
     * Set the number of image
     */
    private fun findNum(diceRoll: Int): Int {
        return when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    /**
     * Show the total number or 2 dices
     */
    private fun showTotal(num: Int, num2: Int) {
        val total: TextView = findViewById(R.id.textView)
        val sum: Int = num + num2

        total.text = "Total: ${sum}"
    }
}

/**
 * This activity allows you to create a dice
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}