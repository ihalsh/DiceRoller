package com.github.ihalsh.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.ihalsh.diceroller.R.drawable.*
import com.github.ihalsh.diceroller.R.id.*

class MainActivity : AppCompatActivity() {

    private val diceImageViewOne: ImageView by lazy { findViewById(dice_image_one) }
    private val diceImageViewTwo: ImageView by lazy { findViewById(dice_image_two) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(roll_button).apply {
            setOnClickListener {
                setRandomDiceImage()
            }
        }

        findViewById<Button>(reset_button).apply {
            setOnClickListener { reset() }
        }
    }

    private fun setRandomDiceImage() {

        fun getDrawableResource() = when ((1..6).random()) {
            1 -> dice_1
            2 -> dice_2
            3 -> dice_3
            4 -> dice_4
            5 -> dice_5
            else -> dice_6
        }

        diceImageViewOne.setImageResource(getDrawableResource())
        diceImageViewTwo.setImageResource(getDrawableResource())
    }

    private fun reset() {
        diceImageViewOne.setImageResource(empty_dice)
        diceImageViewTwo.setImageResource(empty_dice)
    }
}
