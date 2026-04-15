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
fun  LogArrValues(array: Array<String>,limit: Int = 0){
    if (limit == 0 ) {
        Log.v( "Array Values", Arrays.toString(array))
    }else {
        Log.v ("Array Values", array.sliceArray
            (0..limit - 1).contentToString())
    }
    Log.v("Array values: ", Arrays.toString(array))
}


class MainActivity : AppCompatActivity() {

   val teams =  arrayOf<String> ("Man Sundowns FC","Orlando Pirates","Sex United FC",
       "Cape Town City FC","Bidvest Wits FC")

//   val names = arrayOf<String>("name1", "name2", "name3")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
// added teams text view
        val teamsTxt = findViewById<TextView>(R.id.TeamsView)
        var teamsDisplay = ""
        var Count = 0

        teams[0] = " Real Madrid"
// call the method to log to array values
        LogArrValues(teams)
        LogArrValues(teams,3)

        //Added loop to all teams to the display string

        for (team in teams){
            teamsDisplay += "${teams}\n"
        }


        teamsTxt.text = Arrays.toString(teams)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}