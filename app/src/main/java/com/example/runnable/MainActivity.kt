package com.example.runnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number : Int = 0
    var handler : Handler = Handler()
    var runnable : Runnable =  Runnable { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnStartOnclick(view: View) {
        number = 0
        runnable = object : Runnable {
            override fun run() {
                tv_couter.text = "Timer : $number"
                number++
                tv_couter.text = "Timer : $number"
                handler.postDelayed(this, 1000)
            }

        }
        handler.post(runnable)

        }


    fun btnStopOnclick(view: View) {
        handler.removeCallbacks(runnable)
        number = 0
        tv_couter.text = "Timer : $number"


    }
}