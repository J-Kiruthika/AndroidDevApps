package com.example.luckydraw

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.luckydraw.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            Let the user roll the dice and ensure the activity

         */
        var rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            var diceImage1: ImageView = findViewById(R.id.dice1)
            var diceNumber1 : TextView = findViewById(R.id.textView1)
            var diceImage2 : ImageView = findViewById(R.id.dice2)
            var diceNumber2:TextView = findViewById(R.id.textView2)
            var resultMessage : TextView = findViewById(R.id.result)
            rollDice(diceImage1,diceNumber1)
            rollDice(diceImage2,diceNumber2)
            if(diceNumber1.text=="3" && diceNumber2.text=="5"){
                resultMessage.text = "Hurrah You win the draw"
            }
            else{
                resultMessage.text = "Oops roll again"
            }
            var toast = Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    /*
      Get the random result after rolling the dice

      Update the same in Image view
     */

    private fun rollDice(diceImage: ImageView, diceNumber: TextView) {


        var firstDice = Dice(6)
        var diceResult = firstDice.roll()
        var resultImage = when(diceResult){
            1 -> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(resultImage)

        diceNumber.text = diceResult.toString()
    }
}
/*
    To throw a new number while rolling the dice
 */
class Dice(var sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}