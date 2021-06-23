package com.example.ciclo_vida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            Log.i("Ciclo de vida", "on CREATE")
        }

        override fun onStart() {
            super.onStart()
            Log.i("ciclo de vida", "ON START")
        }

        override fun onResume() {
            super.onResume()
            Log.i("ciclo de vida","On Resume")
        }

        override fun onPause() {
            super.onPause()
            Log.i("ciclo de vida","On Pause")
        }

        override fun onStop() {
            super.onStop()
            Log.i("ciclo de vida","On Stop")
        }

    override fun onDestroy() {
        super.onDestroy()

            Log.i("ciclo de vida","On Stop")
        }
}