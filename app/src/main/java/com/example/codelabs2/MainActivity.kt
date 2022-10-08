package com.example.codelabs2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Crear un Objeto Dado con 6 caras y tirarlo, para determinar que sale
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Seleccionar la imagen de la vista
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determinar cual id del recurso usar en base al tiro del dado
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Actualiar la vista de imagen con el correcto id del recurso
        diceImage.setImageResource(drawableResource)

        // Actualizar el contenido de la descripción
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}