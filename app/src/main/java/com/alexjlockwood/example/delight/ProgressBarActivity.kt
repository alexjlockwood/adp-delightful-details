package com.alexjlockwood.example.delight

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class ProgressBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progressbar)
        startProgressBar(R.id.circular_indeterminate_progress_medium)
        startProgressBar(R.id.horizontal_indeterminate_progress)
    }

    private fun startProgressBar(@IdRes progressBarId: Int) {
        ((findViewById<View>(progressBarId) as ImageView).drawable as Animatable).start()
    }
}