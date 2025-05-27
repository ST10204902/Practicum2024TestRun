package za.co.varsitycollege.st10204902.practicum2024testrun

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)



        //Variables
        //Arrays
        val daysOfTheWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val minTemperatures = intArrayOf(15, 16, 14, 17, 18, 19, 20) //changed this
        val maxTemperatures = intArrayOf(25, 26, 24, 27, 28, 29, 30)// changed this
        val weatherConditions = arrayOf("Sunny", "Cloudy", "Rainy", "Windy", "Stormy", "Snowy", "Foggy")

        //Views
        val averageTempTxt = findViewById<TextView>(R.id.averageTempTxt)
        val detailedBtn = findViewById<AppCompatButton>(R.id.detailedViewBtn)
        val exitBtn = findViewById<AppCompatButton>(R.id.exitButton)

        val averageTempValue = getAverageTemperature(minTemperatures, maxTemperatures)
        averageTempTxt.text = "Average Temperature: ${averageTempValue}°C"

        detailedBtn.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("days", daysOfTheWeek)
            intent.putExtra("minTemps", minTemperatures)
            intent.putExtra("maxTemps", maxTemperatures)
            intent.putExtra("conditions", weatherConditions)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity() // Close the app
        }
    }

    fun getAverageTemperature(minTemps: IntArray, maxTemps: IntArray): Double {
        var totalMin = 0
        var totalMax = 0

        for (i in minTemps.indices) {
            totalMin += minTemps[i]
            totalMax += maxTemps[i]
        }

        val averageMin = totalMin / minTemps.size
        val averageMax = totalMax / maxTemps.size

        return (averageMin + averageMax) / 2.0
    }
}