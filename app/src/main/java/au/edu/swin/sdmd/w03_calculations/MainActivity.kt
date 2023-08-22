package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val equals = findViewById<Button>(R.id.equals)
        val resText = findViewById<TextView>(R.id.answer)

        // Check Which CheckBox is ticked
        val plusCheck = findViewById<CheckBox>(R.id.plusCheck)
        val multCheck = findViewById<CheckBox>(R.id.multCheck)


        plusCheck.setOnClickListener {
            if (multCheck.isChecked) {
                multCheck.isChecked = false
            }
        }

        multCheck.setOnClickListener {
            if (plusCheck.isChecked) {
                plusCheck.isChecked = false
            }
        }

        equals.setOnClickListener {
            if ((number1 == null) || (number2 == null)) {
                resText.setText("Please enter value")
            } else {
                if (plusCheck.isChecked) {
                    val result = add(number1.text.toString(), number2.text.toString())
                    resText.setText(result)
                } else if (multCheck.isChecked) {
                    val result = mult(number1.text.toString(), number2.text.toString())
                    resText.setText(result)
                } else {
                    val result = "Please choose to Plus or Multiple"
                    resText.setText(result)
                }
            }
            // TODO: show result on the screen
//            findViewById<TextView>(R.id.answer).setText(result)
        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) =  (number1.toFloat() + number2.toFloat()).toString()
    private fun mult(number1: String,number2: String) = (number1.toFloat() * number2.toFloat()).toString()
}