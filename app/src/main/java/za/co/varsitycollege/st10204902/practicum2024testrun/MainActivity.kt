package za.co.varsitycollege.st10204902.practicum2024testrun

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Variables
        val goButton = findViewById<AppCompatButton>(R.id.goButton)
        val exitButton = findViewById<AppCompatButton>(R.id.exitButton)

        //On Click Listener
        goButton.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity() // Close the app
        }


    }
}