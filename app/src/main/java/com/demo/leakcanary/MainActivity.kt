package com.demo.leakcanary

import android.app.ActivityManager
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var myBackground: Drawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val textView = TextView(this)
        textView.text = "Memory leaks are not good to applications"
        if (myBackground == null) {
            myBackground = getDrawable(R.drawable.ic_launcher_background)
        }
        textView.setBackgroundDrawable(myBackground)
        setContentView(textView)

        val am: ActivityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        Log.d("XXX", "dalvik.vm.heapgrowthlimit: " + am.memoryClass)
        Log.d("XXX", "dalvik.vm.heapsize: " + am.largeMemoryClass)
    }
}