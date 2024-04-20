package com.example.lovecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        showAlert()
        setContentView(binding.root)

        val firstName=findViewById(R.id.entUrName) as EditText
        val secondName=findViewById(R.id.entTheirName) as EditText
        val calculate=findViewById(R.id.calc) as Button
        val output=findViewById(R.id.result) as TextView

        calculate.setOnClickListener {
            val name1 = firstName.text.toString().trim()
            val name2 = secondName.text.toString().trim()

            if (name1.isNotEmpty() && name2.isNotEmpty()) {
                val lovePrecentage = calculateLovePercentage(name1, name2)
                output.text ="$lovePrecentage%"
            }
            else {
                output.text = "Enter a name"
            }
        }
    }
    private fun calculateLovePercentage(name1: String, name2: String): Int {
        val combinedNames = name1.toLowerCase() + name2.toLowerCase()
        var sum = 0
        for (char in combinedNames) {
            sum+= char.toInt()
        }
        val rand = java.util.Random(sum.toLong())
        return rand.nextInt(51) + 50
    }
    private fun showAlert() {
        val builder=AlertDialog.Builder(this)
        builder.setTitle("About")
            .setMessage("This Calculator shows compatibility and love percentage accordingly. The love calculator is an entertaining app that allows you to check the compatibility between two people by calculating a love percentage based on their names. Whether you want to know your love compatibility with your partner or just want to have some fun with your friends. This Love Calculator provides a light-hearted way to explore the dynamics between two individuals.")
            .setNegativeButton("Close") {
                dialog,which->
                dialog.dismiss()
            }
        val alertDialog:AlertDialog=builder.create()
        alertDialog.show()
    }
}
