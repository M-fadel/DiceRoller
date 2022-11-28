    package com.mohammed.diceroller

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Button
    import android.widget.TextView
    import android.widget.Toast
    import android.widget.ImageView
    import com.mohammed.diceroller.R.drawable.dice_1
//    import com.mohammed.diceroller.R.id.imageView
    import org.w3c.dom.Text

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val roll :Button= findViewById(R.id.button)
            val tex :TextView = findViewById(R.id.textView)
            val img :ImageView= findViewById(R.id.imageView)

            roll.setOnClickListener {
            rollDice()

            }
        }
        fun changeImg(){

        }
        fun rollDice(){
            val d =Dice(6)
            d.roll()
            val result:TextView = findViewById(R.id.textView)
            result.text =d.roll().toString()
            val toast = Toast.makeText(this, "You Rolled ${result.text} !", Toast.LENGTH_SHORT)
            toast.show()
            val img :ImageView= findViewById(R.id.imageView)

            val imgre = when(d.roll()){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else-> R.drawable.dice_6
            }
            img.setImageResource(imgre)

        }
    }
    class Dice(val sides :Int){
        fun roll (): Int {
            val rand = (1..sides).random()
            return rand

        }
    }