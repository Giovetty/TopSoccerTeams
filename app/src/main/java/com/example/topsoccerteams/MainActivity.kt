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
       "Stellenbosh FC","Sivest Wits")

//   val names = arrayOf<String>("name1", "name2", "name3")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val teamsTxt = findViewById<TextView>(R.id.TeamsView)
        var teamsDisplay = ""
        var Count = 0

        teams[0] = " Real Madrid"

        LogArrValues(teams)
        LogArrValues(teams,3)

//        LogArrValues(names)



//        while (Count < teams.count()) {
//            teamsDisplay += "${teams[Count]}\n"
//            Count++
//
//          }
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