package com.example.topsoccerteams

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays
//logs the content of an array of strings
//fun  LogArrValues(array: Array<String>,limit: Int = 0){
//    if (limit == 0 ) {
//        Log.v( "Array Values", Arrays.toString(array))
//    }else {
//        Log.v ("Array Values", array.sliceArray
//            (0..limit - 1).contentToString())
//    }
//    Log.v("Array values: ", Arrays.toString(array))
//}

// Created function to find the shortest element in the array

fun getShortestString(array: Array<String>): String {
    var shortestLength = 0
    var shortestElement = ""
    for (element in array){
        if (element.count()> shortestLength){
         shortestLength = element.count()
            shortestElement = element
        }
    }
    return shortestElement
}

class MainActivity : AppCompatActivity() {
// Array storing soccer teams
   val teams =  arrayOf<String> ("Man Sundowns FC","Orlando Pirates","Sex United FC",
       "Cape Town City FC","Bidvest Wits FC")


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Linking the TextView to Kotlin
        val teamsTxt = findViewById<TextView>(R.id.TeamsView)
        // Variable to store the list of teams
        var teamsDisplay = ""
        //Count variable
        var Count = 0

        //Updating the first element of the array

        teams[0] = " Real Madrid"
// call the method to log to array values
//        LogArrValues(teams)
//        LogArrValues(teams,3)


        //Added loop to all teams to the display string
        for (team in teams){
            teamsDisplay += "${teams}\n"

        }

       //Display the final result in text view
        teamsTxt.text = Arrays.toString(teams)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}