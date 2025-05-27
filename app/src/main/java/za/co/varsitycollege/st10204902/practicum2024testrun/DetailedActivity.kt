package za.co.varsitycollege.st10204902.practicum2024testrun

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)



        // Get the data from the intent
        val daysOfTheWeek = intent.getStringArrayExtra("days")
        val minTemperatures = intent.getIntArrayExtra("minTemps")
        val maxTemperatures = intent.getIntArrayExtra("maxTemps")
        val weatherConditions = intent.getStringArrayExtra("conditions")

        // Check if the data is not null
        val backBtn = findViewById<AppCompatButton>(R.id.backButton)
        val container = findViewById<LinearLayout>(R.id.scrollLinearLayout)

        backBtn.setOnClickListener {
            finish() // Same as reopening the previous activity
        }

        // Create new view objects for each day and associated fields to insert into the ScrollView
        // Creating a new view with multiple new TextViews for each day adding them to scrollview

        if(daysOfTheWeek!= null && minTemperatures != null && maxTemperatures != null && weatherConditions != null) {
            for (i in daysOfTheWeek.indices) {
                val dayLayout = LinearLayout(this).apply{
                    orientation = LinearLayout.VERTICAL
                    setPadding(32, 24, 32, 24)
                    setBackgroundColor("#F5F5F5".toColorInt())
                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(24, 16, 24, 16)
                    layoutParams = params
                }

                val dayTxt = TextView(this).apply {
                    text = daysOfTheWeek[i]
                    textSize = 24f
                    setTextColor("#333333".toColorInt())
                }

                val minTempTxt = TextView(this).apply {
                    text = "Min Temp: ${minTemperatures[i]}°C"
                    textSize = 18f
                    setTextColor("#555555".toColorInt())
                }

                val maxTempTxt = TextView(this).apply {
                    text = "Max Temp: ${maxTemperatures[i]}°C"
                    textSize = 18f
                    setTextColor("#555555".toColorInt())
                }

                val conditionTxt = TextView(this).apply {
                    text = "Condition: ${weatherConditions[i]}"
                    textSize = 18f
                    setTextColor("#555555".toColorInt())
                }

                dayLayout.addView(dayTxt)
                dayLayout.addView(minTempTxt)
                dayLayout.addView(maxTempTxt)
                dayLayout.addView(conditionTxt)
                container.addView(dayLayout)
            }
        }


    }
}